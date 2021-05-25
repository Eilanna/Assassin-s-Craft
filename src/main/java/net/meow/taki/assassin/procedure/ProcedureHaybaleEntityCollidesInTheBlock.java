package net.meow.taki.assassin.procedure;

import net.minecraft.entity.Entity;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureHaybaleEntityCollidesInTheBlock extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureHaybaleEntityCollidesInTheBlock(ElementsMinecrownrebornMod instance) {
		super(instance, 130);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HaybaleEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.fallDistance = (float) (0);
	}
}
