package com.bernardo.dbi.client.renderer;

import net.minecraft.resources.ResourceLocation;

public class RaceTextureProvider {

    private static final ResourceLocation BASE =
        new ResourceLocation("dragonblockinfinity", "textures/races/base.png");
    private static final ResourceLocation NAMEKIAN =
        new ResourceLocation("dragonblockinfinity", "textures/races/namekian.png");
    private static final ResourceLocation ARCONSIAN =
        new ResourceLocation("dragonblockinfinity", "textures/races/arconsian.png");

    public static ResourceLocation getTexture(String race) {
        if (race == null) return BASE;
        switch (race) {
            case "dragonblockinfinity:namekian": return NAMEKIAN;
            case "dragonblockinfinity:arconsian": return ARCONSIAN;
            default: return BASE;
        }
    }
}
