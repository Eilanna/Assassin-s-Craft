
package net.meow.taki.assassin.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.block.state.IBlockState;

import net.meow.taki.assassin.item.ItemEagleFeather;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Random;

@ElementsMinecrownrebornMod.ModElement.Tag
public class EntityEagle extends ElementsMinecrownrebornMod.ModElement {
	public static final int ENTITYID = 14;
	public static final int ENTITYID_RANGED = 15;
	public EntityEagle(ElementsMinecrownrebornMod instance) {
		super(instance, 92);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("minecrownreborn", "eagle"), ENTITYID).name("eagle").tracker(64, 3, true).egg(-1, -6710887).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("minecrownreborn:nomanlands")),
				Biome.REGISTRY.getObject(new ResourceLocation("extreme_hills_with_trees")),
				Biome.REGISTRY.getObject(new ResourceLocation("extreme_hills_with_trees")),
				Biome.REGISTRY.getObject(new ResourceLocation("ice_mountains")),
				Biome.REGISTRY.getObject(new ResourceLocation("mutated_extreme_hills")),};
		EntityRegistry.addSpawn(EntityCustom.class, 50, 1, 2, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelcustom_model(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("minecrownreborn:textures/eaglexd.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
			this.navigator = new PathNavigateFlying(this, this.world);
			this.moveHelper = new EntityFlyHelper(this);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 0.8, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = EntityCustom.this.getRNG();
					double dir_x = EntityCustom.this.posX + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = EntityCustom.this.posY + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = EntityCustom.this.posZ + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 0.8));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(5, new EntityAIPanic(this, 1));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemEagleFeather.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
			this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.setNoGravity(true);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelcustom_model extends ModelBase {
		private final ModelRenderer cuerpo;
		private final ModelRenderer plumasatrasizquierda;
		private final ModelRenderer plumasatrasderecha;
		private final ModelRenderer aladerecha;
		private final ModelRenderer plumasderecha1;
		private final ModelRenderer plumasderecha2;
		private final ModelRenderer plumasderecha3;
		private final ModelRenderer plumasderecha4;
		private final ModelRenderer plumasderecha5;
		private final ModelRenderer plumasderecha6;
		private final ModelRenderer plumasderecha7;
		private final ModelRenderer plumasderecha8;
		private final ModelRenderer alaizquierda;
		private final ModelRenderer plumaizquierda1;
		private final ModelRenderer plumaizquierda2;
		private final ModelRenderer plumaizquierda3;
		private final ModelRenderer plumaizquierda4;
		private final ModelRenderer plumaizquierda5;
		private final ModelRenderer plumaizquierda6;
		private final ModelRenderer plumaizquierda7;
		private final ModelRenderer plumaizquierda8;
		private final ModelRenderer plumaizquierda9;
		private final ModelRenderer plumaizquierda10;
		public Modelcustom_model() {
			textureWidth = 128;
			textureHeight = 128;
			cuerpo = new ModelRenderer(this);
			cuerpo.setRotationPoint(0.0F, 13.0F, 0.0F);
			setRotationAngle(cuerpo, 0.0F, 3.1416F, 0.0F);
			cuerpo.cubeList.add(new ModelBox(cuerpo, 66, 112, -6.0F, -4.0F, 7.0F, 5, 4, 2, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 96, 9, -5.5F, -4.0F, 9.0F, 4, 4, 4, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 22, 35, -6.0F, -4.0F, -3.0F, 5, 4, 3, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 29, 42, -5.5F, -3.0F, -6.0F, 4, 2, 3, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 0, 44, -3.0F, -1.0F, -7.0F, 1, 1, 4, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 54, 29, -3.5F, -2.0F, -9.0F, 2, 1, 3, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 54, 29, -5.5F, -2.0F, -9.0F, 2, 1, 3, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 0, 44, -5.0F, -1.0F, -7.0F, 1, 1, 4, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 42, 4, -7.0F, -5.0F, 0.0F, 7, 5, 7, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 16, 16, -4.5F, -2.0F, 13.0F, 2, 2, 2, 0.0F, false));
			cuerpo.cubeList.add(new ModelBox(cuerpo, 16, 16, -4.5F, -1.0F, 15.0F, 2, 1, 1, 0.0F, false));
			plumasatrasizquierda = new ModelRenderer(this);
			plumasatrasizquierda.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumasatrasizquierda, 0.0F, 0.3491F, 0.0F);
			cuerpo.addChild(plumasatrasizquierda);
			plumasatrasizquierda.cubeList.add(new ModelBox(plumasatrasizquierda, 43, 96, -4.0F, -4.0F, -11.0F, 1, 1, 5, 0.0F, false));
			plumasatrasizquierda.cubeList.add(new ModelBox(plumasatrasizquierda, 43, 96, -3.0F, -4.0F, -11.0F, 1, 1, 5, 0.0F, false));
			plumasatrasizquierda.cubeList.add(new ModelBox(plumasatrasizquierda, 43, 96, -2.0F, -4.0F, -11.0F, 1, 1, 5, 0.0F, false));
			plumasatrasderecha = new ModelRenderer(this);
			plumasatrasderecha.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumasatrasderecha, 0.0F, -0.4363F, 0.0F);
			cuerpo.addChild(plumasatrasderecha);
			plumasatrasderecha.cubeList.add(new ModelBox(plumasatrasderecha, 43, 97, -6.0F, -4.0F, -8.0F, 1, 1, 5, 0.0F, false));
			plumasatrasderecha.cubeList.add(new ModelBox(plumasatrasderecha, 43, 96, -5.0F, -4.0F, -8.0F, 1, 1, 5, 0.0F, false));
			plumasatrasderecha.cubeList.add(new ModelBox(plumasatrasderecha, 43, 97, -4.0F, -4.0F, -8.0F, 1, 1, 5, 0.0F, false));
			aladerecha = new ModelRenderer(this);
			aladerecha.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(aladerecha, 0.0F, -0.1745F, 0.1745F);
			aladerecha.cubeList.add(new ModelBox(aladerecha, 43, 7, -10.0F, -16.0F, -6.0F, 9, 1, 1, 0.0F, false));
			aladerecha.cubeList.add(new ModelBox(aladerecha, 43, 7, -16.0F, -16.0F, -7.0F, 7, 1, 1, 0.0F, false));
			aladerecha.cubeList.add(new ModelBox(aladerecha, 43, 7, -23.0F, -16.0F, -8.0F, 8, 1, 1, 0.0F, false));
			plumasderecha1 = new ModelRenderer(this);
			plumasderecha1.setRotationPoint(-0.5209F, 2.0F, -2.9544F);
			aladerecha.addChild(plumasderecha1);
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -4.0F, -18.0F, -2.0F, 1, 1, 7, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -3.0F, -18.0F, -2.0F, 1, 1, 10, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -2.0F, -18.0F, -2.0F, 1, 1, 8, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -5.0F, -18.0F, -3.0F, 1, 1, 9, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -6.0F, -18.0F, -3.0F, 1, 1, 10, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -7.0F, -18.0F, -3.0F, 1, 1, 9, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -8.0F, -18.0F, -3.0F, 1, 1, 8, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -9.0F, -18.0F, -3.0F, 1, 1, 9, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -10.0F, -18.0F, -3.0F, 1, 1, 10, 0.0F, false));
			plumasderecha1.cubeList.add(new ModelBox(plumasderecha1, 33, 5, -11.0F, -18.0F, -3.0F, 1, 1, 10, 0.0F, false));
			plumasderecha2 = new ModelRenderer(this);
			plumasderecha2.setRotationPoint(0.0F, 0.0F, 2.7808F);
			setRotationAngle(plumasderecha2, 0.0F, -0.2618F, 0.0F);
			aladerecha.addChild(plumasderecha2);
			plumasderecha2.cubeList.add(new ModelBox(plumasderecha2, 44, 6, -12.4942F, -16.0F, -6.0F, 1, 1, 11, 0.0F, false));
			plumasderecha2.cubeList.add(new ModelBox(plumasderecha2, 44, 6, -13.4942F, -16.0F, -6.0F, 1, 1, 9, 0.0F, false));
			plumasderecha2.cubeList.add(new ModelBox(plumasderecha2, 44, 6, -14.4942F, -16.0F, -6.0F, 1, 1, 10, 0.0F, false));
			plumasderecha2.cubeList.add(new ModelBox(plumasderecha2, 44, 6, -15.4942F, -16.0F, -5.0F, 1, 1, 11, 0.0F, false));
			plumasderecha2.cubeList.add(new ModelBox(plumasderecha2, 44, 6, -16.4942F, -16.0F, -5.0F, 1, 1, 10, 0.0F, false));
			plumasderecha2.cubeList.add(new ModelBox(plumasderecha2, 44, 6, -17.4942F, -16.0F, -5.0F, 1, 1, 12, 0.0F, false));
			plumasderecha2.cubeList.add(new ModelBox(plumasderecha2, 44, 6, -18.4942F, -16.0F, -6.0F, 1, 1, 11, 0.0F, false));
			plumasderecha2.cubeList.add(new ModelBox(plumasderecha2, 44, 6, -19.4942F, -16.0F, -6.0F, 1, 1, 13, 0.0F, false));
			plumasderecha3 = new ModelRenderer(this);
			plumasderecha3.setRotationPoint(1.6223F, 0.0F, -2.3169F);
			setRotationAngle(plumasderecha3, 0.0F, -0.3491F, 0.0F);
			aladerecha.addChild(plumasderecha3);
			plumasderecha3.cubeList.add(new ModelBox(plumasderecha3, 33, 2, -20.0F, -16.0F, 2.0F, 1, 1, 11, 0.0F, false));
			plumasderecha4 = new ModelRenderer(this);
			plumasderecha4.setRotationPoint(1.6223F, 0.0F, -2.3169F);
			setRotationAngle(plumasderecha4, 0.0F, -0.3491F, 0.0F);
			aladerecha.addChild(plumasderecha4);
			plumasderecha4.cubeList.add(new ModelBox(plumasderecha4, 33, 2, -21.0F, -16.0F, 2.0F, 1, 1, 10, 0.0F, false));
			plumasderecha5 = new ModelRenderer(this);
			plumasderecha5.setRotationPoint(1.6223F, 0.0F, -2.3169F);
			setRotationAngle(plumasderecha5, 0.0F, -0.3491F, 0.0F);
			aladerecha.addChild(plumasderecha5);
			plumasderecha5.cubeList.add(new ModelBox(plumasderecha5, 33, 2, -22.0F, -16.0F, 2.0F, 1, 1, 12, 0.0F, false));
			plumasderecha6 = new ModelRenderer(this);
			plumasderecha6.setRotationPoint(1.6223F, 0.0F, -2.3169F);
			setRotationAngle(plumasderecha6, 0.0F, -0.3491F, 0.0F);
			aladerecha.addChild(plumasderecha6);
			plumasderecha6.cubeList.add(new ModelBox(plumasderecha6, 33, 2, -23.0F, -16.0F, 3.0F, 1, 1, 12, 0.0F, false));
			plumasderecha7 = new ModelRenderer(this);
			plumasderecha7.setRotationPoint(1.6223F, 0.0F, -2.3169F);
			setRotationAngle(plumasderecha7, 0.0F, -0.3491F, 0.0F);
			aladerecha.addChild(plumasderecha7);
			plumasderecha7.cubeList.add(new ModelBox(plumasderecha7, 33, 2, -24.0F, -16.0F, 3.0F, 1, 1, 10, 0.0F, false));
			plumasderecha8 = new ModelRenderer(this);
			plumasderecha8.setRotationPoint(1.6223F, 0.0F, -2.3169F);
			setRotationAngle(plumasderecha8, 0.0F, -0.3491F, 0.0F);
			aladerecha.addChild(plumasderecha8);
			plumasderecha8.cubeList.add(new ModelBox(plumasderecha8, 33, 2, -25.0F, -16.0F, 3.0F, 1, 1, 11, 0.0F, false));
			alaizquierda = new ModelRenderer(this);
			alaizquierda.setRotationPoint(7.0F, 24.0F, 0.0F);
			setRotationAngle(alaizquierda, 0.0F, 0.1745F, -0.1745F);
			alaizquierda.cubeList.add(new ModelBox(alaizquierda, 23, 2, 1.0F, -16.0F, -6.0F, 9, 1, 1, 0.0F, false));
			alaizquierda.cubeList.add(new ModelBox(alaizquierda, 23, 2, 9.0F, -16.0F, -7.0F, 8, 1, 1, 0.0F, false));
			alaizquierda.cubeList.add(new ModelBox(alaizquierda, 23, 2, 16.0F, -16.0F, -8.0F, 8, 1, 1, 0.0F, false));
			plumaizquierda1 = new ModelRenderer(this);
			plumaizquierda1.setRotationPoint(0.0F, 0.0F, 0.0F);
			alaizquierda.addChild(plumaizquierda1);
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 3.0F, -16.0F, -5.0F, 1, 1, 8, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 2.0F, -16.0F, -6.0F, 1, 1, 8, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 1.0F, -16.0F, -4.0F, 1, 1, 8, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 4.0F, -16.0F, -5.0F, 1, 1, 7, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 5.0F, -16.0F, -5.0F, 1, 1, 9, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 6.0F, -16.0F, -5.0F, 1, 1, 8, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 7.0F, -16.0F, -5.0F, 1, 1, 10, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 8.0F, -16.0F, -5.0F, 1, 1, 11, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 9.0F, -16.0F, -5.0F, 1, 1, 9, 0.0F, false));
			plumaizquierda1.cubeList.add(new ModelBox(plumaizquierda1, 34, 8, 10.0F, -16.0F, -6.0F, 1, 1, 11, 0.0F, false));
			plumaizquierda2 = new ModelRenderer(this);
			plumaizquierda2.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda2, 0.0F, 0.0873F, 0.0F);
			alaizquierda.addChild(plumaizquierda2);
			plumaizquierda2.cubeList.add(new ModelBox(plumaizquierda2, 34, 8, 11.0F, -16.0F, -5.0F, 1, 1, 13, 0.0F, false));
			plumaizquierda3 = new ModelRenderer(this);
			plumaizquierda3.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda3, 0.0F, 0.0873F, 0.0F);
			alaizquierda.addChild(plumaizquierda3);
			plumaizquierda3.cubeList.add(new ModelBox(plumaizquierda3, 34, 8, 12.0F, -16.0F, -5.0F, 1, 1, 11, 0.0F, false));
			plumaizquierda4 = new ModelRenderer(this);
			plumaizquierda4.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda4, 0.0F, 0.0873F, 0.0F);
			alaizquierda.addChild(plumaizquierda4);
			plumaizquierda4.cubeList.add(new ModelBox(plumaizquierda4, 34, 8, 13.0F, -16.0F, -5.0F, 1, 1, 12, 0.0F, false));
			plumaizquierda5 = new ModelRenderer(this);
			plumaizquierda5.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda5, 0.0F, 0.0873F, 0.0F);
			alaizquierda.addChild(plumaizquierda5);
			plumaizquierda5.cubeList.add(new ModelBox(plumaizquierda5, 34, 8, 14.0F, -16.0F, -5.0F, 1, 1, 13, 0.0F, false));
			plumaizquierda6 = new ModelRenderer(this);
			plumaizquierda6.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda6, 0.0F, 0.0873F, 0.0F);
			alaizquierda.addChild(plumaizquierda6);
			plumaizquierda6.cubeList.add(new ModelBox(plumaizquierda6, 34, 8, 15.0F, -16.0F, -5.0F, 1, 1, 12, 0.0F, false));
			plumaizquierda7 = new ModelRenderer(this);
			plumaizquierda7.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda7, 0.0F, 0.0873F, 0.0F);
			alaizquierda.addChild(plumaizquierda7);
			plumaizquierda7.cubeList.add(new ModelBox(plumaizquierda7, 34, 8, 16.0F, -16.0F, -5.0F, 1, 1, 11, 0.0F, false));
			plumaizquierda8 = new ModelRenderer(this);
			plumaizquierda8.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda8, 0.0F, 0.0873F, 0.0F);
			alaizquierda.addChild(plumaizquierda8);
			plumaizquierda8.cubeList.add(new ModelBox(plumaizquierda8, 34, 8, 18.0F, -16.0F, -6.0F, 1, 1, 11, 0.0F, false));
			plumaizquierda9 = new ModelRenderer(this);
			plumaizquierda9.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda9, 0.0F, 0.0873F, 0.0F);
			alaizquierda.addChild(plumaizquierda9);
			plumaizquierda9.cubeList.add(new ModelBox(plumaizquierda9, 34, 8, 17.0F, -16.0F, -6.0F, 1, 1, 13, 0.0F, false));
			plumaizquierda10 = new ModelRenderer(this);
			plumaizquierda10.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(plumaizquierda10, 0.0F, 0.1745F, 0.0F);
			alaizquierda.addChild(plumaizquierda10);
			plumaizquierda10.cubeList.add(new ModelBox(plumaizquierda10, 26, 11, 19.0F, -16.0F, -4.0F, 1, 1, 12, 0.0F, false));
			plumaizquierda10.cubeList.add(new ModelBox(plumaizquierda10, 26, 11, 20.0F, -16.0F, -4.0F, 1, 1, 10, 0.0F, false));
			plumaizquierda10.cubeList.add(new ModelBox(plumaizquierda10, 26, 11, 21.0F, -16.0F, -4.0F, 1, 1, 11, 0.0F, false));
			plumaizquierda10.cubeList.add(new ModelBox(plumaizquierda10, 26, 11, 22.0F, -16.0F, -4.0F, 1, 1, 12, 0.0F, false));
			plumaizquierda10.cubeList.add(new ModelBox(plumaizquierda10, 26, 11, 23.0F, -16.0F, -4.0F, 1, 1, 10, 0.0F, false));
			plumaizquierda10.cubeList.add(new ModelBox(plumaizquierda10, 26, 11, 24.0F, -16.0F, -4.0F, 1, 1, 11, 0.0F, false));
			plumaizquierda10.cubeList.add(new ModelBox(plumaizquierda10, 26, 11, 18.0F, -16.0F, -4.0F, 1, 1, 11, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			cuerpo.render(f5);
			aladerecha.render(f5);
			alaizquierda.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		}
	}
}
