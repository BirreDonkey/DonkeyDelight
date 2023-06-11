
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.donkeydelight.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.donkeydelight.DonkeyDelightMod;

public class DonkeyDelightModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DonkeyDelightMod.MODID);
	public static final RegistryObject<Item> BURNING_STOVE = block(DonkeyDelightModBlocks.BURNING_STOVE, DonkeyDelightModTabs.TAB_DONKEY_DELIGHT);
	public static final RegistryObject<Item> STOVE = block(DonkeyDelightModBlocks.STOVE, DonkeyDelightModTabs.TAB_DONKEY_DELIGHT);
	public static final RegistryObject<Item> PAN = block(DonkeyDelightModBlocks.PAN, DonkeyDelightModTabs.TAB_DONKEY_DELIGHT);
	public static final RegistryObject<Item> POT = block(DonkeyDelightModBlocks.POT, DonkeyDelightModTabs.TAB_DONKEY_DELIGHT);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
