package at.jojokobi.skyworld;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;
import at.jojokobi.skyworld.generation.SkyWorldOverworldGenerator;

//{"biome":"minecraft:ocean", "layers":[{"block":"minecraft:air", "height":1}]}
/*
 * 
 */
public class SkyWorldPlugin extends JavaPlugin{
	
	private World skyWorld;
	private PlayerSpawnSetter spawner;
	private SkyWorldOverworldGenerator gen = new SkyWorldOverworldGenerator();
	
	@Override
	public void onEnable(){
		generate();
		spawner = new PlayerSpawnSetter(skyWorld);
		getServer().getPluginManager().registerEvents(spawner, this);
		spawner.load();
	}
	
	@Override
	public void onDisable(){
		try {
			spawner.save();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void generate(){
		//Overworld
		WorldCreator generator = new WorldCreator("skyworld");
		generator.generator(gen);
		skyWorld = this.getServer().createWorld(generator);
		skyWorld.setSpawnLocation(64, 70, 0);
	}
	
}
