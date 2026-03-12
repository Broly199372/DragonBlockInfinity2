package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.SoundType;


public class BlockDragonBall7 extends BlockDragonBall {
    public BlockDragonBall7() {
        super(Properties.of()
            .strength(4.0f, 4.0f)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .requiresCorrectToolForDrops());
    }
}
