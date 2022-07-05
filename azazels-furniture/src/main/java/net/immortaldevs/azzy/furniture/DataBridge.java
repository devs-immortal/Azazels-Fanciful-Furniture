package net.immortaldevs.azzy.furniture;

import io.wispforest.owo.itemgroup.Icon;
import net.immortaldevs.azzy.core.CoreDataBridge;
import net.minecraft.item.Items;

import java.util.Optional;

public class DataBridge implements CoreDataBridge {

    @Override
    public Optional<TabData> getTabData() {
        return Optional.of(new TabData(0, Icon.of(Items.CHEST.getDefaultStack()), "furniture", null));
    }
}
