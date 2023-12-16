package net.magnesnasamice.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.magnesnasamice.HUD.NotebookScreen;
import net.magnesnasamice.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.inventory.Inventory;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class ModKeyInputHandler {
    public static final String KEY_CATEGORY_TODONOTE = "key.todonote.keybindCategory";
    public static final String KEY_OPEN_CONFIG = "key.todonote.open_notebook";

    // keybinds
    public static KeyBinding openConfigKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // open config screen
            if (openConfigKey.wasPressed()) {
                if (doesPlayerHaveNotebook(client)) {
                    client.setScreen(new NotebookScreen());
                } else {
                    client.player.sendMessage(Text.translatable("message.todonote.no_notebook_in_inventory"));
                }
            }
        });
    }

    public static void register() {
        openConfigKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_OPEN_CONFIG,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATEGORY_TODONOTE
        ));

        registerKeyInputs();
    }

    private static boolean doesPlayerHaveNotebook(MinecraftClient mc) {
        Inventory inv = mc.player.getInventory();
        for (int i = 0; i < inv.size(); i++) {
            if (inv.getStack(i).isOf(ModItems.NOTEBOOK)) return true;
        }
        return false;
    }
}
