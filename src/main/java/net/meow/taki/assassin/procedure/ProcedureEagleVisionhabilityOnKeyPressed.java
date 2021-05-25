package net.meow.taki.assassin.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.meow.taki.assassin.item.ItemShayCormac;
import net.meow.taki.assassin.item.ItemJacobArmor;
import net.meow.taki.assassin.item.ItemEzioreArmor;
import net.meow.taki.assassin.item.ItemEzioArmor;
import net.meow.taki.assassin.item.ItemEivor;
import net.meow.taki.assassin.item.ItemEdwardKenway;
import net.meow.taki.assassin.item.ItemConnorKenwayArmor;
import net.meow.taki.assassin.item.ItemArnoArmor;
import net.meow.taki.assassin.item.ItemAltairArmor;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureEagleVisionhabilityOnKeyPressed extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureEagleVisionhabilityOnKeyPressed(ElementsMinecrownrebornMod instance) {
		super(instance, 106);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EagleVisionhabilityOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure EagleVisionhabilityOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure EagleVisionhabilityOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure EagleVisionhabilityOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure EagleVisionhabilityOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemAltairArmor.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemAltairArmor.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemAltairArmor.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemAltairArmor.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemEzioArmor.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEzioArmor.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEzioArmor.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemEzioArmor.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemEzioreArmor.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEzioreArmor.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEzioreArmor.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemEzioreArmor.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemEdwardKenway.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEdwardKenway.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEdwardKenway.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemEdwardKenway.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemArnoArmor.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemArnoArmor.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemArnoArmor.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemArnoArmor.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemJacobArmor.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemJacobArmor.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemJacobArmor.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemJacobArmor.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemConnorKenwayArmor.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemConnorKenwayArmor.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemConnorKenwayArmor.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemConnorKenwayArmor.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemShayCormac.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemShayCormac.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemShayCormac.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemShayCormac.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
		if ((((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemEivor.helmet, (int) (1)).getItem())
				&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEivor.body, (int) (1)).getItem()))
				&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEivor.legs, (int) (1)).getItem())
						&& (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemEivor.boots, (int) (1)).getItem())))) {
			if (!world.isRemote && world.getMinecraftServer() != null) {
				world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
					@Override
					public String getName() {
						return "";
					}

					@Override
					public boolean canUseCommand(int permission, String command) {
						return true;
					}

					@Override
					public World getEntityWorld() {
						return world;
					}

					@Override
					public MinecraftServer getServer() {
						return world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return new BlockPos((int) x, (int) y, (int) z);
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(x, y, z);
					}
				}, "/effect @e[r=30] minecraft:glowing 15 0");
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 300, (int) 3, (false), (false)));
		}
	}
}
