package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.SoundType;


public class BlockDragonBall6 extends BlockDragonBall {
    public BlockDragonBall6() {
        super(Properties.of()
            .strength(3.0f, 3.0f)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .requiresCorrectToolForDrops());
    }
}
