package net.meow.taki.assassin.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureDesynchronizationEntityCollidesInTheBlocke extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureDesynchronizationEntityCollidesInTheBlocke(ElementsMinecrownrebornMod instance) {
		super(instance, 131);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DesynchronizationEntityCollidesInTheBlocke!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
	}
}
