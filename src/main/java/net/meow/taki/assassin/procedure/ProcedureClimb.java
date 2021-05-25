package net.meow.taki.assassin.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureClimb extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureClimb(ElementsMinecrownrebornMod instance) {
		super(instance, 195);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Climb!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Climb!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Climb!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Climb!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Climb!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity.isSneaking()) && (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.ROCK)
				|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.ROCK)
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.ROCK)
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.ROCK)))))) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, (int) 5, (int) 1, (false), (false)));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, (int) 45, (int) 4, (false), (false)));
		} else if (((entity.isSneaking()) && (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.WOOD)
				|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.WOOD)
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.WOOD)
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.WOOD)))))) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, (int) 5, (int) 1, (false), (false)));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, (int) 45, (int) 4, (false), (false)));
		}
	}
}
