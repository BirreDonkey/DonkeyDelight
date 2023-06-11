
package net.mcreator.donkeydelight.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class PotBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public PotBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Place on a stove"));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(3, 0, 3, 13, 1, 13), box(3, 1, 12, 13, 7, 13), box(12, 1, 4, 13, 7, 12), box(3, 1, 4, 4, 7, 12), box(3, 1, 3, 13, 7, 4), box(13, 4, 10, 14, 5, 11), box(13, 4, 5, 14, 5, 6), box(14, 5, 5, 15, 6, 11),
					box(1, 5, 5, 2, 6, 11), box(2, 4, 10, 3, 5, 11), box(2, 4, 5, 3, 5, 6));
			case NORTH -> Shapes.or(box(3, 0, 3, 13, 1, 13), box(3, 1, 3, 13, 7, 4), box(3, 1, 4, 4, 7, 12), box(12, 1, 4, 13, 7, 12), box(3, 1, 12, 13, 7, 13), box(2, 4, 5, 3, 5, 6), box(2, 4, 10, 3, 5, 11), box(1, 5, 5, 2, 6, 11),
					box(14, 5, 5, 15, 6, 11), box(13, 4, 5, 14, 5, 6), box(13, 4, 10, 14, 5, 11));
			case EAST -> Shapes.or(box(3, 0, 3, 13, 1, 13), box(12, 1, 3, 13, 7, 13), box(4, 1, 3, 12, 7, 4), box(4, 1, 12, 12, 7, 13), box(3, 1, 3, 4, 7, 13), box(10, 4, 2, 11, 5, 3), box(5, 4, 2, 6, 5, 3), box(5, 5, 1, 11, 6, 2),
					box(5, 5, 14, 11, 6, 15), box(10, 4, 13, 11, 5, 14), box(5, 4, 13, 6, 5, 14));
			case WEST -> Shapes.or(box(3, 0, 3, 13, 1, 13), box(3, 1, 3, 4, 7, 13), box(4, 1, 12, 12, 7, 13), box(4, 1, 3, 12, 7, 4), box(12, 1, 3, 13, 7, 13), box(5, 4, 13, 6, 5, 14), box(10, 4, 13, 11, 5, 14), box(5, 5, 14, 11, 6, 15),
					box(5, 5, 1, 11, 6, 2), box(5, 4, 2, 6, 5, 3), box(10, 4, 2, 11, 5, 3));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
