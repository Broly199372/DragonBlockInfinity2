package com.bernardo.dbi.event;

import com.bernardo.dbi.Dbi;
import com.bernardo.dbi.block.DragonBlockBase;
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

import java.util.List;

@EventBusSubscriber(modid = Dbi.MOD_ID, bus = EventBusSubscriber.Bus.FORGE)
public class BlockInteractionHandler {

    // Multipliers por material (madeira, pedra, ferro, diamante, netherite)
    private static float materialMultiplier(int level) {
        switch (level) {
            case 0: return 0.6f; // wood / gold
            case 1: return 1.0f; // stone
            case 2: return 1.4f; // iron
            case 3: return 1.8f; // diamond
            case 4: return 2.2f; // netherite
            default: return 1.0f;
        }
    }

    private static float toolTypeMultiplier(Item item) {
        if (item instanceof PickaxeItem) return 1.0f;
        if (item instanceof AxeItem) return 0.8f;
        if (item instanceof ShovelItem) return 0.6f;
        return 0.35f; // mão ou item qualquer
    }

    /**
     * Ajusta a velocidade de quebra conforme ferramenta e material.
     */
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        if (player == null) return;

        // event provides the block state directly, no need to query world
        BlockState state = event.getState();
        Block block = state.getBlock();
        if (!(block instanceof DragonBlockBase)) return;

        Item held = player.getMainHandItem().getItem();

        float toolMult = toolTypeMultiplier(held);
        int tierLevel = 1;
        if (held instanceof TieredItem) {
            try {
                tierLevel = ((TieredItem) held).getTier().getLevel();
            } catch (Exception ignored) {}
        }
        float matMult = materialMultiplier(tierLevel);

        // Ajuste simples: nova velocidade = velocidade atual * toolMult * matMult
        float newSpeed = event.getNewSpeed() * toolMult * matMult;
        event.setNewSpeed(newSpeed);
    }

    /**
     * Controla os drops: se quebrado na mão e o bloco não permite, remove drops.
     */
    @SubscribeEvent
    public static void onBlockHarvestDrops(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;

        BlockState state = event.getState(); // already correct
        Block block = state.getBlock();
        if (!(block instanceof DragonBlockBase)) return;

        DragonBlockBase db = (DragonBlockBase) block;

        boolean hand = player.getMainHandItem().isEmpty();
        if (hand && !db.allowHandDrops()) {
            // Cancelar drops removendo as entidades de item do mundo
            // Simplesmente cancelar o evento evita drops padrão
            event.setCanceled(true);
        }
    }
}
