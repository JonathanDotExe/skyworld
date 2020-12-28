package at.jojokobi.skyworld;

import org.bukkit.event.Listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class NetherSwitcher implements Listener {
	public Location netherSpawn;
	public Location skySpawn;
	public Location endSpawn;
	
	public NetherSwitcher (World skyWorld, World skyNether, World skyEnd){
		skySpawn = new Location(skyWorld, 0, 67, 0);
		netherSpawn = new Location(skyNether, 0, 67, 0);
		endSpawn = new Location(skyEnd, 0, 67, 0);
	}
	
	@EventHandler
	public void playerMove(PlayerMoveEvent event){
		if (event.getTo().getBlock().getType() == Material.NETHER_PORTAL){
			if (event.getFrom().getWorld().getName().equals("skyworld"))
				event.setTo(netherSpawn);
			else if (event.getFrom().getWorld().getName().equals("skynether"))
				event.setTo(skySpawn);
		}
		else if (event.getTo().getBlock().getType() == Material.END_PORTAL){
			if (event.getFrom().getWorld().getName().equals("skyworld"))
				event.setTo(endSpawn);
			else if (event.getFrom().getWorld().getName().equals("skyend"))
				event.setTo(skySpawn);
		}
	}
	
}
