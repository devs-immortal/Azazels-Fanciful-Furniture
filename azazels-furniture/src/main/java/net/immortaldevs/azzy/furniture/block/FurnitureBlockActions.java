package net.immortaldevs.azzy.furniture.block;

import net.id.incubus_core.util.RegistryQueue.Action;
import net.immortaldevs.azzy.furniture.AzazelsFurniture;
import net.minecraft.block.Block;

import static net.immortaldevs.azzy.furniture.datagen.FurnitureModelGen.*;
import static net.immortaldevs.azzy.core.datagen.DatagenUtil.*;

public class FurnitureBlockActions {

    public static final Action<Block> createTableAssets = ((identifier, block) -> createTable((TableBlock) block));

    public static final Action<Block> selfDrop = ((identifier, block) -> lootSelfDrop(block, AzazelsFurniture.RESOURCE_SIGNATURE));
}
