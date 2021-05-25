
package net.meow.taki.assassin.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.meow.taki.assassin.procedure.ProcedureClimb;
import net.meow.taki.assassin.creativetab.TabAssassinsCreedProps;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;
import java.util.HashMap;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ItemArnoArmor extends ElementsMinecrownrebornMod.ModElement {
	@GameRegistry.ObjectHolder("minecrownreborn:arnoarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("minecrownreborn:arnoarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("minecrownreborn:arnoarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("minecrownreborn:arnoarmorboots")
	public static final Item boots = null;
	public ItemArnoArmor(ElementsMinecrownrebornMod instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("ARNOARMOR", "minecrownreborn:arnodorian_", 45, new int[]{5, 8, 9, 5}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("item.armor.equip_leather")),
				2.5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("arnoarmorhelmet")
				.setRegistryName("arnoarmorhelmet").setCreativeTab(TabAssassinsCreedProps.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("arnoarmorbody")
				.setRegistryName("arnoarmorbody").setCreativeTab(TabAssassinsCreedProps.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("arnoarmorlegs")
				.setRegistryName("arnoarmorlegs").setCreativeTab(TabAssassinsCreedProps.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedureClimb.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("arnoarmorboots").setRegistryName("arnoarmorboots").setCreativeTab(TabAssassinsCreedProps.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("minecrownreborn:arnoarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("minecrownreborn:arnoarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("minecrownreborn:arnoarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("minecrownreborn:arnoarmorboots", "inventory"));
	}
}
