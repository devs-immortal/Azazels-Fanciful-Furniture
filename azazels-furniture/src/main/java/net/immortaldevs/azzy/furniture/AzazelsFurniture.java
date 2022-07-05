package net.immortaldevs.azzy.furniture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.id.incubus_core.util.RegistryQueue;
import net.immortaldevs.azzy.core.AzazelsCore;
import net.immortaldevs.azzy.core.datagen.DatagenUtil;
import net.immortaldevs.azzy.core.datagen.ResourceSignature;
import net.immortaldevs.azzy.furniture.block.FurnitureBlocks;
import net.immortaldevs.azzy.furniture.item.FurnitureItems;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

public class AzazelsFurniture implements ModInitializer, ClientModInitializer {

    public static final String MOD_ID_FURNITURE = "azazels_furniture";
    public static final ResourceSignature RESOURCE_SIGNATURE = ResourceSignature.of(MOD_ID_FURNITURE);


    @Override
    public void onInitialize() {
        AzazelsCore.LOGGER.info(" ~ Functional Furniture module found! ~");
        AzazelsCore.LOGGER.info("Initializing furniture...");

        FurnitureBlocks.register();
        FurnitureItems.register();

        AzazelsCore.LOGGER.info("Comfyness instantiated and registered - Functional Furniture successfully initialized!");
    }

    @Override
    public void onInitializeClient() {

    }

    public static Identifier locate(String name) {
        return new Identifier(MOD_ID_FURNITURE, name);
    }
}
