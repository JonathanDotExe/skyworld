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

public class MineIsland extends Island {

	public MineIsland(boolean spawnIsland) {
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
		BasicGeneration.GenerateOres(place.clone(), Material.STONE, 5, 5, 5);
		place.setY(place.getY() + 3);
		place.setX(place.getX() + 4);
		place.setZ(place.getZ() + 3);
		BasicGeneration.GenerateOres(place.clone(), Material.STONE, 3, 3, 3);
		place.setY(place.getY() + 2);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 2);
		BasicGeneration.GenerateOres(place.clone(), Material.STONE, 4, 4, 4);
		place.setY(place.getY() + 4);
		place.getBlock().setType(Material.GRASS_BLOCK);
		place.setY(place.getY() + 1);
		place.getWorld().generateTree(place.clone(), TreeType.TREE);
		place.setX(place.getX() + 1);
		place.getBlock().setType(Material.CHEST);
		if (spawnIsland)
			generateChest(place);
		else
			ChestGenerator.lootDungeon((Chest) place.getBlock().getState());
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.LAVA_BUCKET, 1));
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.DIRT, 15));
		chestInventory.addItem(new ItemStack (Material.GRASS_BLOCK, 1));
	}
}
