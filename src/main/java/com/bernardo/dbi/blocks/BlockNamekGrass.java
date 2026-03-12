package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockNamekGrass extends Block {
    public BlockNamekGrass() {
        super(BlockBehaviour.Properties.of()
            .strength(0.6f)
            .sound(SoundType.GRASS)
            .noOcclusion());
    }
}
