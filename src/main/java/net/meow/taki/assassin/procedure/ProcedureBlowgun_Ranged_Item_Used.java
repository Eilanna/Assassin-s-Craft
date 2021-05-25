package net.meow.taki.assassin.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureBlowgun_Ranged_Item_Used extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureBlowgun_Ranged_Item_Used(ElementsMinecrownrebornMod instance) {
		super(instance, 180);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Blowgun_Ranged_Item_Used!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure Blowgun_Ranged_Item_Used!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 30);
	}
}
