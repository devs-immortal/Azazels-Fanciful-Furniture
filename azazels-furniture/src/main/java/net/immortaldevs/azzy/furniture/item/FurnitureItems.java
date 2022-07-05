package net.immortaldevs.azzy.furniture.item;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.id.incubus_core.util.RegistryQueue;
import net.immortaldevs.azzy.core.CoreItemGroup;
import net.immortaldevs.azzy.furniture.block.FurnitureBlocks;
import net.immortaldevs.azzy.furniture.misc.FurnitureRegistryQueues;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import static net.immortaldevs.azzy.furniture.AzazelsFurniture.*;

public class FurnitureItems {


    /**
     * BlockItem spam my beloved
     */

    // Tables
    public static final BlockItem OAK_TABLE = add(FurnitureBlocks.OAK_TABLE, new OwoItemSettings().group(CoreItemGroup.INSTANCE).tab(0));


    public static void register() {
        FurnitureRegistryQueues.ITEM.register();
    }

    @SafeVarargs
    private static <I extends Item> I add(String name, I item, RegistryQueue.Action<? super I> ... additionalActions) {
        return FurnitureRegistryQueues.ITEM.add(locate(name), item, additionalActions);
    }

    @SafeVarargs
    private static BlockItem add(Block block, OwoItemSettings settings, RegistryQueue.Action<? super BlockItem> ... additionalActions) {
        return FurnitureRegistryQueues.ITEM.add(block.getRegistryEntry().registryKey().getValue(), new BlockItem(block, settings), additionalActions);
    }
}
