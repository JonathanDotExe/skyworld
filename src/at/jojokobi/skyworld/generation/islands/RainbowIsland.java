package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import at.jojokobi.skyworld.loot.ChestGenerator;
import at.jojokobi.skyworld.generation.BasicGeneration;
import java.util.Random;

public class RainbowIsland extends Island {

	public static final Material[] WOOLS = {Material.WHITE_WOOL, Material.ORANGE_WOOL, Material.MAGENTA_WOOL, Material.LIGHT_BLUE_WOOL, Material.YELLOW_WOOL, Material.LIME_WOOL, Material.PINK_WOOL, Material.GRAY_WOOL, Material.LIGHT_GRAY_WOOL, Material.CYAN_WOOL, Material.PURPLE_WOOL, Material.BLUE_WOOL, Material.BROWN_WOOL, Material.GREEN_WOOL, Material.RED_WOOL, Material.BLACK_WOOL};
	
	public RainbowIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		place.setY(place.getY() - 16);
		place.setX(place.getX() - 16);
		place.setZ(place.getZ() - 16);
		BasicGeneration.GenerateBiome(place.clone(), Biome.THE_VOID, 32, 32, 32);
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
		BasicGeneration.GenerateCube(place.clone(), Material.WHITE_WOOL, 7, 7, 1);
		Random random = new Random();
		int startX = (int) place.getX();
		int startZ = (int) place.getZ();
		for (int x = 0; x < 7; x++){
			place.setX(startX + x);
			for (int z = 0; z < 7; z++){
				place.setZ(startZ + z);
				place.getBlock().setType(WOOLS[random.nextInt(WOOLS.length)]);;
			}
		}
		place.setX(place.getX() - 4);
		place.setZ(place.getZ() - 4);
		BasicGeneration.GenerateCube(place.clone(), Material.GRASS_BLOCK, 3, 3, 1);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		place.getWorld().generateTree(place.clone(), TreeType.TREE);
		place.setX(place.getX() + 1);
		place.getBlock().setType(Material.CHEST);
		if (spawnIsland)
			generateChest(place);
		else
			ChestGenerator.lootColor((Chest) place.getBlock().getState());
	}
	
	private void generateChest (Location place){
		Chest chest = (Chest) place.getBlock().getState();
		Inventory chestInventory = chest.getBlockInventory();
		chestInventory.addItem(new ItemStack (Material.LAVA_BUCKET, 1));
		chestInventory.addItem(new ItemStack (Material.ICE, 1));
		chestInventory.addItem(new ItemStack (Material.BONE_MEAL, 2));
		chestInventory.addItem(new ItemStack (Material.ORANGE_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.MAGENTA_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.LIGHT_BLUE_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.YELLOW_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.LIME_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.PINK_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.GRAY_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.LIGHT_GRAY_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.CYAN_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.PURPLE_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.LAPIS_LAZULI, 2));
		chestInventory.addItem(new ItemStack (Material.COCOA_BEANS, 2));
		chestInventory.addItem(new ItemStack (Material.GREEN_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.RED_DYE, 2));
		chestInventory.addItem(new ItemStack (Material.INK_SAC, 2));
		chestInventory.addItem(new ItemStack (Material.SHEEP_SPAWN_EGG, 2));
	}
}
