package com.bernardo.dbi.client.renderer;

import com.bernardo.dbi.capability.PlayerRaceCap;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class DBIPlayerRenderer extends PlayerRenderer {

    public DBIPlayerRenderer(EntityRendererProvider.Context ctx, boolean slim) {
        super(ctx, slim);
    }

    @Override
    public ResourceLocation getTextureLocation(Player player) {
        // Pega a raça salva na capability e retorna a textura correta
        return player.getCapability(PlayerRaceCap.RACE_CAP)
                .map(cap -> RaceTextureProvider.getTexture(cap.getRace()))
                .orElse(RaceTextureProvider.getTexture(""));
    }
}
