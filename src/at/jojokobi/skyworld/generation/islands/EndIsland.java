package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.jojokobi.skyworld.generation.BasicGeneration;

public class EndIsland extends Island {

	public EndIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		BasicGeneration.GenerateCube(place.clone(), Material.END_STONE, 3, 3, 2);
		place.setY(place.getY() + 2);
		BasicGeneration.GenerateCube(place.clone(), Material.OBSIDIAN, 3, 3, 1);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		place.getBlock().setType(Material.CHEST);
		generateChest(place);
	}

	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.ELYTRA, 4));
		chestInventory.addItem(new ItemStack (Material.ENDER_PEARL, 16));
		chestInventory.addItem(new ItemStack (Material.DRAGON_EGG, 1));
		chestInventory.addItem(new ItemStack (Material.BROWN_MUSHROOM, 1));
		chestInventory.addItem(new ItemStack (Material.RED_MUSHROOM, 1));
		chestInventory.addItem(new ItemStack (Material.MOOSHROOM_SPAWN_EGG, 1));
	}
}
