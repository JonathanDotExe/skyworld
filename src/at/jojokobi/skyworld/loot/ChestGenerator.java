package at.jojokobi.skyworld.loot;

import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

import at.jojokobi.skyworld.generation.islands.RainbowIsland;

import java.util.Random;

public class ChestGenerator {
	
	public static void lootOverworld(Chest chest){
		Random random = new Random();
		switch (random.nextInt(5)) {
		case 0:
			chest.getInventory().addItem(new ItemStack(Material.OAK_SAPLING, random.nextInt(2)));
			break;
		case 1:
			chest.getInventory().addItem(new ItemStack(Material.BIRCH_SAPLING, random.nextInt(2)));
			break;
		case 2:
			chest.getInventory().addItem(new ItemStack(Material.SPRUCE_SAPLING, random.nextInt(2)));
			break;
		case 3:
			chest.getInventory().addItem(new ItemStack(Material.JUNGLE_SAPLING, random.nextInt(2)));
			break;
		case 4:
			chest.getInventory().addItem(new ItemStack(Material.DARK_OAK_SAPLING, random.nextInt(2)));
			break;
		case 5:
			chest.getInventory().addItem(new ItemStack(Material.ACACIA_SAPLING, random.nextInt(2)));
			break;
		}
		chest.getInventory().addItem(new ItemStack(Material.OAK_LOG, random.nextInt(8)));
		chest.getInventory().addItem(new ItemStack(Material.STICK, random.nextInt(16)));
		chest.getInventory().addItem(new ItemStack(Material.OAK_PLANKS, random.nextInt(32)));
		chest.getInventory().addItem(new ItemStack(Material.DIRT, random.nextInt(16)));
		if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.ARROW, random.nextInt(8)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.GRASS_BLOCK, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.APPLE, random.nextInt(5)));
		chest.getInventory().addItem(new ItemStack(Material.WHEAT_SEEDS, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.CARROT, random.nextInt(3)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack (Material.POTATO, random.nextInt(4)));
		if (random.nextBoolean()){
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack (Material.CHICKEN_SPAWN_EGG, 1));
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack (Material.PIG_SPAWN_EGG, 1));
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack (Material.COW_SPAWN_EGG, 1));
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack (Material.SHEEP_SPAWN_EGG, 1));
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack (Material.HORSE_SPAWN_EGG, 1));
		}
	}
	
	public static void lootNether(Chest chest){
		Random random = new Random();
		chest.getInventory().addItem(new ItemStack(Material.GRAVEL, random.nextInt(16)));
		chest.getInventory().addItem(new ItemStack(Material.IRON_INGOT, random.nextInt(8)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, random.nextInt(6)));;
		chest.getInventory().addItem(new ItemStack(Material.STRING, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.BONE, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.ROTTEN_FLESH, random.nextInt(8)));
		chest.getInventory().addItem(new ItemStack(Material.NETHERRACK, random.nextInt(16)));
		chest.getInventory().addItem(new ItemStack(Material.GOLD_NUGGET, random.nextInt(32)));
		chest.getInventory().addItem(new ItemStack(Material.QUARTZ, random.nextInt(16)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.MAGMA_CREAM, random.nextInt(8)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, random.nextInt(2)));
	}
	
	public static void lootNetherFortress(Chest chest){
		Random random = new Random();
		chest.getInventory().addItem(new ItemStack(Material.GRAVEL, random.nextInt(16)));
		chest.getInventory().addItem(new ItemStack(Material.IRON_INGOT, random.nextInt(10)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, random.nextInt(5)));;;
		chest.getInventory().addItem(new ItemStack(Material.NETHERRACK, random.nextInt(32)));
		chest.getInventory().addItem(new ItemStack(Material.GOLD_NUGGET, random.nextInt(32)));
		chest.getInventory().addItem(new ItemStack(Material.QUARTZ, random.nextInt(16)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.MAGMA_CREAM, random.nextInt(16)));
		chest.getInventory().addItem(new ItemStack(Material.NETHER_WART, random.nextInt(8)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.GHAST_TEAR, random.nextInt(2)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, random.nextInt(2)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.RABBIT_FOOT, random.nextInt(2)));
		if (random.nextBoolean()){
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE, 1));
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
			if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS, 1));
		}
		if (random.nextBoolean())
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.ELYTRA, 1));
		if (random.nextBoolean() && random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.WITHER_SKELETON_SKULL, 1));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.OBSIDIAN, random.nextInt(10)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.END_PORTAL_FRAME, random.nextInt(3)));
	}
	
	public static void lootDungeon(Chest chest){
		Random random = new Random();
		chest.getInventory().addItem(new ItemStack(Material.IRON_INGOT, random.nextInt(6)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.COAL, random.nextInt(8)));
		chest.getInventory().addItem(new ItemStack(Material.REDSTONE, random.nextInt(8)));
		chest.getInventory().addItem(new ItemStack(Material.STRING, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.BONE, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.ROTTEN_FLESH, random.nextInt(8)));
		chest.getInventory().addItem(new ItemStack(Material.MOSSY_COBBLESTONE, random.nextInt(32)));
		if (random.nextBoolean())
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, random.nextInt(3)));
		if (random.nextBoolean())
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.DIAMOND, random.nextInt(3)));
		chest.getInventory().addItem(new ItemStack(Material.BREAD, random.nextInt(8)));
		if (random.nextBoolean()){
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE, 1));
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
			if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS, 1));
		}
		if (random.nextBoolean())
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.ELYTRA, 1));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.FIREWORK_ROCKET, random.nextInt(16)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.FLINT, random.nextInt(8)));
	}
	
	public static void lootColor(Chest chest){
		Random random = new Random();
		for (int i = 0; i < RainbowIsland.WOOLS.length; i++) {
			chest.getInventory().addItem(new ItemStack (RainbowIsland.WOOLS[i], random.nextInt(16)));
		}
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.FIREWORK_ROCKET, random.nextInt(16)));
		chest.getInventory().addItem(new ItemStack (Material.CLAY, random.nextInt(16)));
	}
	
	public static void lootVillage(Chest chest){
		Random random = new Random();
		chest.getInventory().addItem(new ItemStack(Material.IRON_INGOT, random.nextInt(3)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, random.nextInt(2)));
		chest.getInventory().addItem(new ItemStack(Material.COAL, random.nextInt(4)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_HELMET, 1));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE, 1));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE, 1));
		if (random.nextBoolean())
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, random.nextInt(3)));
		chest.getInventory().addItem(new ItemStack(Material.BREAD, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.OAK_LOG, random.nextInt(6)));
		chest.getInventory().addItem(new ItemStack(Material.STICK, random.nextInt(4)));
		chest.getInventory().addItem(new ItemStack(Material.OAK_PLANKS, random.nextInt(16)));
		chest.getInventory().addItem(new ItemStack(Material.APPLE, random.nextInt(3)));
	}
	
	public static void lootRandom(Chest chest){
		Random random = new Random();
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.OAK_SAPLING, random.nextInt(2)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.OAK_LOG, random.nextInt(6)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.STICK, random.nextInt(4)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.OAK_PLANKS, random.nextInt(16)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.DIRT, random.nextInt(8)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.GRASS_BLOCK, random.nextInt(2)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.APPLE, random.nextInt(3)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.WHEAT_SEEDS, random.nextInt(3)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.CARROT, random.nextInt(2)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack (Material.POTATO, random.nextInt(2)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean()){
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.CHICKEN_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.PIG_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.COW_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.SHEEP_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.HORSE_SPAWN_EGG, 1));
			}
		if (random.nextInt(2) == 1) {
			chest.getInventory().addItem(new ItemStack(Material.ARROW, random.nextInt(8)));
		}
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, random.nextInt(2)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.COAL, random.nextInt(4)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.REDSTONE, random.nextInt(8)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.STRING, random.nextInt(4)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.BONE, random.nextInt(4)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.ROTTEN_FLESH, random.nextInt(8)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.MOSSY_COBBLESTONE, random.nextInt(8)));
		if (random.nextInt(2) == 1)
				if (random.nextBoolean())
					if (random.nextBoolean())
						chest.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, random.nextInt(3)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.BREAD, random.nextInt(4)));		
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.IRON_INGOT, random.nextInt(3)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_HELMET, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE, 1));
		for (int i = 0; i < RainbowIsland.WOOLS.length; i++) {
			chest.getInventory().addItem(new ItemStack (RainbowIsland.WOOLS[i], random.nextInt(16)));
		}
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.DIAMOND, random.nextInt(3)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.ELYTRA, 1));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.FIREWORK_ROCKET, random.nextInt(16)));
		if (random.nextBoolean())
			chest.getInventory().addItem(new ItemStack(Material.END_PORTAL_FRAME, random.nextInt(3)));
	}
	public static void lootSuperRandom(Chest chest){
		Random random = new Random();
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.OAK_LOG, random.nextInt(16)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.GRASS_BLOCK, random.nextInt(3)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.CARROT, random.nextInt(4)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack (Material.POTATO, random.nextInt(4)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean()){
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.CHICKEN_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.PIG_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.COW_SPAWN_EGG, 1));
				if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack (Material.SHEEP_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.HORSE_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.WOLF_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.OCELOT_SPAWN_EGG, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack (Material.PARROT_SPAWN_EGG, 1));
		}
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, random.nextInt(8)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.COAL, random.nextInt(16)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.REDSTONE, random.nextInt(16)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.MOSSY_COBBLESTONE, random.nextInt(32)));
		if (random.nextInt(2) == 1)
				if (random.nextBoolean())
						chest.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, random.nextInt(3)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.BREAD, random.nextInt(8)));		
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.IRON_INGOT, random.nextInt(16)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_HELMET, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
				chest.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.DIAMOND, random.nextInt(3)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.END_PORTAL_FRAME, random.nextInt(10)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.EMERALD, random.nextInt(4)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.OBSIDIAN, random.nextInt(20)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.SUGAR_CANE, random.nextInt(3)));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.ELYTRA, 1));
		if (random.nextInt(2) == 1)
			if (random.nextBoolean()){
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
				if (random.nextBoolean())
					chest.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS, 1));
			}
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.COBBLESTONE, random.nextInt(128)));
		if (random.nextInt(2) == 1)
				chest.getInventory().addItem(new ItemStack(Material.SLIME_BALL, random.nextInt(4)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.ARROW, random.nextInt(8)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.FLINT, random.nextInt(8)));
		if (random.nextInt(2) == 1)
			chest.getInventory().addItem(new ItemStack(Material.FIREWORK_ROCKET, random.nextInt(16)));
	}
}
