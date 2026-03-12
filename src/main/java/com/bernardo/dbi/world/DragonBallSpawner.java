package com.bernardo.dbi.world;

import com.bernardo.dbi.blocks.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber
public class DragonBallSpawner {

    private static boolean spawned = false;
    private static int respawnCountdown = -1;

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;
        if (!level.dimension().equals(net.minecraft.world.level.Level.OVERWORLD)) return;
        if (spawned) return;

        level.getServer().execute(() -> spawnAllBalls(level));
    }

    // Chamado a cada tick do servidor para contar o respawn
    @SubscribeEvent
    public static void onServerTick(net.minecraftforge.event.TickEvent.ServerTickEvent event) {
        if (event.phase != net.minecraftforge.event.TickEvent.ServerTickEvent.Phase.END) return;
        if (respawnCountdown < 0) return;

        respawnCountdown--;
        if (respawnCountdown == 0) {
            respawnCountdown = -1;
            spawned = false;

            // Pega o overworld e spawna de novo
            event.getServer().getAllLevels().forEach(level -> {
                if (level.dimension().equals(net.minecraft.world.level.Level.OVERWORLD)) {
                    spawnAllBalls(level);
                }
            });
        }
    }

    public static void scheduleRespawn(ServerLevel level, int ticks) {
        respawnCountdown = ticks;
    }

    public static void spawnAllBalls(ServerLevel level) {
        if (spawned) return;
        spawned = true;

        Random rand = new Random();
        Block[] balls = {
            BlockRegistry.DRAGON_BALL_1.get(),
            BlockRegistry.DRAGON_BALL_2.get(),
            BlockRegistry.DRAGON_BALL_3.get(),
            BlockRegistry.DRAGON_BALL_4.get(),
            BlockRegistry.DRAGON_BALL_5.get(),
            BlockRegistry.DRAGON_BALL_6.get(),
            BlockRegistry.DRAGON_BALL_7.get()
        };

        for (int i = 0; i < 7; i++) {
            int x = (rand.nextInt(2000) - 1000);
            int z = (rand.nextInt(2000) - 1000);

            level.getChunk(x >> 4, z >> 4);

            int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
            int spawnY   = surfaceY - 40 - rand.nextInt(20);

            if (spawnY < level.getMinBuildHeight() + 5) {
                spawnY = level.getMinBuildHeight() + 10;
            }

            BlockPos pos = new BlockPos(x, spawnY, z);
            level.setBlock(pos, balls[i].defaultBlockState(), 3);
        }
    }
}
