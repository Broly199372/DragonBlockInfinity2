package com.bernardo.dbi.client.screen.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class IconButton extends Button {

    protected static final ResourceLocation TEXTURE =
        new ResourceLocation("dragonblockinfinity","textures/gui/icons_btn.png");

    protected final int u;
    protected final int vNormal;
    protected final int vPressed;

    public IconButton(int x, int y, int u, int vNormal, int vPressed, OnPress press) {
        super(x, y, 22, 32, Component.empty(), press, DEFAULT_NARRATION);
        this.u = u;
        this.vNormal = vNormal;
        this.vPressed = vPressed;
    }

    @Override
    protected void renderWidget(GuiGraphics g, int mouseX, int mouseY, float partialTick) {

        RenderSystem.setShaderTexture(0, TEXTURE);

        int v = this.isPressed() ? vPressed : vNormal;

        g.blit(TEXTURE, this.getX(), this.getY(), u, v, 22, 32, 512, 512);
    }
}
