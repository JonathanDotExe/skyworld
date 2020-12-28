package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.jojokobi.skyworld.generation.BasicGeneration;

public class NetherIsland extends Island {

	public NetherIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		BasicGeneration.GenerateCube(place.clone(), Material.GLOWSTONE, 3, 3, 3);
		place.setY(place.getY() + 3);
		place.getBlock().setType(Material.CHEST);
		generateChest (place);
		place.setX(place.getX() + 3);
		place.setY(place.getY() + 1);
		BasicGeneration.GenerateCube(place.clone(), Material.OBSIDIAN, 1, 4, 5);
		place.setY(place.getY() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.GenerateCube(place.clone(), Material.NETHER_PORTAL, 1, 2, 3);
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.BIRCH_SAPLING, 1));
		chestInventory.addItem(new ItemStack (Material.SUGAR_CANE, 1));
		chestInventory.addItem(new ItemStack (Material.BROWN_MUSHROOM, 1));
		chestInventory.addItem(new ItemStack (Material.RED_MUSHROOM, 1));
	}
}
