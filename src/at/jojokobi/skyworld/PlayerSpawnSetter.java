package at.jojokobi.skyworld;

import org.bukkit.event.Listener;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class PlayerSpawnSetter implements Listener {
	
	private Location[] locations;
	private ArrayList<String> classic = new ArrayList <String> ();
	private ArrayList<String> farm = new ArrayList <String> ();
	private ArrayList<String> dungeon = new ArrayList <String> ();
	private ArrayList<String> mine = new ArrayList <String> ();
	private ArrayList<String> llama = new ArrayList <String> ();
	private ArrayList<String> forest = new ArrayList <String> ();
	private ArrayList<String> rainbow = new ArrayList <String> ();
	private ArrayList<String> house = new ArrayList <String> ();
			
	public PlayerSpawnSetter (World skyWorld){
		locations = new Location[] {new Location(skyWorld, 64, 70, 0), new Location(skyWorld, 32, 70, 32), new Location(skyWorld, 0, 70, 64), new Location(skyWorld, -32, 70, 32), new Location(skyWorld, -64, 70, 0), new Location(skyWorld, -32, 70, -32), new Location(skyWorld, 0, 70, -64), new Location(skyWorld, 32, 70, -32)};
	}
	
	@EventHandler
	public void playerJoin(PlayerSpawnLocationEvent event){
		String player = event.getPlayer().getName();
		if ((!classic.contains(player)) && (!rainbow.contains(player)) && (!forest.contains(player)) && (!house.contains(player)) && (!farm.contains(player)) && (!llama.contains(player)) && (!mine.contains(player)) && (!dungeon.contains(player))){
			Random random = new Random();
			int num = random.nextInt(locations.length);
			Location island = locations[num];
			event.setSpawnLocation(island);
			if(num == 0)
				classic.add(player);
			else if(num == 1)
				rainbow.add(player);
			else if(num == 2)
				forest.add(player);
			else if(num == 3)
				house.add(player);
			else if(num == 4)
				farm.add(player);
			else if(num == 5)
				llama.add(player);
			else if(num == 6)
				mine.add(player);
			else if(num == 7)
				dungeon.add(player);
		}
	}
	
	@EventHandler
	public void playerRespawn(PlayerRespawnEvent event){
		Player player = event.getPlayer();
		if (player.getBedSpawnLocation() == null) {
			if (classic.contains(player.getName()))
				event.setRespawnLocation(locations[0]);
			else if (rainbow.contains(player.getName()))
				event.setRespawnLocation(locations[1]);
			else if (forest.contains(player.getName()))
				event.setRespawnLocation(locations[2]);
			else if (house.contains(player.getName()))
				event.setRespawnLocation(locations[3]);
			else if (farm.contains(player.getName()))
				event.setRespawnLocation(locations[4]);
			else if (llama.contains(player.getName()))
				event.setRespawnLocation(locations[5]);
			else if (mine.contains(player.getName()))
				event.setRespawnLocation(locations[6]);
			else if (dungeon.contains(player.getName()))
				event.setRespawnLocation(locations[7]);
		}
	}
	
	
	public void save(){
		//Classic
		try {
			BufferedWriter fileClassic = new BufferedWriter (new FileWriter("classic.txt"));
			for (int i = 0; i < classic.size(); i++)
				fileClassic.write(classic.get(i) + "\r\n");
			fileClassic.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von Classic!");
		}
		//Farm
		try {
			BufferedWriter fileFarm = new BufferedWriter (new FileWriter("farm.txt"));
			for (int i = 0; i < farm.size(); i++)
				fileFarm.write(farm.get(i) + "\r\n");
			fileFarm.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von Farm!");
		}
		//Dungeon
		try {
			BufferedWriter fileDungeon = new BufferedWriter (new FileWriter("dungeon.txt"));
			for (int i = 0; i < dungeon.size(); i++)
				fileDungeon.write(dungeon.get(i) + "\r\n");
			fileDungeon.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von Dungeon!");
		}
		//Mine
		try {
			BufferedWriter fileMine = new BufferedWriter (new FileWriter("mine.txt"));
			for (int i = 0; i < mine.size(); i++)
				fileMine.write(mine.get(i) + "\r\n");
			fileMine.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von Mine!");
		}
		//Llama
		try {
			BufferedWriter fileLlama = new BufferedWriter (new FileWriter("llama.txt"));
			for (int i = 0; i < llama.size(); i++)
				fileLlama.write(llama.get(i) + "\r\n");
			fileLlama.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von Llama!");
		}
		//Forest
		try {
			BufferedWriter fileForest = new BufferedWriter (new FileWriter("forest.txt"));
			for (int i = 0; i < forest.size(); i++)
				fileForest.write(forest.get(i) + "\r\n");
			fileForest.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von Forest!");
		}
		//Rainbow
		try {
			BufferedWriter fileRainbow = new BufferedWriter (new FileWriter("rainbow.txt"));
			for (int i = 0; i < rainbow.size(); i++)
				fileRainbow.write(rainbow.get(i) + "\r\n");
			fileRainbow.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von Rainbow!");
		}		
		//House
		try {
			BufferedWriter fileHouse = new BufferedWriter (new FileWriter("house.txt"));
			for (int i = 0; i < house.size(); i++)
				fileHouse.write(house.get(i) + "\r\n");
			fileHouse.close();
		} catch (IOException e) {
			System.out.println("Error beim Speichern von House!");
		}
	}
	
	public void load() {
		//House
		try {
			BufferedReader fileHouse = new BufferedReader (new FileReader("house.txt"));
			boolean end = false;
			while (!end){
				String text = fileHouse.readLine();
				if (text == null)
					end = true;
				else house.add(text);
			}
			fileHouse.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von House!");
		}
		//Rainbow
		try {
			BufferedReader fileRainbow = new BufferedReader (new FileReader("rainbow.txt"));
			boolean end = false;
			while (!end){
				String text = fileRainbow.readLine();
				if (text == null)
					end = true;
				else rainbow.add(text);
			}
			fileRainbow.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von Rainbow!");
		}
		//Forest
		try {
			BufferedReader fileForest = new BufferedReader (new FileReader("forest.txt"));
			boolean end = false;
			while (!end){
				String text = fileForest.readLine();
				if (text == null)
					end = true;
				else forest.add(text);
			}
			fileForest.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von Forest!");
		}
		//Llama
		try {
			BufferedReader fileLlama = new BufferedReader (new FileReader("llama.txt"));
			boolean end = false;
			while (!end){
				String text = fileLlama.readLine();
				if (text == null)
					end = true;
				else llama.add(text);
			}
			fileLlama.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von Llama!");
		}
		//Mine
		try {
			BufferedReader fileMine = new BufferedReader (new FileReader("mine.txt"));
			boolean end = false;
			while (!end){
				String text = fileMine.readLine();
				if (text == null)
					end = true;
				else mine.add(text);
			}
			fileMine.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von Mine!");
		}
		//Dungeon
		try {
			BufferedReader fileDungeon = new BufferedReader (new FileReader("dungeon.txt"));
			boolean end = false;
			while (!end){
				String text = fileDungeon.readLine();
				if (text == null)
					end = true;
				else dungeon.add(text);
			}
			fileDungeon.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von Dungeon!");
		}
		//Farm
		try {
			BufferedReader fileFarm = new BufferedReader (new FileReader("farm.txt"));
			boolean end = false;
			while (!end){
				String text = fileFarm.readLine();
				if (text == null)
					end = true;
				else farm.add(text);
			}
			fileFarm.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von Farm!");
		}
		//Classic
		try {
			BufferedReader fileClassic = new BufferedReader (new FileReader("classic.txt"));
			boolean end = false;
			while (!end){
				String text = fileClassic.readLine();
				if (text == null)
					end = true;
				else classic.add(text);
			}
			fileClassic.close();
		} catch (IOException e) {
			System.out.println("Error beim Laden von Classic!");
		}
	}
}
