package net.meow.taki.assassin.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.meow.taki.assassin.item.ItemRapier;
import net.meow.taki.assassin.item.ItemMariosLetteritem;
import net.meow.taki.assassin.item.ItemItalymap;
import net.meow.taki.assassin.item.ItemHojaOculta;
import net.meow.taki.assassin.item.ItemEzioArmor;
import net.meow.taki.assassin.item.ItemExittheanimus;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Map;
import java.util.HashMap;

@ElementsMinecrownrebornMod.ModElement.Tag
public class ProcedureItaly1459PlayerEntersDimension extends ElementsMinecrownrebornMod.ModElement {
	public ProcedureItaly1459PlayerEntersDimension(ElementsMinecrownrebornMod instance) {
		super(instance, 126);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Italy1459PlayerEntersDimension!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Italy1459PlayerEntersDimension!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Italy1459PlayerEntersDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Italy1459PlayerEntersDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Italy1459PlayerEntersDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clear();
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			ProcedureReturnfromItaly.executeProcedure($_dependencies);
		}
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
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Italy, 1476"), (true));
		}
		if ((((!(((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemEzioArmor.helmet, (int) (1)).getItem()))
				&& (!(((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEzioArmor.body, (int) (1)).getItem())))
				&& ((!(((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemEzioArmor.legs, (int) (1)).getItem()))
						&& (!(((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemEzioArmor.boots, (int) (1)).getItem()))))) {
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(3, new ItemStack(ItemEzioArmor.helmet, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(2, new ItemStack(ItemEzioArmor.body, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(1, new ItemStack(ItemEzioArmor.legs, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(0, new ItemStack(ItemEzioArmor.boots, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */
		}
		if ((!((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemHojaOculta.block, (int) (1)))
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemHojaOculta.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((!((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemRapier.block, (int) (1)))
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemRapier.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((!((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemItalymap.block, (int) (1)))
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemItalymap.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((!(((entity instanceof EntityPlayerMP) && ((entity).world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(((WorldServer) (entity).world).getAdvancementManager()
								.getAdvancement(new ResourceLocation("minecrownreborn:andiamo")))
						.isDone()
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(Items.SADDLE, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((!((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemMariosLetteritem.block, (int) (1)))
				: false))) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemMariosLetteritem.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemExittheanimus.block, (int) (1));
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
