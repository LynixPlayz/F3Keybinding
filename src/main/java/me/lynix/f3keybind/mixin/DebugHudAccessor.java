package me.lynix.f3keybind.mixin;

import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DebugHud.class)
public interface DebugHudAccessor{
    @Accessor("showDebugHud")
    boolean getShowDebugHud();
}
