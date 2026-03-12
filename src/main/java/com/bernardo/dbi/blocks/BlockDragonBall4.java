package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.SoundType;


public class BlockDragonBall4 extends BlockDragonBall {
    public BlockDragonBall4() {
        super(Properties.of()
            .strength(1.5f, 1.5f)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .requiresCorrectToolForDrops());
    }
}
