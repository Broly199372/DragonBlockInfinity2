package com.bernardo.dbi.world;

import com.bernardo.dbi.blocks.BlockDragonBall;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ShenronSummon {

    // Padrão relativo ao centro:
    // . X X
    // X C X
    // . X X
    private static final int[][] PATTERN = {
        { 0,  0},  // centro (C)
        {-1,  0},  // esquerda
        { 1,  0},  // direita
        { 0, -1},  // frente
        { 0,  1},  // atrás
        { 1, -1},  // frente-direita
        { 1,  1},  // atrás-direita
    };

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        if (level.isClientSide()) return;

        BlockPos center = event.getPos();
        BlockState centerState = level.getBlockState(center);

        // Só ativa se clicar em uma esfera do dragão
        if (!(centerState.getBlock() instanceof BlockDragonBall)) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Verifica se todas as 7 posições do padrão têm esferas
        for (int[] offset : PATTERN) {
            BlockPos check = center.offset(offset[0], 0, offset[1]);
            if (!(level.getBlockState(check).getBlock() instanceof BlockDragonBall)) {
                return; // padrão incompleto
            }
        }

        // Padrão completo! Remove todas as esferas
        for (int[] offset : PATTERN) {
            BlockPos pos = center.offset(offset[0], 0, offset[1]);
            level.removeBlock(pos, false);
        }

        // Spawna o Shenlong no centro (você conecta depois)
        spawnShenron((ServerLevel) level, center, event.getEntity());

        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);

        // Reagenda o spawn das esferas depois de 5 minutos (6000 ticks)
        DragonBallSpawner.scheduleRespawn((ServerLevel) level, 6000);
    }

    private static void spawnShenron(ServerLevel level, BlockPos pos, Player player) {
        // TODO: spawnar entidade Shenlong aqui quando estiver pronto
        // level.addFreshEntity(new EntityShenron(level, pos));
        player.sendSystemMessage(
            net.minecraft.network.chat.Component.literal("§6✦ As Esferas do Dragão foram reunidas! Shenlong está chegando... ✦")
        );
    }
}
