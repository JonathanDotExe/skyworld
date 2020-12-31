package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class NetherFortressIsland extends Island {

	public NetherFortressIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	public void build(Location place) {
		//
		BasicGeneration.generateNetherFortress(place.clone(), Material.NETHERRACK, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootNetherFortress((Chest) place.getBlock().getState());
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner1 = (CreatureSpawner) place.getBlock().getState();
		spawner1.setSpawnedType(EntityType.ZOMBIFIED_PIGLIN);
		spawner1.update();
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		place.setY(place.getY() + 7);
		//
		BasicGeneration.generateNetherFortress(place.clone(), Material.NETHERRACK, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootNetherFortress((Chest) place.getBlock().getState());
		ChestGenerator.lootNether((Chest) place.getBlock().getState());
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner2 = (CreatureSpawner) place.getBlock().getState();
		spawner2.setSpawnedType(EntityType.BLAZE);
		spawner2.update();
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		place.setY(place.getY() + 7);
		//
		BasicGeneration.generateNetherFortress(place.clone(), Material.NETHERRACK, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootNetherFortress((Chest) place.getBlock().getState());
		ChestGenerator.lootNetherFortress((Chest) place.getBlock().getState());
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner3 = (CreatureSpawner) place.getBlock().getState();
		spawner3.setSpawnedType(EntityType.BLAZE);
		spawner3.update();
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		place.setY(place.getY() + 7);
	}

}
