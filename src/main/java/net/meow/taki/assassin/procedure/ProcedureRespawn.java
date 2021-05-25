package net.meow.taki.assassin.procedure;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;
import java.util.HashMap;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureRespawn extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureRespawn(ElementsMinecrownrebornMod instance) {
		super(instance, 134);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Respawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Respawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Respawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Respawn!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			ProcedureGlobalSpawn.executeProcedure($_dependencies);
		}
	}

	@SubscribeEvent
	public void onPlayerRespawned(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent event) {
		Entity entity = event.player;
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", (int) entity.posX);
		dependencies.put("y", (int) entity.posY);
		dependencies.put("z", (int) entity.posZ);
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("endconquered", event.isEndConquered());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
