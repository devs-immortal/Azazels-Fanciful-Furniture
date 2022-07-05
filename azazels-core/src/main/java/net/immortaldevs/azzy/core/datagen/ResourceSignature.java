package net.immortaldevs.azzy.core.datagen;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.lang.JLang;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ResourceSignature extends DatagenUtil {

    private static final Interner<ResourceSignature> INTERNER = Interners.newStrongInterner();
    private boolean initialized;

    public final RuntimeResourcePack resourcePack;
    public final JLang EN_US = JLang.lang();
    public final Identifier packId;
    private final String modId;

    private ResourceSignature(String modId) {
        this.packId = new Identifier(modId, "resources");
        this.modId = modId;
        this.resourcePack = RuntimeResourcePack.create(packId);
    }

    private void register() {
        resourcePack.addLang(new Identifier(packId.getNamespace(), "en_us"), EN_US);
        RRPCallback.BEFORE_VANILLA.register(a -> a.add(resourcePack));
        initialized = true;
    }

    public String namespace(String path) {
        return modId + ":" + path;
    }

    public static ResourceSignature of(String modId) {
        ResourceSignature signature = INTERNER.intern(new ResourceSignature(modId));
        if (!signature.initialized)
            signature.register();
        return signature;
    }

    public void simpleItemModel(Identifier item) {
        var id = splicePath(item, "item");
        resourcePack.addModel(JModel.model("minecraft:item/generated").textures(JModel.textures().layer0(id.toString())), id);
    }

    public void simpleBlockItemModel(Identifier blockItem) {
        var parentId = splicePath(blockItem, "block");
        var id = splicePath(blockItem, "item");
        resourcePack.addModel(JModel.model(parentId), id);
    }

    public void simpleCubeAll(Identifier block) {
        var id = splicePath(block, "block");
        resourcePack.addModel(JModel.model("minecraft:block/cube_all").textures(JModel.textures().var("all", id.toString())), id);
        resourcePack.addBlockState(JState.state(JState.variant(JState.model(id))), block);
    }

    public void simpleBlock(Identifier block, String parent) {
        var id = splicePath(block, "block");
        resourcePack.addModel(JModel.model(parent).textures(JModel.textures().var("all", id.toString())), id);
        resourcePack.addBlockState(JState.state(JState.variant(JState.model(id))), block);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ResourceSignature signature) {
            return signature.packId.equals(packId);
        }
        return false;
    }
}
