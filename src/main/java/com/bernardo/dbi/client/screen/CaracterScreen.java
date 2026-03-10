package com.bernardo.dbi.client.screen;

import com.bernardo.dbi.capability.PlayerRaceCap;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.joml.Quaternionf;

public class CaracterScreen extends Screen {

    private static final ResourceLocation MENU = new ResourceLocation(
            "dragonblockinfinity", "textures/gui/menu.png");

    private static final int TEX_W = 512;
    private static final int TEX_H = 512;
    private static final int IMG_W = 510;
    private static final int IMG_H = 318;

    private int guiLeft, guiTop, menuW, menuH;
    private String selectedRace = "";

    public CaracterScreen() {
        super(Component.literal("Criação de Personagem"));
    }

    @Override
    protected void init() {
        super.init();

        float ratio = Math.min(
            (this.width  * 0.75f) / IMG_W,
            (this.height * 0.75f) / IMG_H
        );
        menuW = (int)(IMG_W * ratio);
        menuH = (int)(IMG_H * ratio);

        guiLeft = (this.width  - menuW) / 2;
        guiTop  = (this.height - menuH) / 2;

        Player player = Minecraft.getInstance().player;
        if (player != null) {
            player.getCapability(PlayerRaceCap.RACE_CAP).ifPresent(cap ->
                    this.selectedRace = cap.getRace());
        }
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(g);

        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        g.blit(MENU, guiLeft, guiTop, menuW, menuH, 0, 0, IMG_W, IMG_H, TEX_W, TEX_H);

        renderPlayerPanel(g, mouseX, mouseY);

        g.drawCenteredString(this.font,
                Component.literal("✦ Criação de Personagem ✦"),
                guiLeft + menuW / 2, guiTop + 8, 0xFFD700);

        if (!selectedRace.isEmpty()) {
            String raceName = selectedRace
                    .replace("dragonblockinfinity:", "")
                    .replace("_", " ");
            raceName = raceName.substring(0, 1).toUpperCase() + raceName.substring(1);
            g.drawCenteredString(this.font, Component.literal(raceName),
                    guiLeft + (int)(menuW * 0.16f), guiTop + menuH - 20, 0xFFFFFF);
        }

        super.render(g, mouseX, mouseY, partialTick);
    }

    private void renderPlayerPanel(GuiGraphics g, int mouseX, int mouseY) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        int panelCenterX = guiLeft + (int)(menuW * 0.16f);
        int panelCenterY = guiTop  + (int)(menuH * 0.68f);
        int scale        = (int)(menuH * 0.22f);

        float dx = (float)(panelCenterX - mouseX);
        float dy = (float)(guiTop + menuH * 0.25f - mouseY);

        Quaternionf rotY = new Quaternionf()
                .rotateZ((float) Math.PI)
                .rotateY((float) Math.atan2(dx, 120f));
        Quaternionf rotX = new Quaternionf()
                .rotateX((float) Math.atan2(dy, 120f));

        InventoryScreen.renderEntityInInventory(g, panelCenterX, panelCenterY, scale, rotY, rotX, player);
    }

    @Override
    public boolean isPauseScreen() { return false; }
}
