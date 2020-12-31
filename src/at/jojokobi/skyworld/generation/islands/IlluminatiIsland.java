package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class IlluminatiIsland extends Island {

	public IlluminatiIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		BasicGeneration.generateCube(place.clone(), Material.GREEN_WOOL, 9, 1, 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.GREEN_WOOL, 7, 2, 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 2);
		BasicGeneration.generateCube(place.clone(), Material.GREEN_WOOL, 5, 1, 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.GREEN_WOOL, 3, 2, 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 2);
		BasicGeneration.generateCube(place.clone(), Material.GREEN_WOOL, 1, 2, 1);
		place.setZ(place.getZ() - 5);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner = (CreatureSpawner) place.getBlock().getState();
		spawner.setSpawnedType(EntityType.GUARDIAN);
		spawner.update();
		place.setY(place.getY() + 1);
		place.setX(place.getX() - 1);
		BasicGeneration.generateCube(place.clone(), Material.WHITE_WOOL, 3, 2, 1);
		place.setX(place.getX() + 1);
		place.getBlock().setType(Material.BLACK_WOOL);
		place.setZ(place.getZ() + 1);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootOverworld((Chest) place.getBlock().getState());
		ChestGenerator.lootRandom((Chest) place.getBlock().getState());
	}

}
