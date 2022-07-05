package net.immortaldevs.azzy.core;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AzazelsCore implements ModInitializer, ClientModInitializer {

    public static final String MOD_ID_CORE = "azazels_core";

    public static final Logger LOGGER = LoggerFactory.getLogger("Azazel's Mods");


    @Override
    public void onInitialize() {
        CoreItemGroup.INSTANCE.initialize();
    }

    @Override
    public void onInitializeClient() {

    }

    public static Identifier locate(String id) {
        return new Identifier(MOD_ID_CORE, id);
    }
}
