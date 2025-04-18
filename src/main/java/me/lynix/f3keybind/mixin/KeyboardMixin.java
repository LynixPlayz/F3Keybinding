package me.lynix.f3keybind.mixin;

import me.lynix.f3keybind.client.F3KeybindClient;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    private final MinecraftClient client = MinecraftClient.getInstance();
    @Inject(method = "onKey", at = @At("HEAD"))
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        if(Objects.equals(F3KeybindClient.keyBinding.getBoundKeyTranslationKey(), "key.keyboard.unknown")) return;
        if (window == this.client.getWindow().getHandle()) {
            KeyboardAccessor keyboardAccessor = (KeyboardAccessor) MinecraftClient.getInstance().keyboard;
            boolean switchF3State = keyboardAccessor.getSwitchF3State();
            boolean bl = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), InputUtil.fromTranslationKey(F3KeybindClient.keyBinding.getBoundKeyTranslationKey()).getCode());
            InputUtil.Key key2 = InputUtil.fromKeyCode(key, scancode);
            if (action == 1) {
                KeyBinding.setKeyPressed(key2, false);
                if (key == InputUtil.fromTranslationKey(F3KeybindClient.keyBinding.getBoundKeyTranslationKey()).getCode()) {
                    if (switchF3State) {
                        switchF3State = false;
                    } else {
                        this.client.getDebugHud().toggleDebugHud();
                    }
                }
            } else {
                /*if (key == 293 && this.client.gameRenderer != null) {
                    this.client.gameRenderer.togglePostProcessorEnabled();
                }*/

                boolean bl4 = false;
                /*if (key == 256) {
                    this.client.openGameMenu(bl);
                    bl4 |= bl;
                }*/

                bl4 |= bl && keyboardAccessor.invokeProcessF3(key);
                switchF3State |= bl4;
                /*if (key == 290) {
                    this.client.options.hudHidden = !this.client.options.hudHidden;
                }*/

                if (this.client.getDebugHud().shouldShowRenderingChart() && !bl && key >= 48 && key <= 57) {
                    this.client.getDebugHud().getPieChart().select(key - 48);
                }
            }
        }
    }
}
