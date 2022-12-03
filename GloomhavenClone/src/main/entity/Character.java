package main.entity;

public class Character {
	
	private String name;
	private double maxHealth;
	
	public Character(String name, double maxHealth) {
		this.name = name;
		this.maxHealth = maxHealth;
	}
	
	/*
	 * Get name of character
	 */
	public String getName() {
		return this.name;
	}
	
	public double getMaxHealth() {
		return this.maxHealth;
	}

}
