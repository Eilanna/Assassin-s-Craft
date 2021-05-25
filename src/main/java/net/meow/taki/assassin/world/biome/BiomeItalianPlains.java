
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
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityChicken;

import net.meow.taki.assassin.ElementsMinecrownrebornMod;

import java.util.Random;

@ElementsMinecrownrebornMod.ModElement.Tag
public class BiomeItalianPlains extends ElementsMinecrownrebornMod.ModElement {
	@GameRegistry.ObjectHolder("minecrownreborn:italianplains")
	public static final BiomeGenCustom biome = null;
	public BiomeItalianPlains(ElementsMinecrownrebornMod instance) {
		super(instance, 125);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10));
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Italian Plains").setRainfall(0.2F).setBaseHeight(0.1F).setWaterColor(-16750951).setHeightVariation(0F)
					.setTemperature(0.75F));
			setRegistryName("italianplains");
			topBlock = Blocks.GRASS.getDefaultState();
			fillerBlock = Blocks.DIRT.getStateFromMeta(0);
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 1;
			decorator.grassPerChunk = 2;
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
			this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 15, 1, 15));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 15, 1, 15));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 15, 1, 15));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 15, 1, 15));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 15, 1, 15));
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -13261999;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -13261999;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -5916161;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
