package main.entity;

import java.io.PrintStream;
import java.util.Scanner;

import main.GloomhavenClone;
import main.environment.Location;

public class Enemy extends Entity{

	public Enemy(String symbol, Location location) {
		super(symbol, location);
		// TODO Auto-generated constructor stub
	}
	
	public void battle(GloomhavenClone gh, PrintStream stream, Scanner scanner, Player player) {
		this.setHealth(getMaxHealth());
		
		gh.print(stream, "You ran into a battle!");
		boolean player_turn = false;
		while(isAlive() && player.isAlive()) {
			
			if(player_turn) {
				String attack = scanner.nextLine();
				double dmg = 5;
				if(attack.equals("0"))
					dmg = 5;
				else if(attack.equals("1"))
					dmg = 1;
				else
					dmg = 0;
				player.attack(this, dmg);
				gh.print(stream, "You damaged " + dmg + "hp! Enemy Health: " + this.getHealth());
			}else {
				double dmg = 2.5;
				player.damage(dmg);
				gh.print(stream, "You took " + dmg + " damage! Health: " + player.getHealth());
			}
			
			player_turn = !player_turn;
			
		}
		
		if(!isAlive()) {
			gh.print(stream, "You have defeated the enemy!");
		}else if(!player.isAlive()) {
			player.respawn();
			gh.print(stream, "You have been defeated! You have respawned at the spawn point.");
		}else {
			
		}
		
	}
	
	@Override
	public String getSymbol() {
		if(isAlive())
			return symbol;
		else
			return "X";
	}

}
