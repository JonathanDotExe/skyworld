package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;
import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class SwampIsland extends Island {

	public SwampIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.GenerateBiome(place.clone(), Biome.SWAMP, 32, 32, 32);
		place.setY(place.getY() + 16);
		place.setX(place.getX() + 16);
		place.setZ(place.getZ() + 16);
		place.getBlock().setType(Material.DIRT);
		place.setY(place.getY() + 1);
		place.setX(place.getX() - 1);
		place.setZ(place.getZ() - 1);
		BasicGeneration.GenerateCube(place.clone(), Material.DIRT, 3, 3, 1);
		place.setY(place.getY() + 1);
		place.setX(place.getX() - 1);
		place.setZ(place.getZ() - 1);
		BasicGeneration.GenerateCube(place.clone(), Material.DIRT, 5, 5, 1);
		place.setY(place.getY() + 1);
		place.setX(place.getX() - 1);
		place.setZ(place.getZ() - 1);
		BasicGeneration.GenerateCube(place.clone(), Material.GRASS_BLOCK, 7, 7, 1);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootRandom((Chest) place.getBlock().getState());
		place.setX(place.getX() - 1);
		place.setZ(place.getZ() - 1);
		place.getBlock().setType(Material.AIR);
		place.getWorld().generateTree(place.clone(), TreeType.SWAMP);
		place.setY(place.getY() - 1);
		place.setX(place.getX() + 1);
		place.getBlock().setType(Material.WATER);
	}
}
