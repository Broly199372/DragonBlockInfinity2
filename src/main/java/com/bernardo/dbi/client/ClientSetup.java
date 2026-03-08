package com.bernardo.dbi.client;

import com.bernardo.dbi.Dbi;
import com.bernardo.dbi.client.renderer.DBIPlayerRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = Dbi.MOD_ID,
        value = Dist.CLIENT,
        bus   = Mod.EventBusSubscriber.Bus.MOD
)
public class ClientSetup {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Substitui o renderer padrão do player pelo nosso
        // que troca a skin pela textura da raça
        event.registerEntityRenderer(EntityType.PLAYER,
                ctx -> new DBIPlayerRenderer(ctx, false));
    }
}
