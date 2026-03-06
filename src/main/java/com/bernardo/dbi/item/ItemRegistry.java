package com.bernardo.dbi.item;

import com.bernardo.dbi.Dbi;
import com.bernardo.dbi.block.BlockRegistry;
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

    public static final RegistryObject<Item> DB1 = ITEMS.register("dragon_block_1_earth", () -> new BlockItem(BlockRegistry.DRAGON_BLOCK_1_EARTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> DB2 = ITEMS.register("dragon_block_2_earth", () -> new BlockItem(BlockRegistry.DRAGON_BLOCK_2_EARTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> DB3 = ITEMS.register("dragon_block_3_earth", () -> new BlockItem(BlockRegistry.DRAGON_BLOCK_3_EARTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> DB4 = ITEMS.register("dragon_block_4_earth", () -> new BlockItem(BlockRegistry.DRAGON_BLOCK_4_EARTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> DB5 = ITEMS.register("dragon_block_5_earth", () -> new BlockItem(BlockRegistry.DRAGON_BLOCK_5_EARTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> DB6 = ITEMS.register("dragon_block_6_earth", () -> new BlockItem(BlockRegistry.DRAGON_BLOCK_6_EARTH.get(), new Item.Properties()));
    public static final RegistryObject<Item> DB7 = ITEMS.register("dragon_block_7_earth", () -> new BlockItem(BlockRegistry.DRAGON_BLOCK_7_EARTH.get(), new Item.Properties()));
    
    public static final RegistryObject<Item> NAMEK_GRASS = ITEMS.register("namek_grass", () -> new BlockItem(BlockRegistry.NAMEK_GRASS.get(), new Item.Properties()));
    public static final RegistryObject<Item> NAMEK_DIRTY = ITEMS.register("namek_dirty", () -> new BlockItem(BlockRegistry.NAMEK_DIRTY.get(), new Item.Properties()));
    public static final RegistryObject<Item> DIRTY_STONE = ITEMS.register("dirty_stone_cobblestone", () -> new BlockItem(BlockRegistry.DIRTY_STONE_COBBLESTONE.get(), new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> DBI_TAB = TABS.register("dbi_tab", () -> CreativeModeTab.builder()
        .title(Component.literal("Dragon Block Infinity"))
        .icon(() -> new ItemStack(DB1.get()))
        .displayItems((parameters, output) -> {
            output.accept(DB1.get());
            output.accept(DB2.get());
            output.accept(DB3.get());
            output.accept(DB4.get());
            output.accept(DB5.get());
            output.accept(DB6.get());
            output.accept(DB7.get());
            output.accept(NAMEK_GRASS.get());
            output.accept(NAMEK_DIRTY.get());
            output.accept(DIRTY_STONE.get());
        }).build());
}
