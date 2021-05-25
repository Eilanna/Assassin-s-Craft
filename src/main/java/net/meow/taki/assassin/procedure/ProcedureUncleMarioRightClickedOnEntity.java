package net.meow.taki.assassin.procedure;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureUncleMarioRightClickedOnEntity extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureUncleMarioRightClickedOnEntity(ElementsMinecrownrebornMod instance) {
		super(instance, 145);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UncleMarioRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UncleMarioRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UncleMarioRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UncleMarioRightClickedOnEntity!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.playSound((EntityPlayer) null, x, y, z, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
				.getObject(new ResourceLocation("minecrownreborn:its_a_me_mario")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
	}
}