package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import java.util.Random;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class NetherrackIsland extends Island {

	public NetherrackIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		BasicGeneration.generateCube(place.clone(), Material.NETHERRACK, 3, 3, 2);
		place.setY(place.getY() + 2);
		BasicGeneration.generateCube(place.clone(), Material.SOUL_SAND, 3, 3, 1);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootNether((Chest) place.getBlock().getState());
		place.setY(place.getX() + 1);
		if (new Random().nextInt(6) == 3) {
			place.getBlock().setType(Material.NETHER_WART_BLOCK);
		}
	}

}
