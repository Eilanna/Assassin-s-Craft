
package net.meow.taki.assassin.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityChicken;

import net.meow.taki.assassin.entity.EntityTemplarofficer;
import net.meow.taki.assassin.entity.EntityEagle;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Random;

@ElementsMinecrownrebornMod.ModElement.Tag
public class BiomeSyrianlands extends ElementsMinecrownrebornMod.ModElement {
	@GameRegistry.ObjectHolder("minecrownreborn:syrianlands")
	public static final BiomeGenCustom biome = null;
	public BiomeSyrianlands(ElementsMinecrownrebornMod instance) {
		super(instance, 152);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Syrianlands").setRainfall(0F).setBaseHeight(0.2F).setWaterColor(-14329397).setHeightVariation(0.5F)
					.setTemperature(1F));
			setRegistryName("syrianlands");
			topBlock = Blocks.GRASS.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntityEagle.EntityCustom.class, 15, 1, 15));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 15, 1, 15));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 15, 1, 15));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 15, 1, 15));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityTemplarofficer.EntityCustom.class, 15, 1, 15));
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -6718167;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -6718167;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -5265806;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
