package net.immortaldevs.azzy.furniture.datagen;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;
import net.immortaldevs.azzy.furniture.block.TableBlock;

import static net.immortaldevs.azzy.furniture.AzazelsFurniture.*;
import static net.immortaldevs.azzy.core.datagen.ResourceSignature.*;

public class FurnitureModelGen {
    public static final RuntimeResourcePack PACK = RESOURCE_SIGNATURE.resourcePack;

    public static void createTable(TableBlock block) {
        var id = getBlockId(block);
        var path = splicePath(id, "block");

        PACK.addModel(JModel.model("azazels_furniture:base/base_table").textures(JModel.textures().var("all", path.toString())), path);
        RESOURCE_SIGNATURE.simpleBlockItemModel(id);
        PACK.addBlockState(simpleState(path), id);
    }
}
