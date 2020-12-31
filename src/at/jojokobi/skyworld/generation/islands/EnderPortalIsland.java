package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

import at.jojokobi.skyworld.generation.BasicGeneration;

public class EnderPortalIsland extends Island{

	public EnderPortalIsland(boolean spawnIsland) {
		super(spawnIsland);
	}

	@Override
	public void build(Location place) {
		BasicGeneration.generateCube(place.clone(), Material.END_STONE_BRICKS, 8, 8, 8);
		BasicGeneration.generateDungeon(place.clone(), Material.END_STONE_BRICKS, 8, 8, 8);
		place.setY(place.getY() + 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.AIR, 6, 6, 6);
		place.getBlock().setType(Material.SPAWNER);
		CreatureSpawner spawner = (CreatureSpawner) place.getBlock().getState();
		spawner.setSpawnedType(EntityType.ENDERMAN);
		spawner.update();
		place.setY(place.getY() - 1);
		place.setX(place.getX() + 1);
		place.setZ(place.getZ() + 1);
		BasicGeneration.generateCube(place.clone(), Material.END_PORTAL, 4, 4, 1);
	}

}
