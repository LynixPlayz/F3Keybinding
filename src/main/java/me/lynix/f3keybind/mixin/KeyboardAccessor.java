package me.lynix.f3keybind.mixin;

import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Keyboard.class)
public interface KeyboardAccessor {
    @Accessor
    boolean getSwitchF3State();

    @Invoker
    boolean invokeProcessF3(int key);
}
