package com.bernardo.dbi.client.renderer.provider;

import com.bernardo.dbi.capability.PlayerRaceCap;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;

public class HairTextureProvider {

    public static ResourceLocation getHairTexture(AbstractClientPlayer player) {

        return player.getCapability(PlayerRaceCap.RACE_CAP).map(cap -> {

            int hair = cap.getHair();

            return new ResourceLocation(
                "dragonblockinfinity",
                "textures/hairs/" + hair + ".png"
            );

        }).orElse(
            new ResourceLocation("dragonblockinfinity","textures/hairs/0.png")
        );

    }

}
