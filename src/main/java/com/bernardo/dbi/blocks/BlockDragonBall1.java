package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.SoundType;


public class BlockDragonBall1 extends BlockDragonBall {
    public BlockDragonBall1() {
        super(Properties.of()
            .strength(0.5f, 0.5f)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .requiresCorrectToolForDrops());
    }
}
