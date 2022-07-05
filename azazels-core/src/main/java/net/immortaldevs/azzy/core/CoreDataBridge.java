package net.immortaldevs.azzy.core;

import io.wispforest.owo.itemgroup.Icon;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;

import javax.annotation.Nullable;
import java.util.Optional;

public interface CoreDataBridge {

    Optional<TabData> getTabData();

    record TabData(int index, Icon icon, String name, @Nullable TagKey<Item> contentTag) {}
}
