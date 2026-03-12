package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockNamekDirty extends Block {
    public BlockNamekDirty() {
        super(BlockBehaviour.Properties.of()
            .strength(0.5f)
            .sound(SoundType.GRAVEL));
    }
}
