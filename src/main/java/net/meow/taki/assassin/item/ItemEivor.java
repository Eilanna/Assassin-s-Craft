
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
public class ItemEivor extends ElementsMinecrownrebornMod.ModElement {
	@GameRegistry.ObjectHolder("minecrownreborn:eivorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("minecrownreborn:eivorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("minecrownreborn:eivorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("minecrownreborn:eivorboots")
	public static final Item boots = null;
	public ItemEivor(ElementsMinecrownrebornMod instance) {
		super(instance, 161);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("EIVOR", "minecrownreborn:eivor_", 25, new int[]{2, 5, 6, 2}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("eivorhelmet").setRegistryName("eivorhelmet")
				.setCreativeTab(TabAssassinsCreedProps.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("eivorbody").setRegistryName("eivorbody")
				.setCreativeTab(TabAssassinsCreedProps.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("eivorlegs").setRegistryName("eivorlegs")
				.setCreativeTab(TabAssassinsCreedProps.tab));
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
		}.setUnlocalizedName("eivorboots").setRegistryName("eivorboots").setCreativeTab(TabAssassinsCreedProps.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("minecrownreborn:eivorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("minecrownreborn:eivorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("minecrownreborn:eivorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("minecrownreborn:eivorboots", "inventory"));
	}
}
