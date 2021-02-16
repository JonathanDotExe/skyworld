package at.jojokobi.skyworld.generation;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import java.util.Random;

public class BasicGeneration {
	
	public static void generateCube(Location place, Material block, int length, int width, int height){
		int startX = (int) place.getX();
		int startY = (int) place.getY();
		int startZ = (int) place.getZ();
		
		for (int x = 0; x < length; x++){
			place.setX(startX + x);
			for (int y = 0; y < height; y++){
				place.setY(startY + y);
				for (int z = 0; z < width; z++){
					place.setZ(startZ + z);
					place.getBlock().setType(block);
				}
			}
		}
	}
	
	public static void generateCube(Location place, Material block, int length, int width, int height, byte metadata){
		int startX = (int) place.getX();
		int startY = (int) place.getY();
		int startZ = (int) place.getZ();
		
		for (int x = 0; x < length; x++){
			place.setX(startX + x);
			for (int y = 0; y < height; y++){
				place.setY(startY + y);
				for (int z = 0; z < width; z++){
					place.setZ(startZ + z);
					place.getBlock().setType(block);
				}
			}
		}
	}
	public static void generateOres(Location place, Material block, int length, int width, int height){
		int startX = (int) place.getX();
		int startY = (int) place.getY();
		int startZ = (int) place.getZ();
		
		for (int x = 0; x < length; x++){
			place.setX(startX + x);
			for (int y = 0; y < height; y++){
				place.setY(startY + y);
				for (int z = 0; z < width; z++){
					place.setZ(startZ + z);
					Random random = new  Random();
					int zufall = random.nextInt(27);
					if (zufall < 7){
						place.getBlock().setType(block);
					}
					else if (zufall < 9){
						place.getBlock().setType(Material.DIRT);
					}
					else if (zufall < 11){
						place.getBlock().setType(Material.GRAVEL);
					}
					else if (zufall < 13){
						place.getBlock().setType(Material.COAL_ORE);
					}
					else if (zufall < 15){
						place.getBlock().setType(Material.IRON_ORE);
					}
					else if (zufall < 16){
						place.getBlock().setType(Material.GOLD_ORE);
					}
					else if (zufall < 17){
						place.getBlock().setType(Material.REDSTONE_ORE);
					}
					else if (zufall < 18){
						if (random.nextInt(10) == 1)
							place.getBlock().setType(Material.DIAMOND_ORE);
						else
							place.getBlock().setType(Material.COAL_ORE);
					}
					else if (zufall < 19){
						place.getBlock().setType(Material.OBSIDIAN);
					}
					else if (zufall < 20){
						place.getBlock().setType(Material.LAPIS_ORE);
					}
					else{
						place.getBlock().setType(block);
					}
				}
			}
		}
	}
	public static void generateDungeon(Location place, Material block, int length, int width, int height){
		int startX = (int) place.getX();
		int startY = (int) place.getY();
		int startZ = (int) place.getZ();
		
		for (int x = 0; x < length; x++){
			place.setX(startX + x);
			for (int y = 0; y < height; y++){
				place.setY(startY + y);
				for (int z = 0; z < width; z++){
					place.setZ(startZ + z);
					Random random = new  Random();
					int zufall = random.nextInt(3);
					if (zufall == 1){
						place.getBlock().setType(block);
					}
					else if (zufall == 2){
						place.getBlock().setType(Material.MOSSY_COBBLESTONE);
					}
				}
			}
		}
	}
	
	public static void generateNetherFortress(Location place, Material block, int length, int width, int height){
		int startX = (int) place.getX();
		int startY = (int) place.getY();
		int startZ = (int) place.getZ();
		
		for (int x = 0; x < length; x++){
			place.setX(startX + x);
			for (int y = 0; y < height; y++){
				place.setY(startY + y);
				for (int z = 0; z < width; z++){
					place.setZ(startZ + z);
					Random random = new  Random();
					int zufall = random.nextInt(3);
					if (zufall == 1){
						place.getBlock().setType(block);
					}
					else if (zufall == 2){
						place.getBlock().setType(Material.NETHER_BRICKS);
					}
					else{
						place.getBlock().setType(Material.NETHER_QUARTZ_ORE);
					}
				}
			}
		}
	}
	
	public static void generateEndDungeon(Location place, Material block, int length, int width, int height){
		int startX = (int) place.getX();
		int startY = (int) place.getY();
		int startZ = (int) place.getZ();
		
		for (int x = 0; x < length; x++){
			place.setX(startX + x);
			for (int y = 0; y < height; y++){
				place.setY(startY + y);
				for (int z = 0; z < width; z++){
					place.setZ(startZ + z);
					Random random = new  Random();
					int zufall = random.nextInt(3);
					if (zufall == 1){
						place.getBlock().setType(block);
					}
					else if (zufall == 2){
						place.getBlock().setType(Material.PURPUR_BLOCK);
					}
					else{
						place.getBlock().setType(Material.PURPUR_PILLAR);
					}
				}
			}
		}
	}
	
	public static void generateBiome(Location place, Biome biome, int length, int width, int height){
		int startX = (int) place.getX();
		int startY = (int) place.getY();
		int startZ = (int) place.getZ();
		
		for (int x = 0; x < length; x++){
			place.setX(startX + x);
			for (int y = 0; y < height; y++){
				place.setY(startY + y);
				for (int z = 0; z < width; z++){
					place.setZ(startZ + z);
					place.getBlock().setBiome(biome);
				}
			}
		}
	}
}
