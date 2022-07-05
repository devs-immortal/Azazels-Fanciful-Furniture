package net.immortaldevs.azzy.furniture.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class TableBlock extends BlockWithEntity {

    public static final VoxelShape SHAPE;

    protected TableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    static {
        var shape = Block.createCuboidShape(0, 13, 0, 16, 16, 16);
        shape = VoxelShapes.union(shape, Block.createCuboidShape(1, 0, 1, 4, 13, 4));
        shape = VoxelShapes.union(shape, Block.createCuboidShape(12, 0, 1, 15, 13, 4));
        shape = VoxelShapes.union(shape, Block.createCuboidShape(1, 0, 12, 4, 13, 15));
        SHAPE = VoxelShapes.union(shape, Block.createCuboidShape(12, 0, 12, 15, 13, 15));
    }
}
