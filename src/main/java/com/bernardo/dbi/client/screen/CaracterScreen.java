package com.bernardo.dbi.client.screen;

import com.bernardo.dbi.capability.PlayerRaceCap;
import com.bernardo.dbi.client.screen.widget.DBIIconButton;
import com.bernardo.dbi.network.ModNetwork;
import com.bernardo.dbi.network.packet.RaceSelectionPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.joml.Quaternionf;

import java.util.List;

public class CaracterScreen extends Screen {

    private static final ResourceLocation MENU = new ResourceLocation(
            "dragonblockinfinity", "textures/gui/menu.png");

    private static final int TEX_W = 512;
    private static final int TEX_H = 512;
    private static final int IMG_W = 510;
    private static final int IMG_H = 318;

    private static final List<String> RACES = List.of(
        "dragonblockinfinity:sayajin",
        "dragonblockinfinity:namekian",
        "dragonblockinfinity:half_sayajin",
        "dragonblockinfinity:arconsian",
        "dragonblockinfinity:humano"
    );

    private static final List<String> RACE_NAMES = List.of(
        "Sayajin",
        "Namekian",
        "Half-Sayajin",
        "Arcosiano",
        "Humano"
    );

    private int guiLeft, guiTop, menuW, menuH;
    private String selectedRace = "";
    private int raceIndex = 0;

    private DBIIconButton btnLeft;
    private DBIIconButton btnRight;

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
            player.getCapability(PlayerRaceCap.RACE_CAP).ifPresent(cap -> {
                this.selectedRace = cap.getRace();
                int idx = RACES.indexOf(cap.getRace());
                if (idx >= 0) this.raceIndex = idx;
            });
        }

        int panelCenterX = guiLeft + (int)(menuW * 0.16f);
        int btnY = guiTop + (int)(menuH * 0.08f);

        btnLeft  = new DBIIconButton(panelCenterX - 30, btnY, DBIIconButton.Icon.LEFT,  b -> cycleRace(-1));
        btnRight = new DBIIconButton(panelCenterX + 14, btnY, DBIIconButton.Icon.RIGHT, b -> cycleRace(+1));

        this.addRenderableWidget(btnLeft);
        this.addRenderableWidget(btnRight);
    }

    private void cycleRace(int dir) {
        raceIndex = (raceIndex + dir + RACES.size()) % RACES.size();
        selectedRace = RACES.get(raceIndex);

        Player player = Minecraft.getInstance().player;
        if (player != null) {
            player.getCapability(PlayerRaceCap.RACE_CAP).ifPresent(cap -> {
                cap.setAll(selectedRace, RACE_NAMES.get(raceIndex),
                    cap.getFormIdx(), cap.getHairStyle(), cap.getAgeIdx(),
                    cap.getBodyTypeIdx(), cap.getNoseIdx(), cap.getMouthIdx(),
                    cap.getEyeIdx(), cap.getBodyColor(), cap.getHairColor(), cap.getEyeColor());
            });

            ModNetwork.sendToServer(new RaceSelectionPacket(
                selectedRace,
                0, 0, 0, 0, 0, 0, 0,
                0xFFD2956E, 0xFF1A1A1A, 0xFF1A1A1A
            ));
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

        int panelCenterX = guiLeft + (int)(menuW * 0.16f);
        int nameY = guiTop + (int)(menuH * 0.08f) + 4;
        String raceName = RACE_NAMES.isEmpty() ? "" : RACE_NAMES.get(raceIndex);
        g.drawCenteredString(this.font, Component.literal(raceName),
                panelCenterX, nameY, 0xFFD700);

        super.render(g, mouseX, mouseY, partialTick);
    }

    private void renderPlayerPanel(GuiGraphics g, int mouseX, int mouseY) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        int panelCenterX = guiLeft + (int)(menuW * 0.16f);
        int panelCenterY = guiTop  + (int)(menuH * 0.60f);
        int scale        = (int)(menuH * 0.22f);

        float lookX = panelCenterX - mouseX;
        float lookY = (guiTop + (menuH * 0.3f)) - mouseY;

        Quaternionf bodyRotation = new Quaternionf()
                .rotateY((float)Math.PI)
                .rotateY((float)Math.atan2(lookX, 120f));
        Quaternionf cameraRotation = new Quaternionf()
                .rotateX((float)Math.atan2(lookY, 120f));

        InventoryScreen.renderEntityInInventory(g, panelCenterX, panelCenterY, scale, bodyRotation, cameraRotation, (net.minecraft.world.entity.LivingEntity) player);
    }

    @Override
    public boolean isPauseScreen() { return false; }
}
