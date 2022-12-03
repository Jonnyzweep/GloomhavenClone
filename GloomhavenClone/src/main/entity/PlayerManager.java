package main.entity;

import java.io.PrintStream;
import java.util.Scanner;

import main.GloomhavenClone;
import main.shop.Shop;

public class PlayerManager {
	
	private String forward = "w", backward = "s", left = "a", right = "d", interact = "i";
	
	private Player player;
	
	public PlayerManager(Player player) {
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
			Shop shop = null;
			for(Shop s : player.getLocation().getWorld().getShops()) {
				if(s.getLocation().getX() == player.getLocation().getX() && s.getLocation().getZ() == player.getLocation().getZ()) {
					shop = s;
					break;
				}
			}
			
			if(shop == null)
				return;
			
			shop.openShop(gh, stream, scanner, player);
		}
	}
}
