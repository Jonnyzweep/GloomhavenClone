package main.entity;

import main.environment.Location;
import main.environment.World;

/*
 * Base Entity object class
 */
public class Entity implements IEntity {
	
	private String symbol;
	private double health;
	private Location location;
	
	public Entity(String symbol, Location location) {
		this.symbol = symbol;
		this.health = 20;
		this.location = location;
	}
	
	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public double getHealth() {
		return this.health;
	}

	@Override
	public void setHealth(double health) {
		this.health = health;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public boolean moveTo(Location location) {
		World world = location.getWorld();
		int xBound = world.getHeight(), zBound = world.getWidth();
		if(location.getX() > xBound - 1 || location.getX() < 0 || location.getZ() > zBound - 1 || location.getZ() < 0)
			return false;
		else {
			this.location = location;
			return true;
		}
	}
	
	

}
