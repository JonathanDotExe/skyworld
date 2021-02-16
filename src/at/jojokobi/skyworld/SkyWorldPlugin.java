package at.jojokobi.skyworld;

import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import at.jojokobi.skyworld.generation.SkyWorldOverworldGenerator;

//{"biome":"minecraft:ocean", "layers":[{"block":"minecraft:air", "height":1}]}
/*
 * 
 */
public class SkyWorldPlugin extends JavaPlugin{
	
	private PlayerSpawnSetter spawner;
	
	@Override
	public void onEnable(){
		Bukkit.getScheduler().runTask(this, () -> {
			spawner = new PlayerSpawnSetter(Bukkit.getWorlds().get(0));
			getServer().getPluginManager().registerEvents(spawner, this);
			spawner.load();
		});
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
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new SkyWorldOverworldGenerator();
	}
	
}
