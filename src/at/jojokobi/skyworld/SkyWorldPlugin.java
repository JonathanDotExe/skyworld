package at.jojokobi.skyworld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.plugin.java.JavaPlugin;
import at.jojokobi.skyworld.generation.islands.*;
import at.jojokobi.skyworld.generation.IslandGenerator;

//{"biome":"minecraft:ocean", "layers":[{"block":"minecraft:air", "height":1}]}
/*
 * 
 */
public class SkyWorldPlugin extends JavaPlugin{
	
	private Island[] islands;
	private Location[] locations;
	private Island middleIsland;
	private Island netherIsland;
	private Island endIsland;
	private Island enderPortalIsland;
	private World skyWorld;
	private World skyNether;
	private World skyEnd;
	private boolean exists = false;
	private boolean netherExists = false;
	private boolean endExists = false;
	private PlayerSpawnSetter spawner;
	
	@Override
	public void onEnable(){
		if (this.getServer().getWorld("skyworld") == null) {
			exists = false;
		}
		else {
			exists = true;
		}
		loadBools();
		generate();
		spawner = new PlayerSpawnSetter(skyWorld);
		getServer().getPluginManager().registerEvents(spawner, this);
		getServer().getPluginManager().registerEvents(new NetherSwitcher(skyWorld, skyNether, skyEnd), this);
		getServer().getPluginManager().registerEvents(new IslandGenerator(), this);
		spawner.load();
		islands = new Island[] {new ClassicIsland(true), new RainbowIsland(true),  new ForestIsland(true),  new HouseIsland(true), new FarmIsland(true), new LlamaIsland(true), new MineIsland(true), new MiniDungeonIsland(true)};
		locations = new Location[] {new Location(skyWorld, 64, 64, 0), new Location(skyWorld, 32, 64, 32), new Location(skyWorld, 0, 64, 64), new Location(skyWorld, -32, 64, 32), new Location(skyWorld, -64, 64, 0), new Location(skyWorld, -32, 64, -32), new Location(skyWorld, 0, 64, -64), new Location(skyWorld, 32, 64, -32)};
		middleIsland = new SandIsland(true);
		netherIsland = new NetherIsland(true);
		endIsland = new EndIsland(true);
		enderPortalIsland = new EnderPortalIsland(true);
		generateSpawnIslands();
	}
	
	@Override
	public void onDisable(){
		try {
			spawner.save();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		saveBools();
	}
	
	private void generate(){
		//Overworld
		WorldCreator generator = new WorldCreator("skyworld");
		generator.type(WorldType.FLAT);
		generator.generatorSettings("{\"biome\":\"minecraft:ocean\", \"layers\":[{\"block\":\"minecraft:air\", \"height\":1}]}");
		skyWorld = this.getServer().createWorld(generator);
		skyWorld.setSpawnLocation(64, 70, 0);
		//Nether
		WorldCreator netherGenerator = new WorldCreator("skynether");
		netherGenerator.type(WorldType.FLAT);
		netherGenerator.generatorSettings("{\"biome\":\"minecraft:nether\", \"layers\":[{\"block\":\"minecraft:air\", \"height\":1}]}");
		skyNether = this.getServer().createWorld(netherGenerator);
		skyNether.setSpawnLocation(0, 70, 0);
		//End
		WorldCreator endGenerator = new WorldCreator("skyend");
		endGenerator.type(WorldType.FLAT);
		endGenerator.generatorSettings("{\"biome\":\"minecraft:the_end\", \"layers\":[{\"block\":\"minecraft:air\", \"height\":1}]}");
		skyEnd = this.getServer().createWorld(endGenerator);
		skyEnd.setSpawnLocation(0, 70, 0);
	}
	
	private void generateSpawnIslands(){
		if (!exists){
			for (int i = 0; i < islands.length; i++){
				try{
					islands[i].build(locations[i]);
				}
				catch(Exception e){
					System.out.println("[SkyWorld]: Generation Error!");
				}
			}
			middleIsland.build(new Location(skyWorld, -1, 64, -1));
		}
		if (!netherExists){
			netherIsland.build(new Location(skyNether, -1, 64, -1));
		}
		
		if (!endExists){
			endIsland.build(new Location(skyEnd, -1, 64, -1));
			enderPortalIsland.build(new Location(skyEnd, -4, 64, 64));
		}
	}
	
	private void loadBools(){
		try {
			BufferedReader fileNether = new BufferedReader (new FileReader("nether.txt"));
			String text = fileNether.readLine();
			if (text.equals("true")){
				netherExists = true;
			}
			else{
				netherExists = false;
			}
			fileNether.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von Nether!");
		}
		try {
			BufferedReader fileEnd = new BufferedReader (new FileReader("end.txt"));
			String text = fileEnd.readLine();
			if (text.equals("true")){
				endExists = true;
			}
			else{
				endExists = false;
			}
			fileEnd.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von End!");
		}
	}
	
	private void saveBools(){
		try {
			BufferedWriter fileNether = new BufferedWriter (new FileWriter("nether.txt"));
			fileNether.write("true");
			fileNether.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von Nether!");
		}
		try {
			BufferedWriter fileEnd = new BufferedWriter (new FileWriter("end.txt"));
			fileEnd.write("true");
			fileEnd.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von End!");
		}
	}
	
}
