package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

import java.util.Random;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class TowerIsland extends Island {

	private EntityType[] mobs = new EntityType[] {EntityType.ZOMBIE, EntityType.SKELETON, EntityType.SPIDER, EntityType.CAVE_SPIDER};  
	
	public TowerIsland(boolean spawnIsland) {
		super(spawnIsland);
	}


	public void build(Location place) {
		Random random = new Random();
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.generateBiome(place.clone(), Biome.MOUNTAINS, 32, 64, 32);
		place.setY(place.getY() + 16);
		place.setX(place.getX() + 16);
		place.setZ(place.getZ() + 16);
		//Stockwerk 1
		BasicGeneration.generateCube(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		BasicGeneration.generateDungeon(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootDungeon((Chest) place.getBlock().getState());
		ChestGenerator.lootDungeon((Chest) place.getBlock().getState());
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner1 = (CreatureSpawner) place.getBlock().getState();
		spawner1.setSpawnedType(mobs[random.nextInt(mobs.length)]);
		spawner1.update();
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		place.setY(place.getY() + 7);
		//Stockwerk 2
		BasicGeneration.generateCube(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		BasicGeneration.generateDungeon(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootVillage((Chest) place.getBlock().getState());
		ChestGenerator.lootVillage((Chest) place.getBlock().getState());
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner2 = (CreatureSpawner) place.getBlock().getState();
		spawner2.setSpawnedType(mobs[random.nextInt(mobs.length)]);
		spawner2.update();
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		place.setY(place.getY() + 7);
		//Stockwerk 3
		BasicGeneration.generateCube(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		BasicGeneration.generateDungeon(place.clone(), Material.SPAWNER, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootRandom((Chest) place.getBlock().getState());
		ChestGenerator.lootRandom((Chest) place.getBlock().getState());
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner3 = (CreatureSpawner) place.getBlock().getState();
		spawner3.setSpawnedType(mobs[random.nextInt(mobs.length)]);
		spawner3.update();
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		place.setY(place.getY() + 7);
		//Stockwerk 4
		BasicGeneration.generateCube(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		BasicGeneration.generateDungeon(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootRandom((Chest) place.getBlock().getState());
		ChestGenerator.lootRandom((Chest) place.getBlock().getState());
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner4 = (CreatureSpawner) place.getBlock().getState();
		spawner4.setSpawnedType(mobs[random.nextInt(mobs.length)]);
		spawner4.update();
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		place.setY(place.getY() + 7);
		//Stockwerk 5
		BasicGeneration.generateCube(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		BasicGeneration.generateDungeon(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		ChestGenerator.lootSuperRandom((Chest) place.getBlock().getState());
		ChestGenerator.lootSuperRandom((Chest) place.getBlock().getState());
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner5 = (CreatureSpawner) place.getBlock().getState();
		spawner5.setSpawnedType(mobs[random.nextInt(mobs.length)]);
		spawner5.update();
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		place.setY(place.getY() + 7);
	}
}
