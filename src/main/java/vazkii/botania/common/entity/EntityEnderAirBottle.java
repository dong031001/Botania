/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Feb 16, 2015, 5:15:31 PM (GMT)]
 */
package vazkii.botania.common.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ObjectHolder;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lib.LibMisc;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@OnlyIn(
	value = Dist.CLIENT,
	_interface = IRendersAsItem.class
)
public class EntityEnderAirBottle extends ThrowableEntity implements IRendersAsItem {
	@ObjectHolder(LibMisc.MOD_ID + ":ender_air_bottle")
	public static EntityType<EntityEnderAirBottle> TYPE;

	public EntityEnderAirBottle(EntityType<EntityEnderAirBottle> type, World world) {
		super(type, world);
	}

	public EntityEnderAirBottle(LivingEntity entity, World world) {
		super(TYPE, entity, world);
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult pos) {
		if(pos.getType() == RayTraceResult.Type.BLOCK && !world.isRemote) {
			List<BlockPos> coordsList = getCoordsToPut(((BlockRayTraceResult) pos).getPos());
			world.playEvent(2002, new BlockPos(this), 8);

			for(BlockPos coords : coordsList) {
				world.setBlockState(coords, Blocks.END_STONE.getDefaultState());
				if(Math.random() < 0.1)
					world.playEvent(2001, coords, Block.getStateId(Blocks.END_STONE.getDefaultState()));
			}
			remove();
		}
	}

	private List<BlockPos> getCoordsToPut(BlockPos pos) {
		List<BlockPos> possibleCoords = new ArrayList<>();
		int range = 4;
		int rangeY = 4;

		for (BlockPos bPos : BlockPos.getAllInBoxMutable(pos.add(-range, -rangeY, -range),
				pos.add(range, rangeY, range))) {
			BlockState state = world.getBlockState(bPos);
			Block block = state.getBlock();
			if(block.isReplaceableOreGen(state, world, bPos, BlockStateMatcher.forBlock(Blocks.STONE)))
				possibleCoords.add(bPos.toImmutable());
		}

		Collections.shuffle(possibleCoords, rand);

		return possibleCoords.stream().limit(64).collect(Collectors.toList());
	}

	@Override
	protected void registerData() {}

	@Nonnull
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Nonnull
	@Override
	public ItemStack getItem() {
		return new ItemStack(ModItems.enderAirBottle);
	}
}
