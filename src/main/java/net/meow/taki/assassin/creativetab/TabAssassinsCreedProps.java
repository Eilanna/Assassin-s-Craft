
package net.meow.taki.assassin.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.meow.taki.assassin.item.ItemAltairArmor;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

@ElementsMinecrownrebornMod.ModElement.Tag
public class TabAssassinsCreedProps extends ElementsMinecrownrebornMod.ModElement {
	public TabAssassinsCreedProps(ElementsMinecrownrebornMod instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabassassinscreedprops") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemAltairArmor.helmet, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
