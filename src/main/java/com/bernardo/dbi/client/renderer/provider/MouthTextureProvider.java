package com.bernardo.dbi.client.renderer.provider;

import com.bernardo.dbi.capability.PlayerRaceCap;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;

public class MouthTextureProvider {

    public static ResourceLocation getMouthTexture(AbstractClientPlayer player) {

        return player.getCapability(PlayerRaceCap.RACE_CAP).map(cap -> {

            int mouth = cap.getMouth();

            return new ResourceLocation(
                "dragonblockinfinity",
                "textures/mouth/" + mouth + ".png"
            );

        }).orElse(
            new ResourceLocation("dragonblockinfinity","textures/mouth/0.png")
        );

    }

}
