package xyz.Desyncd.i_use_arch_btw.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW

class I_use_arch_btwClient : ClientModInitializer {

    override fun onInitializeClient() {
        val btwKey = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "I Use Arch, BTW",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                "I Use Arch, BTW"
            )
        )

        ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick {
            while (btwKey.wasPressed()) {
                MinecraftClient.getInstance().networkHandler?.sendChatMessage("I Use Arch, BTW")
            }
        })
    }
}
