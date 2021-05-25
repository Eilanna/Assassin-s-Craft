package net.meow.taki.assassin.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureBombadehumoBulletHitsBlock extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureBombadehumoBulletHitsBlock(ElementsMinecrownrebornMod instance) {
		super(instance, 37);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BombadehumoBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BombadehumoBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BombadehumoBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BombadehumoBulletHitsBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, y, z, (int) 1500, 2, 2, 2, 0, new int[0]);
	}
}
