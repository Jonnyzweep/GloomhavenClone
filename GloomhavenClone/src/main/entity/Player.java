package main.entity;

import main.environment.Location;

public class Player extends Entity {
	
	private Inventory inventory;
	private double balance;
	
	private double STARTER_BALANCE = 100;
	
	public Player(Character character, Location location, double maxHealth) {
		super("@", location);
		this.inventory = new Inventory();
		this.balance = STARTER_BALANCE;
		setHealth(maxHealth);
		setMaxHealth(maxHealth);
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public boolean canAfford(double amount) {
		return !((balance - amount) < 0);
	}
	
	public void addBalance(double amount) {
		this.balance += amount;
	}
	
	public void removeBalance(double amount) {
		this.balance -= amount;
	}
	
	public double getBalance() {
		return this.balance;
	}

}
