package net.magnesnasamice.sound;

import net.magnesnasamice.Init;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent NOTEBOOK_OPEN = registerSound("notebook_open");
    public static final SoundEvent NOTEBOOK_CLOSE = registerSound("notebook_close");

    private static SoundEvent registerSound(String name) {
        Identifier id = new Identifier(Init.MOD_ID, name);
        Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

        return SoundEvent.of(id);
    }
    public static void registerSounds() {
        Init.LOGGER.info("Registering sounds.");
    }
}
