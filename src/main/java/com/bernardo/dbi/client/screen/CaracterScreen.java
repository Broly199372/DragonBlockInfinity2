package com.bernardo.dbi.client.screen;

import com.bernardo.dbi.capability.PlayerRaceCap;
import com.bernardo.dbi.client.screen.widget.BtnLeft;
import com.bernardo.dbi.client.screen.widget.BtnRight;
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
        "Sayajin", "Namekian", "Half-Sayajin", "Arcosiano", "Humano"
    );

    private int guiLeft, guiTop, menuW, menuH;
    private int raceIndex = 0;

    private BtnLeft  btnLeft;
    private BtnRight btnRight;

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
                int idx = RACES.indexOf(cap.getRace());
                if (idx >= 0) this.raceIndex = idx;
            });
        }

        int panelCenterX = guiLeft + (int)(menuW * 0.16f);
        int btnY = guiTop + (int)(menuH * 0.08f);

        btnLeft  = new BtnLeft (panelCenterX - 30, btnY, () -> cycleRace(-1));
        btnRight = new BtnRight(panelCenterX + 14, btnY, () -> cycleRace(+1));

        this.addRenderableWidget(btnLeft);
        this.addRenderableWidget(btnRight);
    }

    private void cycleRace(int dir) {
        raceIndex = (raceIndex + dir + RACES.size()) % RACES.size();
        String selectedRace = RACES.get(raceIndex);

        Player player = Minecraft.getInstance().player;
        if (player != null) {
            player.getCapability(PlayerRaceCap.RACE_CAP).ifPresent(cap -> {
                cap.setAll(selectedRace, RACE_NAMES.get(raceIndex),
                    cap.getFormIdx(), cap.getHairStyle(), cap.getAgeIdx(),
                    cap.getBodyTypeIdx(), cap.getNoseIdx(), cap.getMouthIdx(),
                    cap.getEyeIdx(), cap.getBodyColor(), cap.getHairColor(), cap.getEyeColor());
            });
            ModNetwork.sendToServer(new RaceSelectionPacket(
                selectedRace, 0, 0, 0, 0, 0, 0, 0,
                0xFFD2956E, 0xFF1A1A1A, 0xFF1A1A1A));
        }
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(g);

        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        g.blit(MENU, guiLeft, guiTop, menuW, menuH, 0, 0, IMG_W, IMG_H, TEX_W, TEX_H);

        // Player com renderEntityInInventoryFollowsMouse
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            int panelCenterX = guiLeft + (int)(menuW * 0.16f);
            int panelCenterY = guiTop  + (int)(menuH * 0.60f);
            int scale        = (int)(menuH * 0.22f);

            InventoryScreen.renderEntityInInventoryFollowsMouse(
                g, panelCenterX, panelCenterY, scale,
                mouseX, mouseY,
                (net.minecraft.world.entity.LivingEntity) player);
        }

        g.drawCenteredString(this.font,
            Component.literal("✦ Criação de Personagem ✦"),
            guiLeft + menuW / 2, guiTop + 8, 0xFFD700);

        int panelCenterX = guiLeft + (int)(menuW * 0.16f);
        int nameY = guiTop + (int)(menuH * 0.08f) + 4;
        g.drawCenteredString(this.font,
            Component.literal(RACE_NAMES.get(raceIndex)),
            panelCenterX, nameY, 0xFFD700);

        super.render(g, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() { return false; }
}
