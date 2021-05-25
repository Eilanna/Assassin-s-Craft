package net.meow.taki.assassin.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureBombadehumoBulletHitsLivingEntity extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureBombadehumoBulletHitsLivingEntity(ElementsMinecrownrebornMod instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BombadehumoBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BombadehumoBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BombadehumoBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BombadehumoBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BombadehumoBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 500, (int) 3, (true), (true)));
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, y, z, (int) 15000, 2, 2, 2, 0, new int[0]);
	}
}
