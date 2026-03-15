package com.bernardo.dbi.client.renderer.provider;

import com.bernardo.dbi.capability.PlayerRaceCap;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;

public class NoseTextureProvider {

    public static ResourceLocation getNoseTexture(AbstractClientPlayer player) {

        return player.getCapability(PlayerRaceCap.RACE_CAP).map(cap -> {

            int nose = cap.getNose();

            return new ResourceLocation(
                "dragonblockinfinity",
                "textures/nose/" + nose + ".png"
            );

        }).orElse(
            new ResourceLocation("dragonblockinfinity","textures/nose/0.png")
        );

    }

}
