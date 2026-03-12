package com.bernardo.dbi;

import com.bernardo.dbi.network.ModNetwork;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModRegister {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(ModRegister::commonSetup);
        modEventBus.addListener(com.bernardo.dbi.client.ClientSetup::onRegisterRenderers);

        com.bernardo.dbi.blocks.BlockRegistry.BLOCKS.register(modEventBus);
        com.bernardo.dbi.item.ItemRegistry.ITEMS.register(modEventBus);
        com.bernardo.dbi.item.ItemRegistry.TABS.register(modEventBus);
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ModNetwork::register);
    }
}
