package at.jojokobi.skyworld.generation;

import org.bukkit.event.Listener;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SkyWorldOverworldGenerator extends ChunkGenerator implements Listener{
	
	public static final int CHUNK_SIZE = 16;
	
	@Override
	public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
		ChunkData data = createChunkData(world);
		for (int i = 0; i < CHUNK_SIZE; i++) {
			for (int j = 0; j < CHUNK_SIZE; j++) {
				for (int k = 0; k < 256; k++) {
					biome.setBiome(i, k, j, world.getEnvironment() == Environment.NORMAL ? Biome.PLAINS : Biome.NETHER_WASTES);
				}
			}
		}
		return data;
	}
	
	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return new ArrayList<>();
	}
}
