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

public class MiniDungeonIsland extends Island {

	public MiniDungeonIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.GenerateBiome(place.clone(), Biome.MOUNTAINS, 32, 32, 32);
		place.setY(place.getY() + 16);
		place.setX(place.getX() + 16);
		place.setZ(place.getZ() + 16);
		BasicGeneration.GenerateCube(place.clone(), Material.COBBLESTONE, 8, 8, 1);
		BasicGeneration.GenerateDungeon(place.clone(), Material.COBBLESTONE, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.GenerateCube(place.clone(), Material.AIR, 6, 6, 7);
		place.getBlock().setType(Material.CHEST);
		if (spawnIsland)
			generateChest(place);
		else
			ChestGenerator.lootDungeon((Chest) place.getBlock().getState());
		place.setY(place.getY() + 7);
		place.setX(place.getX() - 1);
		place.getBlock().setType(Material.GRASS_BLOCK);
		place.setY(place.getY() + 1);
		place.getWorld().generateTree(place.clone(), TreeType.TREE);
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.LAVA_BUCKET, 1));
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.DIRT, 15));
		chestInventory.addItem(new ItemStack (Material.GRASS_BLOCK, 1));
		chestInventory.addItem(new ItemStack (Material.COBWEB, 16));
		chestInventory.addItem(new ItemStack (Material.VINE, 16));
		chestInventory.addItem(new ItemStack (Material.IRON_INGOT, 4));
		chestInventory.addItem(new ItemStack (Material.GOLD_NUGGET, 9));
	}
}
