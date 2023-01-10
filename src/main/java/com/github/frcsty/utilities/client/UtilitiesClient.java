package com.github.frcsty.utilities.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import org.lwjgl.glfw.GLFW;

public final class UtilitiesClient implements ClientModInitializer {

    private static final KeyBinding UN_FOCUS_WINDOW_BINDING = KeyBindingHelper.registerKeyBinding(new StickyKeyBinding(
            "key.utilities.un_focus", GLFW.GLFW_KEY_Y,
            "category.utilities.custom_options", () -> false
    ));

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            if (UN_FOCUS_WINDOW_BINDING.isPressed()) {
                client.mouse.unlockCursor();
            }
        });
    }

}
