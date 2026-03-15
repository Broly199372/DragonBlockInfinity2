package com.bernardo.dbi.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.bernardo.dbi.client.renderer.provider.MouthTextureProvider;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import com.mojang.blaze3d.vertex.VertexConsumer;

public class MouthLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    public MouthLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent) {
        super(parent);
    }

    @Override
    public void render(
        PoseStack poseStack,
        MultiBufferSource buffer,
        int light,
        AbstractClientPlayer player,
        float limbSwing,
        float limbSwingAmount,
        float partialTicks,
        float ageInTicks,
        float netHeadYaw,
        float headPitch
    ) {

        ResourceLocation mouth = MouthTextureProvider.getMouthTexture(player);

        VertexConsumer vertex = buffer.getBuffer(RenderType.entityCutoutNoCull(mouth));

        this.getParentModel().renderToBuffer(
            poseStack,
            vertex,
            light,
            OverlayTexture.NO_OVERLAY,
            1f,1f,1f,1f
        );
    }
}
