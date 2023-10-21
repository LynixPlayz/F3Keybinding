package me.lynix.f3keybind.helpers;

import me.lynix.f3keybind.mixin.DebugHudAccessor;
import net.minecraft.client.MinecraftClient;

public class BoolUtils {
    public static void setDebugHud(boolean value) {
        if( ((DebugHudAccessor)MinecraftClient.getInstance().getDebugHud()).getShowDebugHud() == value ) return;
        MinecraftClient.getInstance().getDebugHud().toggleDebugHud();
    }
}
