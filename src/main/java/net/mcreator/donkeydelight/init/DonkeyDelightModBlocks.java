
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.donkeydelight.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.donkeydelight.block.StoveBlock;
import net.mcreator.donkeydelight.block.BurningStoveBlock;
import net.mcreator.donkeydelight.DonkeyDelightMod;

public class DonkeyDelightModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DonkeyDelightMod.MODID);
	public static final RegistryObject<Block> BURNING_STOVE = REGISTRY.register("burning_stove", () -> new BurningStoveBlock());
	public static final RegistryObject<Block> STOVE = REGISTRY.register("stove", () -> new StoveBlock());
}
