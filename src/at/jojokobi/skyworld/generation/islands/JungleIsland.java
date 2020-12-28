package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;
import org.bukkit.entity.EntityType;
import java.util.Random;


import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class JungleIsland extends Island {

	public JungleIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.GenerateBiome(place.clone(), Biome.JUNGLE, 32, 32, 32);
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
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		Random random = new Random();
		if (random.nextBoolean())
			place.getWorld().generateTree(place.clone(), TreeType.COCOA_TREE);
		else
			place.getWorld().generateTree(place.clone(), TreeType.JUNGLE);
		place.setX(place.getX() + 3);
		place.getBlock().setType(Material.CHEST);
		if (random.nextBoolean())
			ChestGenerator.lootDungeon((Chest) place.getBlock().getState());
		else
			ChestGenerator.lootOverworld((Chest) place.getBlock().getState());
		place.setY(place.getY() + 1);
		if (random.nextBoolean())
			place.getWorld().spawnEntity(place, EntityType.PARROT);
		else
			place.getWorld().spawnEntity(place, EntityType.OCELOT);
	}
}
