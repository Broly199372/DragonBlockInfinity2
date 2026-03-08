package com.bernardo.dbi.client.screen;

import com.bernardo.dbi.capability.PlayerRaceCap;
import com.bernardo.dbi.client.renderer.RaceTextureProvider;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class CaracterScreen extends Screen {

    // ── Texturas ─────────────────────────────────────────────────────────────
    private static final ResourceLocation MENU  = new ResourceLocation(
            "dragonblockinfinity", "textures/gui/menu.png");
    private static final ResourceLocation ICONS = new ResourceLocation(
            "dragonblockinfinity", "textures/gui/icons_btn.png");

    // ── Tamanho do menu ───────────────────────────────────────────────────────
    private static final int MENU_W   = 510;
    private static final int MENU_H   = 318;
    private static final int TEX_SIZE = 512;

    private int guiLeft, guiTop;

    // ── Mouse para rotação do model ───────────────────────────────────────────
    private float mouseX, mouseY;

    // ── Raça selecionada no momento ───────────────────────────────────────────
    private String selectedRace = "";

    public CaracterScreen() {
        super(Component.literal("Criação de Personagem"));
    }

    @Override
    protected void init() {
        super.init();
        this.guiLeft = (this.width  - MENU_W) / 2;
        this.guiTop  = (this.height - MENU_H) / 2;

        // Carrega a raça atual do player
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            player.getCapability(PlayerRaceCap.RACE_CAP).ifPresent(cap ->
                    this.selectedRace = cap.getRace());
        }
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;

        // 1. Fundo escuro do Minecraft
        this.renderBackground(g);

        // 2. Fundo do menu (menu.png)
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        g.blit(MENU,
               this.guiLeft, this.guiTop,
               0, 0,
               MENU_W, MENU_H,
               TEX_SIZE, TEX_SIZE);

        // 3. Painel esquerdo — preview do player 3D
        renderPlayerPanel(g, mouseX, mouseY);

        // 4. Título do menu
        g.drawCenteredString(this.font,
                Component.literal("✦ Criação de Personagem ✦"),
                this.guiLeft + MENU_W / 2,
                this.guiTop + 8,
                0xFFD700); // dourado

        // 5. Nome da raça selecionada abaixo do player
        if (!selectedRace.isEmpty()) {
            String raceName = selectedRace
                    .replace("dragonblockinfinity:", "")
                    .replace("_", " ");
            raceName = raceName.substring(0, 1).toUpperCase() + raceName.substring(1);
            g.drawCenteredString(this.font,
                    Component.literal(raceName),
                    this.guiLeft + 80,
                    this.guiTop + MENU_H - 30,
                    0xFFFFFF);
        }

        super.render(g, mouseX, mouseY, partialTick);
    }

    // ── Preview 3D do player ─────────────────────────────────────────────────
    private void renderPlayerPanel(GuiGraphics g, int mouseX, int mouseY) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        // Posição do player no painel esquerdo
        int centerX = this.guiLeft + 80;
        int centerY = this.guiTop  + 245;
        int scale   = 75;

        // Rotação suave acompanhando o mouse
        float dx = (float)(centerX - mouseX);
        float dy = (float)(this.guiTop + 80 - mouseY);

        Quaternionf rotY = new Quaternionf()
                .rotateZ((float) Math.PI)
                .rotateY((float) Math.atan2(dx, 120f));

        Quaternionf rotX = new Quaternionf()
                .rotateX((float) Math.atan2(dy, 120f));

        // Borda/sombra ao redor do preview (quadrado escuro semi-transparente)
        int px = centerX - 55;
        int py = this.guiTop + 18;
        g.fill(px - 2, py - 2, px + 112, py + 232, 0x55000000); // sombra
        g.fill(px,     py,     px + 110, py + 230, 0x33000000); // fundo

        // Borda dourada
        g.hLine(px,     px + 110, py,       0xFFD700);
        g.hLine(px,     px + 110, py + 230, 0xFFD700);
        g.vLine(px,     py, py + 230,       0xFFD700);
        g.vLine(px + 110, py, py + 230,     0xFFD700);

        // Renderiza o player 3D
        InventoryScreen.renderEntityInInventory(
                g,
                centerX, centerY,
                scale,
                new Vector3f(0f, 0f, 0f),
                rotY,
                rotX,
                player
        );
    }

    @Override
    public boolean mouseMoved(double mouseX, double mouseY) {
        this.mouseX = (float) mouseX;
        this.mouseY = (float) mouseY;
        return super.mouseMoved(mouseX, mouseY);
    }

    @Override
    public boolean isPauseScreen() { return false; }
}
