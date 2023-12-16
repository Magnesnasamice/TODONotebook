package net.magnesnasamice.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.magnesnasamice.Init;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup creativeTab = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Init.MOD_ID, "creative_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.todonote.creative_tab"))
                    .icon(() -> new ItemStack(ModItems.NOTEBOOK)).entries(((displayContext, entries) -> {
                        // items
                        entries.add(ModItems.NOTEBOOK);

                    })).build()
    );

    public static void registerItemGroups() {
        Init.LOGGER.info("Registering item groups.");
    }
}
