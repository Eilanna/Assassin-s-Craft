package net.mcreator.assassins_creed.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.assassins_creed.ElementsAssassinsCraftMod;

import java.util.Map;

@ElementsAssassinsCraftMod.ModElement.Tag
public class ProcedureAssassinGauntletActBulletHitsBlock extends ElementsAssassinsCraftMod.ModElement {
	public ProcedureAssassinGauntletActBulletHitsBlock(ElementsAssassinsCraftMod instance) {
		super(instance, 54);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AssassinGauntletActBulletHitsBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AssassinGauntletActBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AssassinGauntletActBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AssassinGauntletActBulletHitsBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		entity.setPositionAndUpdate(x, y, z);
	}
}
