package net.immortaldevs.azzy.core.actions;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.id.incubus_core.util.RegistryQueue;
import net.minecraft.block.Block;

public class CoreBlockActions {

    public static RegistryQueue.Action<Block> flammable(int spread, int burn) { return (id, block) -> FlammableBlockRegistry.getDefaultInstance().add(block, spread, burn);}

    public static final RegistryQueue.Action<Block> flammableLog = flammable(5, 5);
    public static final RegistryQueue.Action<Block> flammablePlanks = flammable(20, 5);
    public static final RegistryQueue.Action<Block> flammableLeaves = flammable(60, 30);
    public static final RegistryQueue.Action<Block> flammablePlant = flammable(60, 100);
}
