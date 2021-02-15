package at.jojokobi.skyworld.generation;


import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.event.EventHandler;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.jojokobi.skyworld.generation.islands.*;


public class SkyWorldOverworldGenerator extends ChunkGenerator implements Listener{
	
	public static final int CHUNK_SIZE = 16;
	
	private Island[] islands;
	private Island[] islandsNether;
	
	public SkyWorldOverworldGenerator () {
		islands = new Island[] {new ClassicIsland(false), new ClassicIsland(false), new RainbowIsland(false), new RainbowIsland(false), new ForestIsland(false), new ForestIsland(false), new ForestIsland(false),  new HouseIsland(false), new FarmIsland(false), new FarmIsland(false), new LlamaIsland(false),  new LlamaIsland(false), new MineIsland(false), new MiniDungeonIsland(false), new GrassIsland(false), new GrassIsland(false), new GrassIsland(false), new GrassIsland(false), new GrassIsland(false), new RandomIsland(false), new RandomIsland(false), new RandomIsland(false), new BigRandomIsland(false), new BigRandomIsland(false), new SuperRandomIsland(false), new TowerIsland(false), new SwampIsland(false), new SwampIsland(false), new JungleIsland(false), new JungleIsland(false), new SandIsland(false), new IlluminatiIsland(false)};
		islandsNether = new Island[] {new NetherrackIsland(false), new NetherrackIsland(false), new NetherrackIsland(false), new NetherrackIsland(false), new NetherrackIsland(false), new NetherFortressIsland(false)};
	}
	
	@EventHandler
	public void generateChunk (ChunkLoadEvent event){
		Chunk chunk = event.getChunk();
		if ((event.isNewChunk()) && (chunk.getWorld().getName().equals("skyworld"))){
			if ((chunk.getX()<-1) || (chunk.getX()>1) || (chunk.getZ()<-1) || (chunk.getX()>1)){
				Random random = new Random();
				if (random.nextInt(8) == 2){
					Island island = islands[random.nextInt(islands.length)];
					island.build(new Location(chunk.getWorld(), chunk.getX()*16, 54 + random.nextInt(21), chunk.getZ()*16));
				}
			}
		}
		else if ((event.isNewChunk()) && (chunk.getWorld().getName().equals("skynether"))){
			if ((chunk.getX()<-1) || (chunk.getX()>1) || (chunk.getZ()<-1) || (chunk.getX()>1)){
				Random random = new Random();
				if (random.nextInt(8) == 2){
					Island island = islandsNether[random.nextInt(islandsNether.length)];
					island.build(new Location(chunk.getWorld(), chunk.getX()*16, 54 + random.nextInt(21), chunk.getZ()*16));
				}
			}
		}
	}
	
	@Override
	public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
		ChunkData data = createChunkData(world);
		for (int i = 0; i < CHUNK_SIZE; i++) {
			for (int j = 0; j < CHUNK_SIZE; j++) {
				for (int k = 0; k < 256; k++) {
					biome.setBiome(i, k, j, Biome.PLAINS);
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
