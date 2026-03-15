package com.bernardo.dbi.world;

import com.bernardo.dbi.blocks.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.*;
import java.util.List;
import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber
public class DragonBallSpawner {

    private static final String FILE_NAME = "dragonballs_spawned.dat";

    private static final List<RegistryObject<Block>> BALLS = List.of(
        BlockRegistry.DRAGON_BALL_1,
        BlockRegistry.DRAGON_BALL_2,
        BlockRegistry.DRAGON_BALL_3,
        BlockRegistry.DRAGON_BALL_4,
        BlockRegistry.DRAGON_BALL_5,
        BlockRegistry.DRAGON_BALL_6,
        BlockRegistry.DRAGON_BALL_7
    );

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;
        if (!level.dimension().equals(Level.OVERWORLD)) return;

        Path saveDir  = level.getServer().getWorldPath(LevelResource.ROOT).resolve("data");
        Path flagFile = saveDir.resolve(FILE_NAME);

        if (Files.exists(flagFile)) return;

        level.getServer().execute(() -> {
            try {
                Random rand = new Random();
                for (RegistryObject<Block> ball : BALLS) {
                    int x = rand.nextInt(2000) - 1000;
                    int z = rand.nextInt(2000) - 1000;
                    int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, x, z) + 1;
                    level.setBlock(new BlockPos(x, y, z),
                        ball.get().defaultBlockState(), 3);
                }
                Files.createDirectories(saveDir);
                Files.writeString(flagFile, "spawned");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void scheduleRespawn(ServerLevel level, int ticks) {
        resetFlag(level);
    }

    public static void resetFlag(ServerLevel level) {
        Path flagFile = level.getServer()
            .getWorldPath(LevelResource.ROOT)
            .resolve("data").resolve(FILE_NAME);
        try { Files.deleteIfExists(flagFile); } catch (Exception ignored) {}
    }
}
