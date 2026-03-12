package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.SoundType;


public class BlockDragonBall3 extends BlockDragonBall {
    public BlockDragonBall3() {
        super(Properties.of()
            .strength(2.0f, 2.0f)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .requiresCorrectToolForDrops());
    }
}
