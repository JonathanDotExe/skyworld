package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class SuperRandomIsland extends Island {

	public SuperRandomIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.generateBiome(place.clone(), Biome.THE_VOID, 32, 32, 32);
		place.setY(place.getY() + 16);
		place.setX(place.getX() + 16);
		place.setZ(place.getZ() + 16);
		BasicGeneration.generateCube(place.clone(), Material.STONE, 3, 3, 2);
		place.setY(place.getY() + 2);
		BasicGeneration.generateCube(place.clone(), Material.GLOWSTONE, 3, 3, 1);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootSuperRandom((Chest) place.getBlock().getState());
	}
}
