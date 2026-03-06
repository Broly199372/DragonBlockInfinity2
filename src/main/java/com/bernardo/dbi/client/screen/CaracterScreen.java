package com.bernardo.dbi.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class CaracterScreen extends Screen {
    // Caminhos das suas texturas do projeto DBI
    private static final ResourceLocation Menu = new ResourceLocation("dragonblockinfinity", "textures/gui/menu.png");
    private static final ResourceLocation ICONES = new ResourceLocation("dragonblockinfinity", "textures/gui/icons_btn.png");

    // Medidas reais que você passou: 510x318 dentro de um arquivo 512x512
    private final int MENU_W = 510;
    private final int MENU_H = 318;
    private final int TEX_SIZE = 512;

    private int guiLeft, guiTop;

    public CaracterScreen() {
        super(Component.literal("Menu Clássico DBI"));
    }

    @Override
    protected void init() {
        super.init();
        // Centraliza o menu na tela do jogador
        this.guiLeft = (this.width - MENU_W) / 2;
        this.guiTop = (this.height - MENU_H) / 2;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        // 1. Desenha o fundo escuro padrão do Minecraft
        this.renderBackground(guiGraphics);

        // 2. Renderiza o Menu Clássico (510x318)
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        guiGraphics.blit(Menu, this.guiLeft, this.guiTop, 0, 0, MENU_W, MENU_H, TEX_SIZE, TEX_SIZE);

        // 3. Exemplo: Renderizar o ícone "X" da sua tabela (Pixel 320, 32)
        // Vamos colocar ele no canto superior direito do seu menu
        int fecharX = this.guiLeft + MENU_W - 40;
        int fecharY = this.guiTop + 10;
        guiGraphics.blit(ICONES, fecharX, fecharY, 320, 32, 32, 32, TEX_SIZE, TEX_SIZE);

        // 4. Feedback Visual: Se o mouse estiver em cima do "X", desenha um brilho
        if (mouseX >= fecharX && mouseX <= fecharX + 32 && mouseY >= fecharY && mouseY <= fecharY + 32) {
            guiGraphics.fill(fecharX, fecharY, fecharX + 32, fecharY + 32, 0x55FFFFFF);
        }

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Lógica de clique para o botão "X"
        int fecharX = this.guiLeft + MENU_W - 40;
        int fecharY = this.guiTop + 10;

        if (mouseX >= fecharX && mouseX <= fecharX + 32 && mouseY >= fecharY && mouseY <= fecharY + 32) {
            this.onClose(); // Faz acontecer: o menu fecha na hora!
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean isPauseScreen() {
        return false; // O jogo não pausa enquanto você customiza
    }
}
