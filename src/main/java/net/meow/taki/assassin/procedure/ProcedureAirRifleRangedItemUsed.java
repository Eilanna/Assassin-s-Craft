package net.meow.taki.assassin.procedure;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureAirRifleRangedItemUsed extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureAirRifleRangedItemUsed(ElementsMinecrownrebornMod instance) {
		super(instance, 70);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AirRifleRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure AirRifleRangedItemUsed!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AirRifleRangedItemUsed!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AirRifleRangedItemUsed!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AirRifleRangedItemUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AirRifleRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 50);
		world.playSound((EntityPlayer) null, x, y, z,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("minecrownreborn:rifleshot")),
				SoundCategory.NEUTRAL, (float) 2, (float) 1);
	}
}
