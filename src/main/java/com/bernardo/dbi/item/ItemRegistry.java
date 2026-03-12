package com.bernardo.dbi.item;

import com.bernardo.dbi.Dbi;
import com.bernardo.dbi.blocks.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dbi.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Dbi.MOD_ID);

    public static final RegistryObject<Item> DRAGON_BALL_1           = ITEMS.register("block_dragonball1",        () -> new BlockItem(BlockRegistry.DRAGON_BALL_1.get(),           new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_BALL_2           = ITEMS.register("block_dragonball2",        () -> new BlockItem(BlockRegistry.DRAGON_BALL_2.get(),           new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_BALL_3           = ITEMS.register("block_dragonball3",        () -> new BlockItem(BlockRegistry.DRAGON_BALL_3.get(),           new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_BALL_4           = ITEMS.register("block_dragonball4",        () -> new BlockItem(BlockRegistry.DRAGON_BALL_4.get(),           new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_BALL_5           = ITEMS.register("block_dragonball5",        () -> new BlockItem(BlockRegistry.DRAGON_BALL_5.get(),           new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_BALL_6           = ITEMS.register("block_dragonball6",        () -> new BlockItem(BlockRegistry.DRAGON_BALL_6.get(),           new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_BALL_7           = ITEMS.register("block_dragonball7",        () -> new BlockItem(BlockRegistry.DRAGON_BALL_7.get(),           new Item.Properties()));
    public static final RegistryObject<Item> NAMEK_GRASS             = ITEMS.register("namek_grass",              () -> new BlockItem(BlockRegistry.NAMEK_GRASS.get(),             new Item.Properties()));
    public static final RegistryObject<Item> NAMEK_DIRTY             = ITEMS.register("namek_dirty",              () -> new BlockItem(BlockRegistry.NAMEK_DIRTY.get(),             new Item.Properties()));
    public static final RegistryObject<Item> DIRTY_STONE             = ITEMS.register("dirty_stone",              () -> new BlockItem(BlockRegistry.DIRTY_STONE.get(),             new Item.Properties()));
    public static final RegistryObject<Item> DIRTY_STONE_COBBLESTONE = ITEMS.register("dirty_stone_cobblestone",  () -> new BlockItem(BlockRegistry.DIRTY_STONE_COBBLESTONE.get(), new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> DBI_TAB = TABS.register("dbi_tab", () -> CreativeModeTab.builder()
        .title(Component.literal("Dragon Block Infinity"))
        .icon(() -> new ItemStack(DRAGON_BALL_1.get()))
        .displayItems((parameters, output) -> {
            output.accept(DRAGON_BALL_1.get());
            output.accept(DRAGON_BALL_2.get());
            output.accept(DRAGON_BALL_3.get());
            output.accept(DRAGON_BALL_4.get());
            output.accept(DRAGON_BALL_5.get());
            output.accept(DRAGON_BALL_6.get());
            output.accept(DRAGON_BALL_7.get());
            output.accept(NAMEK_GRASS.get());
            output.accept(NAMEK_DIRTY.get());
            output.accept(DIRTY_STONE.get());
            output.accept(DIRTY_STONE_COBBLESTONE.get());
        }).build());
}
