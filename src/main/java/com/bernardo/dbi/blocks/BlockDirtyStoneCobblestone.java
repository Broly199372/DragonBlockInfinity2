package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockDirtyStoneCobblestone extends Block {
    public BlockDirtyStoneCobblestone() {
        super(BlockBehaviour.Properties.of()
            .strength(2.0f, 6.0f)
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops());
    }
}
