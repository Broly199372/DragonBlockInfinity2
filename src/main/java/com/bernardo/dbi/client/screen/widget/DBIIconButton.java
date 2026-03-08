package com.bernardo.dbi.client.screen.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/**
 * DBIIconButton — Botão de ícone do mod Dragon Block Infinity
 *
 * Atlas: textures/gui/icons_btn.png (512x512)
 *
 * ┌─────────────────────────────────────────────────────────────────────┐
 * │  MAPA DO ATLAS — ícones 20×15px cada                               │
 * ├────────┬────────────────────────────────────────────────────────────┤
 * │ V=0    │ Estado ACTIVE/CLICK  (ícones animados / diagonais)        │
 * │ V=15   │ Estado OVERLAY       (pontos/detalhes)                    │
 * │ V=30   │ Estado NORMAL        (fundo amarelo)                      │
 * │ V=45   │ Estado HOVER         (fundo azul)                         │
 * │ V=60   │ Estado PRESSED       (fundo creme/branco)                 │
 * │ V=75   │ Estado PRESSED+HOVER (creme + borda azul)                 │
 * ├────────┼────────────────────────────────────────────────────────────┤
 * │ ÍCONE  │ U offset (cada um 20px de largura)                        │
 * │ LEFT_BIG     │ U=0   — < (seta esquerda grande)                   │
 * │ RIGHT_BIG    │ U=20  — > (seta direita grande)                    │
 * │ LEFT         │ U=40  — < (seta esquerda pequena)                  │
 * │ RIGHT        │ U=60  — > (seta direita pequena)                   │
 * │ UP           │ U=80  — ^ (seta cima)                              │
 * │ DOWN         │ U=100 — v (seta baixo)                             │
 * │ REWIND       │ U=120 — << (voltar)                                │
 * │ FAST_FWD     │ U=140 — >> (avançar)                               │
 * │ SKIP_BACK    │ U=160 — K / |< (ir ao início)                      │
 * │ SKIP_FWD     │ U=180 — H / >| (ir ao fim)                         │
 * │ CHECK_BIG    │ U=200 — ✓ / X (grande, amarelo)                    │
 * │ DIAMOND      │ U=220 — ◆ (losango grande, amarelo)                │
 * │ CLOSE        │ U=240 — X (fechar)                                 │
 * │ CIRCLE       │ U=260 — O (círculo)                                │
 * │ BAR_1        │ U=280 — | (uma barra / stop)                       │
 * │ BAR_2        │ U=300 — || (duas barras / pause)                   │
 * │ CIRCLE_SM    │ U=320 — O (círculo pequeno)                        │
 * │ BAR_1_SM     │ U=340 — | (barra pequena)                          │
 * │ BAR_2_SM     │ U=360 — || (barras pequenas)                       │
 * ├────────────────────────────────────────────────────────────────────┤
 * │  BANDA SECUNDÁRIA — ícones especiais 20×20px (V=92~151)           │
 * │  V=92   DISABLED  │  V=112  NORMAL  │  V=132  PRESSED            │
 * │  U=0  → PLUS  (+) amarelo                                         │
 * │  U=22 → MINUS (–) vermelho                                        │
 * └────────────────────────────────────────────────────────────────────┘
 */
public class DBIIconButton extends AbstractWidget {

    // ── Textura ──────────────────────────────────────────────────────────────
    private static final ResourceLocation ICONS = new ResourceLocation(
            "dragonblockinfinity", "textures/gui/icons_btn.png");
    private static final int TEX_W = 512;
    private static final int TEX_H = 512;

    // ── Dimensões dos ícones principais ──────────────────────────────────────
    private static final int ICON_W = 20;
    private static final int ICON_H = 15;

    // ── Estados V no atlas principal ─────────────────────────────────────────
    private static final int V_ACTIVE  =  0;
    private static final int V_NORMAL  = 30;
    private static final int V_HOVER   = 45;
    private static final int V_PRESSED = 60;

    // ── Dimensões dos ícones secundários (Plus/Minus) ─────────────────────────
    private static final int ICON_W_SEC = 20;
    private static final int ICON_H_SEC = 20;
    private static final int V_SEC_DISABLED = 92;
    private static final int V_SEC_NORMAL   = 112;
    private static final int V_SEC_PRESSED  = 132;

    // ── Campos do botão ───────────────────────────────────────────────────────
    private final Icon    icon;
    private final OnPress onPress;
    private boolean       pressed = false; // estado de toggle, se necessário

    // =========================================================================
    //  Enum de ícones — U offset no atlas
    // =========================================================================
    public enum Icon {
        // Ícones principais (20×15px) ─────────────────────────────────────────
        LEFT_BIG   (  0, false),  // < grande
        RIGHT_BIG  ( 20, false),  // > grande
        LEFT       ( 40, false),  // < pequeno
        RIGHT      ( 60, false),  // > pequeno
        UP         ( 80, false),  // ^
        DOWN       (100, false),  // v
        REWIND     (120, false),  // <<
        FAST_FWD   (140, false),  // >>
        SKIP_BACK  (160, false),  // |<
        SKIP_FWD   (180, false),  // >|
        CHECK_BIG  (200, false),  // ✓ / X grande amarelo
        DIAMOND    (220, false),  // ◆ losango grande amarelo
        CLOSE      (240, false),  // X fechar
        CIRCLE     (260, false),  // O círculo
        BAR_1      (280, false),  // | stop
        BAR_2      (300, false),  // || pause
        CIRCLE_SM  (320, false),  // O pequeno
        BAR_1_SM   (340, false),  // | pequeno
        BAR_2_SM   (360, false),  // || pequeno

        // Ícones secundários (20×20px) ────────────────────────────────────────
        PLUS       (  0, true),   // + amarelo
        MINUS      ( 22, true);   // – vermelho

        final int  u;
        final boolean secondary;
        Icon(int u, boolean secondary) {
            this.u         = u;
            this.secondary = secondary;
        }
    }

    // =========================================================================
    //  Interface de clique
    // =========================================================================
    @FunctionalInterface
    public interface OnPress {
        void onPress(DBIIconButton button);
    }

    // =========================================================================
    //  Construtores
    // =========================================================================
    public DBIIconButton(int x, int y, Icon icon, OnPress onPress) {
        super(x, y,
              icon.secondary ? ICON_W_SEC : ICON_W,
              icon.secondary ? ICON_H_SEC : ICON_H,
              Component.empty());
        this.icon    = icon;
        this.onPress = onPress;
    }

    // Construtor com tooltip de texto (narração / acessibilidade)
    public DBIIconButton(int x, int y, Icon icon, String tooltip, OnPress onPress) {
        super(x, y,
              icon.secondary ? ICON_W_SEC : ICON_W,
              icon.secondary ? ICON_H_SEC : ICON_H,
              Component.literal(tooltip));
        this.icon    = icon;
        this.onPress = onPress;
    }

    // =========================================================================
    //  Toggle de estado "pressionado" (para botões de seleção/on-off)
    // =========================================================================
    public void setPressed(boolean pressed) { this.pressed = pressed; }
    public boolean isPressed() { return this.pressed; }

    // =========================================================================
    //  Renderização
    // =========================================================================
    @Override
    public void renderWidget(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        if (!this.visible) return;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(1f, 1f, 1f, this.active ? 1f : 0.45f);

        if (this.icon.secondary) {
            renderSecondary(g);
        } else {
            renderMain(g);
        }

        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
    }

    /** Renderiza ícone da banda principal (20×15) */
    private void renderMain(GuiGraphics g) {
        int v;
        if (this.pressed) {
            v = this.isHovered ? V_PRESSED + 15 : V_PRESSED; // V=75 ou V=60
        } else if (this.isHovered) {
            v = V_HOVER;   // V=45 — fundo azul
        } else {
            v = V_NORMAL;  // V=30 — fundo amarelo
        }

        g.blit(ICONS,
               this.getX(), this.getY(),
               this.icon.u, v,
               ICON_W, ICON_H,
               TEX_W, TEX_H);
    }

    /** Renderiza ícone da banda secundária Plus/Minus (20×20) */
    private void renderSecondary(GuiGraphics g) {
        int v;
        if (!this.active) {
            v = V_SEC_DISABLED;   // V=92  — escuro
        } else if (this.isHovered || this.pressed) {
            v = V_SEC_PRESSED;    // V=132 — pressionado/hover
        } else {
            v = V_SEC_NORMAL;     // V=112 — normal
        }

        g.blit(ICONS,
               this.getX(), this.getY(),
               this.icon.u, v,
               ICON_W_SEC, ICON_H_SEC,
               TEX_W, TEX_H);
    }

    // =========================================================================
    //  Clique
    // =========================================================================
    @Override
    public void onClick(double mouseX, double mouseY) {
        if (this.active) {
            this.onPress.onPress(this);
        }
    }

    // =========================================================================
    //  Narração (acessibilidade)
    // =========================================================================
    @Override
    protected void updateWidgetNarration(NarrationElementOutput output) {
        this.defaultButtonNarrationText(output);
    }
}
