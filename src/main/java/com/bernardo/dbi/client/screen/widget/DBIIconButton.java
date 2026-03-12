package com.bernardo.dbi.client.screen.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class DBIIconButton extends AbstractWidget {

    private static final ResourceLocation ICONS = new ResourceLocation(
            "dragonblockinfinity", "textures/gui/icons_btn.png");
    private static final int TEX_W = 512;
    private static final int TEX_H = 512;

    // Tamanho real do icone principal (20x15)
    private static final int ICON_W    = 20;
    private static final int ICON_H    = 15;
    private static final int HALF_W    = ICON_W / 2;  // 10
    private static final int HALF_H    = ICON_H / 2;  // 7

    // Tamanho real do icone secundario (20x20)
    private static final int ICON_W_SEC = 20;
    private static final int ICON_H_SEC = 20;
    private static final int HALF_W_SEC = ICON_W_SEC / 2; // 10
    private static final int HALF_H_SEC = ICON_H_SEC / 2; // 10

    // Centros V de cada estado principal (centerV = v_topo + HALF_H)
    private static final int CV_NORMAL  = 30 + 7;  // 37
    private static final int CV_HOVER   = 45 + 7;  // 52
    private static final int CV_PRESSED = 60 + 7;  // 67

    // Centros V de cada estado secundario
    private static final int CV_SEC_DISABLED = 92  + 10; // 102
    private static final int CV_SEC_NORMAL   = 112 + 10; // 122
    private static final int CV_SEC_PRESSED  = 132 + 10; // 142

    private final Icon    icon;
    private final OnPress onPress;
    private boolean       pressed = false;

    // Enum usa centerU = centro horizontal do icone no atlas
    public enum Icon {
        LEFT_BIG   ( 10, false),  // U=0,  center=10
        RIGHT_BIG  ( 30, false),  // U=20, center=30
        LEFT       ( 50, false),  // U=40, center=50
        RIGHT      ( 70, false),  // U=60, center=70
        UP         ( 90, false),  // U=80, center=90
        DOWN       (110, false),  // U=100,center=110
        REWIND     (130, false),
        FAST_FWD   (150, false),
        SKIP_BACK  (170, false),
        SKIP_FWD   (190, false),
        CHECK_BIG  (210, false),
        DIAMOND    (230, false),
        CLOSE      (250, false),
        CIRCLE     (270, false),
        BAR_1      (290, false),
        BAR_2      (310, false),
        CIRCLE_SM  (330, false),
        BAR_1_SM   (350, false),
        BAR_2_SM   (370, false),
        PLUS       ( 11, true),   // secondary centerU=11
        MINUS      ( 33, true);   // secondary centerU=33

        final int  cu; // centerU no atlas
        final boolean secondary;
        Icon(int cu, boolean secondary) {
            this.cu        = cu;
            this.secondary = secondary;
        }
    }

    @FunctionalInterface
    public interface OnPress {
        void onPress(DBIIconButton button);
    }

    public DBIIconButton(int x, int y, Icon icon, OnPress onPress) {
        super(x, y,
              icon.secondary ? ICON_W_SEC : ICON_W,
              icon.secondary ? ICON_H_SEC : ICON_H,
              Component.empty());
        this.icon    = icon;
        this.onPress = onPress;
    }

    public void setPressed(boolean pressed) { this.pressed = pressed; }
    public boolean isPressed() { return this.pressed; }

    @Override
    public void renderWidget(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        if (!this.visible) return;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(1f, 1f, 1f, this.active ? 1f : 0.45f);

        if (this.icon.secondary) renderSecondary(g);
        else                     renderMain(g);

        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
    }

    private void renderMain(GuiGraphics g) {
        int cv;
        if (this.pressed) {
            cv = this.isHoveredOrFocused() ? CV_PRESSED + 7 : CV_PRESSED;
        } else if (this.isHoveredOrFocused()) {
            cv = CV_HOVER;
        } else {
            cv = CV_NORMAL;
        }
        // converte centro -> canto superior esquerdo para o blit
        int u = this.icon.cu - HALF_W;
        int v = cv - HALF_H;
        g.blit(ICONS, this.getX(), this.getY(), u, v, ICON_W, ICON_H, TEX_W, TEX_H);
    }

    private void renderSecondary(GuiGraphics g) {
        int cv;
        if (!this.active) {
            cv = CV_SEC_DISABLED;
        } else if (this.isHoveredOrFocused() || this.pressed) {
            cv = CV_SEC_PRESSED;
        } else {
            cv = CV_SEC_NORMAL;
        }
        int u = this.icon.cu - HALF_W_SEC;
        int v = cv - HALF_H_SEC;
        g.blit(ICONS, this.getX(), this.getY(), u, v, ICON_W_SEC, ICON_H_SEC, TEX_W, TEX_H);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        if (this.active) this.onPress.onPress(this);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput output) {
        this.defaultButtonNarrationText(output);
    }
}
