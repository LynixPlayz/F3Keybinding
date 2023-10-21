package me.lynix.f3keybind.client;

import me.lynix.f3keybind.helpers.BoolUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class F3KeybindClient implements ClientModInitializer {
    public static KeyBinding keyBinding;
    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.f3keybind.f3toggle", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                144, // The keycode of the key
                "key.categories.misc" // The translation key of the keybinding's category.
        ));
        /*ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                MinecraftClient.getInstance().getDebugHud().toggleDebugHud();
                if(InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 292))
            }
        });
        NOTE: This is handled in KeyboardMixin.java now.
         */
    }
}
