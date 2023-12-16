package net.magnesnasamice;

import net.fabricmc.api.ClientModInitializer;
import net.magnesnasamice.event.ModKeyInputHandler;

public class InitClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModKeyInputHandler.register();
    }
}
