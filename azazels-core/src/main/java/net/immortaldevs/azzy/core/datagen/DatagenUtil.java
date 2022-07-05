package net.immortaldevs.azzy.core.datagen;

import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JLootTable;
import net.id.incubus_core.util.RegistryQueue;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class DatagenUtil {

    public static void lootSelfDrop(Block block, ResourceSignature signature) {
        var id = getBlockId(block);
        signature.resourcePack.addLootTable(splicePath(id, "blocks"), JLootTable.loot("minecraft:block").pool(
                        JLootTable.pool()
                                .rolls(1)
                                .bonus(0)
                                .entry(JLootTable.entry()
                                        .type("minecraft:item")
                                        .name(id.toString()))
                                .condition(JLootTable.predicate("minecraft:survives_explosion"))
                )
        );
    }

    public static Identifier splicePath(Identifier id, String insert) {
        return new Identifier(id.getNamespace(), insert + "/" + id.getPath());
    }

    public static Identifier appendPath(Identifier id, String insert) {
        return new Identifier(id.getNamespace(), id.getPath() + insert);
    }

    public static JState simpleState(Identifier model) {
        return JState.state(JState.variant(JState.model(model)));
    }

    public static Identifier fabric(String path) {
        return new Identifier("fabric", path);
    }

    public static Identifier common(String path) {
        return new Identifier("c", path);
    }

    public static Identifier vanilla(String path) {
        return new Identifier("minecraft", path);
    }

    public static Identifier getBlockId(Block block) {
        return block.getRegistryEntry().registryKey().getValue();
    }

    public static Identifier getItemId(Item item) {
        return item.getRegistryEntry().registryKey().getValue();
    }
}
