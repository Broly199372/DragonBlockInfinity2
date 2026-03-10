package com.bernardo.dbi.client;

import com.bernardo.dbi.Dbi;
import com.bernardo.dbi.client.renderer.DBIPlayerRenderer;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Dbi.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
            (EntityType<AbstractClientPlayer>) (EntityType<?>) EntityType.PLAYER,
            ctx -> new DBIPlayerRenderer(ctx, false)
        );
    }
}
