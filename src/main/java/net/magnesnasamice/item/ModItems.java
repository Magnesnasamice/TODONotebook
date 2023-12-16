package net.magnesnasamice.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.magnesnasamice.Init;
import net.magnesnasamice.item.custom.Notebook;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item NOTEBOOK = registerItem("notebook",
            new Notebook(new FabricItemSettings().maxCount(1))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Init.MOD_ID, name), item);
    }
    public static void registerItems() {
        Init.LOGGER.info("Registering items.");
    }
}
