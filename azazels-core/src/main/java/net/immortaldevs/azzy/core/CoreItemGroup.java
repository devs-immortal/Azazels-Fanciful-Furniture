package net.immortaldevs.azzy.core;

import io.wispforest.owo.itemgroup.OwoItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.EntrypointContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.Comparator;
import java.util.Optional;

public class CoreItemGroup extends OwoItemGroup {

    public static final CoreItemGroup INSTANCE = new CoreItemGroup(AzazelsCore.locate("general"));

    private CoreItemGroup(Identifier id) {
        super(id);
    }

    @Override
    protected void setup() {
        var dataBridges = FabricLoader.getInstance().getEntrypointContainers("core-data-bridge", CoreDataBridge.class);

        dataBridges.stream()
                .map(EntrypointContainer::getEntrypoint)
                .map(CoreDataBridge::getTabData)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .sorted(Comparator.comparing(CoreDataBridge.TabData::index))
                .forEach(data -> {
                    addTab(data.icon(), data.name(), data.contentTag());
                });
    }

    @Override
    public ItemStack createIcon() {
        return Items.BARREL.getDefaultStack();
    }
}
