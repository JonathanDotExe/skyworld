package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import at.jojokobi.skyworld.generation.BasicGeneration;
import at.jojokobi.skyworld.loot.ChestGenerator;

public class LlamaIsland extends Island {

	public LlamaIsland(boolean spawnIsland) {
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
		place.setX(place.getX() + 3);
		place.setZ(place.getZ() + 3);
		place.getWorld().generateTree(place.clone(), TreeType.TREE);
		place.setX(place.getX() + 4);
		place.getBlock().setType(Material.CHEST);
		if (spawnIsland)
			generateChest(place);
		else
			ChestGenerator.lootOverworld((Chest) place.getBlock().getState());
		place.setY(place.getY() + 1);
		place.getWorld().spawnEntity(place, EntityType.LLAMA);
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.LAVA_BUCKET, 1));
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.LLAMA_SPAWN_EGG, 1));
		chestInventory.addItem(new ItemStack (Material.RED_CARPET, 20));
		chestInventory.addItem(new ItemStack (Material.WHEAT, 20));
		chestInventory.addItem(new ItemStack (Material.GRAVEL, 2));
		chestInventory.addItem(new ItemStack (Material.LEAD, 2));
		chestInventory.addItem(new ItemStack (Material.HAY_BLOCK, 2));
	}
}
