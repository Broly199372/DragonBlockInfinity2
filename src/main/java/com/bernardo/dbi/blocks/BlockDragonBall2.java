package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.SoundType;


public class BlockDragonBall2 extends BlockDragonBall {
    public BlockDragonBall2() {
        super(Properties.of()
            .strength(1.0f, 1.0f)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .requiresCorrectToolForDrops());
    }
}
