package main;

import java.io.PrintStream;
import java.util.Scanner;

import main.entity.Character;
import main.entity.CharacterManager;
import main.entity.Enemy;
import main.entity.Player;
import main.entity.PlayerController;
import main.environment.Location;
import main.environment.WorldManager;
import main.item.Item;
import main.item.Material;
import structure.Shop;
import structure.ShopItem;

public class GloomhavenClone {

	/** Game run boolean */
	private boolean running = false;
	private Scanner scanner;

	/**
	 * Program starts here when program is ran.
	 * @param args Program starting arguments
	 */
	public static void main(String args[]) {
		//Instance of GloomhavenClone class
		GloomhavenClone instance = new GloomhavenClone();
		
		//Call run method to begin game loop
		instance.run(instance);
	}

	/**
	 * Method ran when game starts. Contains main game loop.
	 */
	public void run(GloomhavenClone gloomhavenClone) {

		//Set running to true once run method is called
		this.running = true;
		//Scanner variable to handle user input
		scanner = new Scanner(System.in);
		PrintStream stream = System.out;

		WorldManager worldManager = new WorldManager(stream);
		CharacterManager characterManager = new CharacterManager();

		//Checks if user has selected a character previously
		if(!characterManager.hasSelectedCharacter())
			characterManager.characterSelectionMenu(gloomhavenClone, stream, scanner);
		
		Character character = characterManager.getCharacter();

		Player player = new Player(characterManager.getCharacter(), new Location(worldManager.getWorld(), 0, 0), character.getMaxHealth());
		worldManager.getWorld().registerEntity(player);

		PlayerController playerController = new PlayerController(player);
		
		Enemy enemy = new Enemy("E", new Location(worldManager.getWorld(), -3, -3));
		worldManager.getWorld().registerEntity(enemy);

		this.setupShops(worldManager);

		//Game loop will keep looping until running is false
		while(running) {
			Location location = player.getLocation();
			print(stream, "");
			print(stream, "Health: " + player.getHealth() + "/" + player.getMaxHealth() + " [Location | World: " + location.getWorld().getName() + ", X:" + location.getX() + ", Z:" + location.getZ() + "]");
			print(stream, "Press 'E' to view your inventory");
			worldManager.getWorld().printWorld(gloomhavenClone, player);

			playerController.handleInput(gloomhavenClone, stream, scanner);

			print(stream, player.getLocation().getX() + " " + player.getLocation().getZ());

		}

		//Once game is not longer running close our scanner
		scanner.close();
	}
	
	public Scanner getScanner() {
		return this.scanner;
	}

	public void setupShops(WorldManager worldManager) {
		Shop weaponShop = new Shop(new Location(worldManager.getWorld(), 2, 5));
		weaponShop.addShopItem(new ShopItem(new Item("Sword", Material.SWORD), 10));
		worldManager.getWorld().addShop(weaponShop);
	}

	public void print(PrintStream stream, String line) {
		stream.println(line);
	}

}