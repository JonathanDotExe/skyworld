package at.jojokobi.skyworld.generation;


import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Chunk;
import org.bukkit.Location;
import java.util.Random;
import at.jojokobi.skyworld.generation.islands.*;



public class IslandGenerator implements Listener{
	
	private Island[] islands;
	private Island[] islandsNether;
	
	public IslandGenerator () {
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
}
