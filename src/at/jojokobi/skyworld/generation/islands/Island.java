package at.jojokobi.skyworld.generation.islands;

import org.bukkit.Location;

public abstract class Island {
	
	protected boolean spawnIsland;
	
	public Island(boolean spawnIsland){
		this.spawnIsland = spawnIsland;
	}
	
	public abstract void build(Location place);
}
