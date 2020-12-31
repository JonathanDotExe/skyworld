package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class SandIsland extends Island {

	public SandIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		if (spawnIsland)
			BasicGeneration.generateBiome(place.clone(), Biome.BEACH, 32, 32, 32);
		else
			BasicGeneration.generateBiome(place.clone(), Biome.DESERT, 32, 32, 32);
		place.setY(place.getY() + 16);
		place.setX(place.getX() + 16);
		place.setZ(place.getZ() + 16);
		place.setY(place.getY() - 1);
		BasicGeneration.generateCube(place.clone(), Material.SANDSTONE, 3, 3, 1);
		place.setY(place.getY() + 1);
		BasicGeneration.generateCube(place.clone(), Material.SAND, 3, 3, 3);
		place.setY(place.getY() + 3);
		place.getBlock().setType(Material.CACTUS);
		place.setX(place.getX() + 2);
		place.getBlock().setType(Material.CHEST);
		if (spawnIsland)
			generateChest (place);
		else{
			ChestGenerator.lootDungeon((Chest) place.getBlock().getState());
			ChestGenerator.lootRandom((Chest) place.getBlock().getState());
		}
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.OBSIDIAN, 10));
		chestInventory.addItem(new ItemStack (Material.MELON, 1));
		chestInventory.addItem(new ItemStack (Material.PUMPKIN_SEEDS, 1));
		chestInventory.addItem(new ItemStack (Material.CARROT, 1));
	}
}
