package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class HouseIsland extends Island {

	public HouseIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.generateBiome(place.clone(), Biome.PLAINS, 32, 32, 32);
		place.setY(place.getY() + 16);
		place.setX(place.getX() + 16);
		place.setZ(place.getZ() + 16);
		BasicGeneration.generateCube(place.clone(), Material.COBBLESTONE, 6, 6, 1);
		place.setY(place.getY() + 1);
		BasicGeneration.generateCube(place.clone(), Material.OAK_PLANKS, 6, 6, 3);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 4, 4, 3);
		place.setX(place.getX() + 2);
		place.getBlock().setType(Material.CHEST);
		Chest chest = (Chest) place.getBlock().getState();
		if (spawnIsland)
			generateChest(place);
		else
			ChestGenerator.lootVillage((Chest) place.getBlock().getState());
		place.setX(place.getX() + 1);
		place.getBlock().setType(Material.CRAFTING_TABLE);
		place.setX(place.getX() - 4);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 1, 1, 2);
		place.getBlock().setType(Material.OAK_DOOR);
		place.setZ(place.getZ() - 1);
		place.setY(place.getY() + 3);
		BasicGeneration.generateCube(place.clone(), Material.COBBLESTONE, 6, 6, 1);
		chest.getInventory().addItem(new ItemStack (Material.VILLAGER_SPAWN_EGG, 1));
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.LAVA_BUCKET, 1));
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.BONE_MEAL, 10));
		chestInventory.addItem(new ItemStack (Material.OAK_SAPLING, 10));
		chestInventory.addItem(new ItemStack (Material.DIRT, 40));
		chestInventory.addItem(new ItemStack (Material.GRASS_BLOCK, 2));
	}
}
