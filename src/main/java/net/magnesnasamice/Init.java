package net.magnesnasamice;

import net.fabricmc.api.ModInitializer;

import net.magnesnasamice.item.ModItemGroups;
import net.magnesnasamice.item.ModItems;
import net.magnesnasamice.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Init implements ModInitializer {
	public static final String MOD_ID = "todonote";
    public static final Logger LOGGER = LoggerFactory.getLogger("Todo Notebook");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModSounds.registerSounds();
		ModItems.registerItems();
	}
}