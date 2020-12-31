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

public class FarmIsland extends Island {

	public FarmIsland(boolean spawnIsland) {
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
		BasicGeneration.generateCube(place.clone(), Material.DIRT, 4, 4, 2);
		place.setY(place.getY() + 2);
		place.setX(place.getX() - 1);
		place.setZ(place.getZ() - 1);
		BasicGeneration.generateCube(place.clone(), Material.GRASS_BLOCK, 6, 6, 1);
		place.setY(place.getY() + 1);
		BasicGeneration.generateCube(place.clone(), Material.GRASS, 6, 6, 1, (byte) 1);
		place.setZ(place.getZ() + 3);
		place.setX(place.getX() + 4);
		place.getBlock().setType(Material.AIR);
		place.getWorld().generateTree(place.clone(), TreeType.TREE);
		place.setX(place.getX() + 1);
		place.getBlock().setType(Material.CHEST);
		if (spawnIsland)
			generateChest(place);
		else
			ChestGenerator.lootOverworld((Chest) place.getBlock().getState());
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.LAVA_BUCKET, 1));
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.HORSE_SPAWN_EGG, 1));
		chestInventory.addItem(new ItemStack (Material.WHEAT_SEEDS, 2));
		chestInventory.addItem(new ItemStack (Material.POTATO, 20));
		chestInventory.addItem(new ItemStack (Material.DARK_OAK_SAPLING, 2));
		chestInventory.addItem(new ItemStack (Material.LEAD, 2));
		chestInventory.addItem(new ItemStack (Material.RED_MUSHROOM, 1));
	}
}
