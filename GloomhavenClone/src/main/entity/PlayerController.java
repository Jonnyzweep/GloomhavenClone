package main.entity;

import java.io.PrintStream;
import java.util.Scanner;

import main.GloomhavenClone;
import main.environment.Location;
import main.environment.World;
import main.item.Item;
import structure.Shop;
import structure.Structure;

public class PlayerController {

	private String forward = "w", backward = "s", left = "a", right = "d", interact = "i", inventory = "e";

	private Player player;

	public PlayerController(Player player) {
		this.player = player;
	}

	public void handleInput(GloomhavenClone gh, PrintStream stream, Scanner scanner){
		String input = scanner.nextLine();

		if(input.equalsIgnoreCase(forward)) {
			player.moveTo(player.getLocation().clone().setX(player.getLocation().getX() - 1));
		}else if(input.equalsIgnoreCase(backward)){
			player.moveTo(player.getLocation().clone().setX(player.getLocation().getX() + 1));
		}else if(input.equalsIgnoreCase(left)){
			player.moveTo(player.getLocation().clone().setZ(player.getLocation().getZ() - 1));
		}else if(input.equalsIgnoreCase(right)){
			player.moveTo(player.getLocation().clone().setZ(player.getLocation().getZ() + 1));
		}else if(input.equalsIgnoreCase(interact)){
			World world = player.getLocation().getWorld();
			Location loc = player.getLocation();
			Shop shop = null;
			for(Structure structure : world.getStructures()) {
				if(structure instanceof Shop) {
					Shop cShop = (Shop) structure;
					Location cLoc = cShop.getLocation();
					if(cLoc.getX() == loc.getX() && cLoc.getZ() == loc.getZ()) {
						shop = cShop;
						break;
					}
				}
			}

			if(shop == null)
				return;

			shop.openShop(gh, stream, scanner, player);
		}else if(input.equalsIgnoreCase(inventory)) {
			gh.print(stream, "------------------------------------");
			gh.print(stream, "Inventory Contents:");
			int slot = 0;
			for(Item item : player.getInventory().getContents()) {
				gh.print(stream, " Slot: " + slot + " Item: " + item.getName());
				slot++;
			}
			gh.print(stream, "------------------------------------");
		}
	}
}
