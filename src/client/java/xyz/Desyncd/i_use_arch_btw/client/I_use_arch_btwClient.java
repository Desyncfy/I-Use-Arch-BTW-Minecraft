package xyz.Desyncd.i_use_arch_btw.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class I_use_arch_btwClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyBinding btwKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "i use arch btw",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                "i use arch btw"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (btwKey.wasPressed()) {
                Objects.requireNonNull(client.getNetworkHandler()).sendChatMessage("i use arch btw");
            }
        });
    }
}
