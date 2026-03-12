package com.bernardo.dbi.event;

import com.bernardo.dbi.Dbi;
import com.bernardo.dbi.blocks.BlockDragonBall;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Dbi.MOD_ID, bus = EventBusSubscriber.Bus.FORGE)
public class BlockInteractionHandler {

    private static float materialMultiplier(int level) {
        switch (level) {
            case 0: return 0.6f;
            case 1: return 1.0f;
            case 2: return 1.4f;
            case 3: return 1.8f;
            case 4: return 2.2f;
            default: return 1.0f;
        }
    }

    private static float toolTypeMultiplier(Item item) {
        if (item instanceof PickaxeItem) return 1.0f;
        if (item instanceof AxeItem)     return 0.8f;
        if (item instanceof ShovelItem)  return 0.6f;
        return 0.35f;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        if (player == null) return;

        BlockState state = event.getState();
        Block block = state.getBlock();
        if (!(block instanceof BlockDragonBall)) return;

        Item held = player.getMainHandItem().getItem();
        float toolMult = toolTypeMultiplier(held);
        int tierLevel = 1;
        if (held instanceof TieredItem) {
            try { tierLevel = ((TieredItem) held).getTier().getLevel(); }
            catch (Exception ignored) {}
        }
        event.setNewSpeed(event.getNewSpeed() * toolMult * materialMultiplier(tierLevel));
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;

        Block block = event.getState().getBlock();
        if (!(block instanceof BlockDragonBall)) return;

        // Quebrar com mão vazia não dropa (deve usar clique direito)
        if (player.getMainHandItem().isEmpty()) {
            event.setCanceled(true);
        }
    }
}
