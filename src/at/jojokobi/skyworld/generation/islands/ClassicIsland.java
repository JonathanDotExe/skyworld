package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class ClassicIsland extends Island{

	public ClassicIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.generateBiome(place.clone(), Biome.SNOWY_TAIGA, 32, 32, 32);
		place.setY(place.getY() + 16);
		place.setX(place.getX() + 16);
		place.setZ(place.getZ() + 16);
		BasicGeneration.generateCube(place.clone() , Material.GRASS_BLOCK, 3, 3, 3);
		BasicGeneration.generateCube(place.clone() , Material.DIRT, 3, 3, 2);
		place.setX(place.getX() + 3);
		BasicGeneration.generateCube(place.clone() , Material.GRASS_BLOCK, 3, 3, 3);
		BasicGeneration.generateCube(place.clone() , Material.DIRT, 3, 3, 2);
		place.setZ(place.getZ() + 3);
		BasicGeneration.generateCube(place.clone() , Material.GRASS_BLOCK, 3, 3, 3);
		BasicGeneration.generateCube(place.clone() , Material.DIRT, 3, 3, 2);
		place.setY(place.getY() + 3);
		place.getBlock().setType(Material.CHEST);
		if (spawnIsland)
			generateChest(place);
		else
			ChestGenerator.lootRandom((Chest) place.getBlock().getState());
		place.setZ(place.getZ() - 3);
		place.setX(place.getX() - 3);
		place.getWorld().generateTree(place.clone(), TreeType.TREE);
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.LAVA_BUCKET, 1));
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.BONE_MEAL, 10));
		chestInventory.addItem(new ItemStack (Material.SHIELD, 1));
		chestInventory.addItem(new ItemStack (Material.ENDER_PEARL, 1));
	}
}
