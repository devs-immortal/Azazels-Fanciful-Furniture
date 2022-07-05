package net.immortaldevs.azzy.furniture.misc;

import net.id.incubus_core.util.RegistryQueue;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class FurnitureRegistryQueues {

    public static final RegistryQueue<Block> BLOCK = new RegistryQueue<>(Registry.BLOCK, 64);

    public static final RegistryQueue<Item> ITEM = new RegistryQueue<>(Registry.ITEM, 64);
}
