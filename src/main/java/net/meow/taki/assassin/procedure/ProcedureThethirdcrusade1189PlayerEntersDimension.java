package net.meow.taki.assassin.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.meow.taki.assassin.item.ItemMapkingdom;
import net.meow.taki.assassin.item.ItemHoja_OcultaAct;
import net.meow.taki.assassin.item.ItemHojaOculta;
import net.meow.taki.assassin.item.ItemExittheanimus;
import net.meow.taki.assassin.item.ItemAltairsword;
import net.meow.taki.assassin.item.ItemAltairArmor;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureThethirdcrusade1189PlayerEntersDimension extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureThethirdcrusade1189PlayerEntersDimension(ElementsMinecrownrebornMod instance) {
		super(instance, 155);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Thethirdcrusade1189PlayerEntersDimension!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Thethirdcrusade1189PlayerEntersDimension!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Thethirdcrusade1189PlayerEntersDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Thethirdcrusade1189PlayerEntersDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Thethirdcrusade1189PlayerEntersDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clear();
		world.playSound((EntityPlayer) null, x, y, z, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
				.getObject(new ResourceLocation("minecrownreborn:italy_player_enters")), SoundCategory.NEUTRAL, (float) 100, (float) 1);
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
			}, "gamerule keepInventory true");
		}
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Masyaf; 1191"), (true));
		}
		if ((((!(((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemAltairArmor.helmet, (int) (1)).getItem()))
				&& (!(((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemAltairArmor.body, (int) (1)).getItem())))
				&& ((!(((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemAltairArmor.legs, (int) (1)).getItem()))
						&& (!(((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemAltairArmor.boots, (int) (1)).getItem()))))) {
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(3, new ItemStack(ItemAltairArmor.helmet, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(2, new ItemStack(ItemAltairArmor.body, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(1, new ItemStack(ItemAltairArmor.legs, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(0, new ItemStack(ItemAltairArmor.boots, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */
		}
		if ((!((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemHojaOculta.block, (int) (1)))
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemHoja_OcultaAct.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((!((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemAltairsword.block, (int) (1)))
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemAltairsword.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((!((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemMapkingdom.block, (int) (1)))
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemMapkingdom.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((!((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemExittheanimus.block, (int) (1)))
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemExittheanimus.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
