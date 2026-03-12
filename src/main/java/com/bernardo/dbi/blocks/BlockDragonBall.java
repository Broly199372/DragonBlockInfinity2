package com.bernardo.dbi.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public abstract class BlockDragonBall extends Block {

    // Hitbox pequena centralizada no bloco (esfera)
    protected static final VoxelShape SHAPE = Block.box(4.25, 0.0, 4.25, 11.75, 6.75, 11.75);

    public BlockDragonBall(Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    // Clique direito com mão vazia ou qualquer item: pega a esfera automaticamente
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                  Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            ItemStack held = player.getItemInHand(hand);
            // Só pega se a mão estiver vazia ou com uma esfera igual
            if (held.isEmpty()) {
                level.removeBlock(pos, false);
                player.addItem(new ItemStack(this.asItem()));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    // Retorna o item ao quebrar
    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos,
                               BlockState state, net.minecraft.world.level.block.entity.BlockEntity be,
                               ItemStack tool) {
        super.playerDestroy(level, player, pos, state, be, tool);
    }

    // Não é cubo sólido (para renderizar hitbox pequena corretamente)
    @Override
    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }
}
