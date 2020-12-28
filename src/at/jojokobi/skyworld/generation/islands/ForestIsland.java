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

public class ForestIsland extends Island {

	public ForestIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.GenerateBiome(place.clone(), Biome.FOREST, 32, 32, 32);
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
		BasicGeneration.GenerateCube(place.clone(), Material.GRASS, 7, 7, 1);
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getBlock().setType(Material.CHEST);
		if (spawnIsland)
			generateChest(place);
		else
			ChestGenerator.lootOverworld((Chest) place.getBlock().getState());
		place.setX(place.getX() - 3);
		place.setZ(place.getZ() - 3);
		place.getBlock().setType(Material.AIR);
		place.getWorld().generateTree(place.clone(), TreeType.TREE);
		place.setX(place.getX() + 7);
		place.setZ(place.getZ() + 7);
		place.getBlock().setType(Material.AIR);
		place.getWorld().generateTree(place.clone(), TreeType.TREE);
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.LAVA_BUCKET, 1));
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.BONE_MEAL, 20));
		chestInventory.addItem(new ItemStack (Material.DARK_OAK_SAPLING, 2));
		chestInventory.addItem(new ItemStack (Material.WOODEN_AXE, 1));
		chestInventory.addItem(new ItemStack (Material.STONE_AXE, 1));
	}
}
