package com.bernardo.dbi.blocks;

import com.bernardo.dbi.Dbi;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Dbi.MOD_ID);

    public static final RegistryObject<Block> DRAGON_BALL_1          = BLOCKS.register("block_dragonball1",         BlockDragonBall1::new);
    public static final RegistryObject<Block> DRAGON_BALL_2          = BLOCKS.register("block_dragonball2",         BlockDragonBall2::new);
    public static final RegistryObject<Block> DRAGON_BALL_3          = BLOCKS.register("block_dragonball3",         BlockDragonBall3::new);
    public static final RegistryObject<Block> DRAGON_BALL_4          = BLOCKS.register("block_dragonball4",         BlockDragonBall4::new);
    public static final RegistryObject<Block> DRAGON_BALL_5          = BLOCKS.register("block_dragonball5",         BlockDragonBall5::new);
    public static final RegistryObject<Block> DRAGON_BALL_6          = BLOCKS.register("block_dragonball6",         BlockDragonBall6::new);
    public static final RegistryObject<Block> DRAGON_BALL_7          = BLOCKS.register("block_dragonball7",         BlockDragonBall7::new);
    public static final RegistryObject<Block> NAMEK_GRASS            = BLOCKS.register("namek_grass",               BlockNamekGrass::new);
    public static final RegistryObject<Block> NAMEK_DIRTY            = BLOCKS.register("namek_dirty",               BlockNamekDirty::new);
    public static final RegistryObject<Block> DIRTY_STONE            = BLOCKS.register("dirty_stone",               BlockDirtyStone::new);
    public static final RegistryObject<Block> DIRTY_STONE_COBBLESTONE = BLOCKS.register("dirty_stone_cobblestone",  BlockDirtyStoneCobblestone::new);
}
