package net.meow.taki.assassin.procedure;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.meow.taki.assassin.MinecrownrebornModVariables;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureReturnfromMasyaf extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureReturnfromMasyaf(ElementsMinecrownrebornMod instance) {
		super(instance, 159);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ReturnfromMasyaf!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ReturnfromMasyaf!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((entity.dimension) == 9)) {
			entity.setPositionAndUpdate((MinecrownrebornModVariables.WorldVariables.get(world).SapwnX_Masyaf),
					(MinecrownrebornModVariables.WorldVariables.get(world).SpawnY_Masyaf),
					(MinecrownrebornModVariables.WorldVariables.get(world).SpawnZ_Masyaf));
		}
	}

	@SubscribeEvent
	public void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		int dimension = event.getDimension();
		Entity entity = event.getEntity();
		World world = entity.world;
		int i = (int) entity.posX;
		int j = (int) entity.posY;
		int k = (int) entity.posZ;
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("dimension", dimension);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
