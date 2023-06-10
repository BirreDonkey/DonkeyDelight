
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.donkeydelight.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class DonkeyDelightModTabs {
	public static CreativeModeTab TAB_DONKEY_DELIGHT;

	public static void load() {
		TAB_DONKEY_DELIGHT = new CreativeModeTab("tabdonkey_delight") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.COOKED_BEEF);
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
