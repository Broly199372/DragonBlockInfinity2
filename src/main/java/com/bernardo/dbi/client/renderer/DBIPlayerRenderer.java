package com.bernardo.dbi.client.renderer;

import com.bernardo.dbi.capability.PlayerRaceCap;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;

public class DBIPlayerRenderer extends PlayerRenderer {

    private static final ResourceLocation FALLBACK =
        new ResourceLocation("minecraft", "textures/entity/player/wide/steve.png");

    public DBIPlayerRenderer(EntityRendererProvider.Context ctx, boolean slim) {
        super(ctx, slim);
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractClientPlayer player) {
        try {
            return player.getCapability(PlayerRaceCap.RACE_CAP)
                    .map(cap -> RaceTextureProvider.getTexture(cap.getRace()))
                    .orElse(FALLBACK);
        } catch (Exception e) {
            return FALLBACK;
        }
    }
}
