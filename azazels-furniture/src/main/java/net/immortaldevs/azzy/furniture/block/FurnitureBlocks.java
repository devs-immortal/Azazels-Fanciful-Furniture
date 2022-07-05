package net.immortaldevs.azzy.furniture.block;


import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.id.incubus_core.util.RegistryQueue;
import net.immortaldevs.azzy.furniture.misc.FurnitureRegistryQueues;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import static net.immortaldevs.azzy.furniture.AzazelsFurniture.*;
import static net.immortaldevs.azzy.core.actions.CoreBlockActions.*;
import static net.immortaldevs.azzy.furniture.block.FurnitureBlockActions.*;

public class FurnitureBlocks {

    private static FabricBlockSettings settingsOf(Block block) {
        return FabricBlockSettings.copyOf(block);
    }

    private static RegistryQueue.Action<Block> defaultLocale(String name) {
        return ((identifier, block) -> RESOURCE_SIGNATURE.EN_US.block(identifier, name));
    }

    public static final TableBlock OAK_TABLE = add("oak_table", new TableBlock(settingsOf(Blocks.OAK_WOOD)), flammableLog, createTableAssets, defaultLocale("Oak Table"));

    @SafeVarargs
    private static <B extends Block> B add(String name, B block, RegistryQueue.Action<? super B> ... additionalActions) {
        return FurnitureRegistryQueues.BLOCK.add(locate(name), block, additionalActions);
    }

    public static void register() {
        FurnitureRegistryQueues.BLOCK.register();
    }

}
