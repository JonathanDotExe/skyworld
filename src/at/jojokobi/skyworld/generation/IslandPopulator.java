package at.jojokobi.skyworld.generation;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.util.Vector;

import at.jojokobi.skyworld.generation.islands.BigRandomIsland;
import at.jojokobi.skyworld.generation.islands.ClassicIsland;
import at.jojokobi.skyworld.generation.islands.EndIsland;
import at.jojokobi.skyworld.generation.islands.EnderPortalIsland;
import at.jojokobi.skyworld.generation.islands.FarmIsland;
import at.jojokobi.skyworld.generation.islands.ForestIsland;
import at.jojokobi.skyworld.generation.islands.GrassIsland;
import at.jojokobi.skyworld.generation.islands.HouseIsland;
import at.jojokobi.skyworld.generation.islands.IlluminatiIsland;
import at.jojokobi.skyworld.generation.islands.Island;
import at.jojokobi.skyworld.generation.islands.JungleIsland;
import at.jojokobi.skyworld.generation.islands.LlamaIsland;
import at.jojokobi.skyworld.generation.islands.MineIsland;
import at.jojokobi.skyworld.generation.islands.MiniDungeonIsland;
import at.jojokobi.skyworld.generation.islands.NetherFortressIsland;
import at.jojokobi.skyworld.generation.islands.NetherIsland;
import at.jojokobi.skyworld.generation.islands.NetherrackIsland;
import at.jojokobi.skyworld.generation.islands.RainbowIsland;
import at.jojokobi.skyworld.generation.islands.RandomIsland;
import at.jojokobi.skyworld.generation.islands.SandIsland;
import at.jojokobi.skyworld.generation.islands.SuperRandomIsland;
import at.jojokobi.skyworld.generation.islands.SwampIsland;
import at.jojokobi.skyworld.generation.islands.TowerIsland;

public class IslandPopulator extends BlockPopulator {
	
	private Island[] islands;
	private Island[] islandsNether;
	
	private Island[] spawnIslands;
	private Vector[] locations;
	private Island middleIsland;
	private Island netherIsland;
	private Island endIsland;
	private Island enderPortalIsland;
	
	public IslandPopulator() {
		islands = new Island[] {
				new ClassicIsland(false), new ClassicIsland(false),
				new RainbowIsland(false), new RainbowIsland(false),
				new ForestIsland(false), new ForestIsland(false), new ForestIsland(false), 
				new HouseIsland(false),
				new FarmIsland(false), new FarmIsland(false),
				new LlamaIsland(false),  new LlamaIsland(false),
				new MineIsland(false),
				new MiniDungeonIsland(false),
				new GrassIsland(false), new GrassIsland(false), new GrassIsland(false), new GrassIsland(false), new GrassIsland(false),
				new RandomIsland(false), new RandomIsland(false), new RandomIsland(false),
				new BigRandomIsland(false), new BigRandomIsland(false),
				new SuperRandomIsland(false),
				new TowerIsland(false),
				new SwampIsland(false), new SwampIsland(false),
				new JungleIsland(false), new JungleIsland(false),
				new SandIsland(false),
				new IlluminatiIsland(false)};
		islandsNether = new Island[] {new NetherrackIsland(false), new NetherrackIsland(false), new NetherrackIsland(false), new NetherrackIsland(false), new NetherrackIsland(false), new NetherFortressIsland(false)};
		
		spawnIslands = new Island[] {new ClassicIsland(true), new RainbowIsland(true),  new ForestIsland(true),  new HouseIsland(true), new FarmIsland(true), new LlamaIsland(true), new MineIsland(true), new MiniDungeonIsland(true)};
		locations = new Vector[] {new Vector(64, 64, 0), new Vector(32, 64, 32), new Vector(0, 64, 64), new Vector(-32, 64, 32), new Vector(-64, 64, 0), new Vector(-32, 64, -32), new Vector(0, 64, -64), new Vector(32, 64, -32)};
		middleIsland = new SandIsland(true);
		netherIsland = new NetherIsland(true);
		endIsland = new EndIsland(true);
		enderPortalIsland = new EnderPortalIsland(true);
	}

	@Override
	public void populate(World world, Random rand, Chunk chunk) {
		if (world.getEnvironment() == Environment.NORMAL){
			if ((chunk.getX() < -4) || (chunk.getX() > 4) || (chunk.getZ() < -4) || (chunk.getX() > 4)){
				Random random = new Random();
				if (random.nextInt(8) == 2){
					Island island = islands[random.nextInt(islands.length)];
					island.build(new Location(chunk.getWorld(), chunk.getX()*16, 54 + random.nextInt(21), chunk.getZ()*16));
				}
			}
			else if (chunk.getX() == 0 && chunk.getZ() == 0) {
				for (int i = 0; i < spawnIslands.length; i++){
					spawnIslands[i].build(new Location(world, 0, 0, 0).add(locations[i]));
				}
				middleIsland.build(new Location(world, -1, 64, -1));
			}
		}
		else if (world.getEnvironment() == Environment.NETHER){
			if ((chunk.getX() < -4) || (chunk.getX() > 4) || (chunk.getZ() < -4) || (chunk.getX() > 4)){
				Random random = new Random();
				if (random.nextInt(8) == 2){
					Island island = islandsNether[random.nextInt(islandsNether.length)];
					island.build(new Location(chunk.getWorld(), chunk.getX()*16, 54 + random.nextInt(21), chunk.getZ()*16));
				}
			}
			else if (chunk.getX() == 0 && chunk.getZ() == 0) {
				netherIsland.build(new Location(world, -1, 64, -1));
			}
		}
		else {
			endIsland.build(new Location(world, -1, 64, -1));
			enderPortalIsland.build(new Location(world, -4, 64, 64));
		}
	}	
	
}
