package com.bernardo.dbi.blocks;

import net.minecraft.world.level.block.SoundType;


public class BlockDragonBall5 extends BlockDragonBall {
    public BlockDragonBall5() {
        super(Properties.of()
            .strength(2.5f, 2.5f)
            .sound(SoundType.GLASS)
            .noOcclusion()
            .requiresCorrectToolForDrops());
    }
}
