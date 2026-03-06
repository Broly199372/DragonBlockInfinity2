package com.bernardo.dbi.client.keybind;

import com.bernardo.dbi.client.screen.CaracterScreen;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = "dragonblockinfinity", value = Dist.CLIENT)
public class ModKeyBindings {

    public static final String KEY_CATEGORY = "key.categories.dbi";
    public static final String KEY_MENU_NAME = "key.dbi.open_menu";

    public static final KeyMapping OPEN_CHARACTER_MENU = new KeyMapping(
            KEY_MENU_NAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_V, // Tecla V
            KEY_CATEGORY
    );

    @SubscribeEvent
    public static void onKeyInput(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            while (OPEN_CHARACTER_MENU.consumeClick()) {
                Minecraft.getInstance().setScreen(new CaracterScreen());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = "dragonblockinfinity", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(OPEN_CHARACTER_MENU);
        }
    }
}
