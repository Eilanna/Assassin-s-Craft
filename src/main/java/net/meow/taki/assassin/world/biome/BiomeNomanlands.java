
package net.meow.taki.assassin.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;

import net.meow.taki.assassin.entity.EntityEagle;
import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Random;

@ElementsMinecrownrebornMod.ModElement.Tag
public class BiomeNomanlands extends ElementsMinecrownrebornMod.ModElement {
	@GameRegistry.ObjectHolder("minecrownreborn:nomanlands")
	public static final BiomeGenCustom biome = null;
	public BiomeNomanlands(ElementsMinecrownrebornMod instance) {
		super(instance, 88);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 12));
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Nomanlands").setRainfall(0.1F).setBaseHeight(0.1F).setWaterColor(-12479340).setHeightVariation(0.15F)
					.setTemperature(0.28F));
			setRegistryName("nomanlands");
			topBlock = Blocks.DIRT.getStateFromMeta(2);
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
			decorator.treesPerChunk = 1;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 1;
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
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -6724096;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -6724096;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -5915905;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
