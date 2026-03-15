package com.bernardo.dbi.client.renderer.provider;

import com.bernardo.dbi.capability.PlayerRaceCap;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;

public class EyesTextureProvider {

    public static ResourceLocation getEyesTexture(AbstractClientPlayer player) {

        return player.getCapability(PlayerRaceCap.RACE_CAP).map(cap -> {

            int eyes = cap.getEyes();

            return new ResourceLocation(
                "dragonblockinfinity",
                "textures/eyes/" + eyes + ".png"
            );

        }).orElse(
            new ResourceLocation("dragonblockinfinity","textures/eyes/0.png")
        );

    }

}
