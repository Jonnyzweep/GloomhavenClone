package main.entity;

import main.environment.Location;
import main.environment.World;
import main.utils.MathUtils;

/*
 * Base Entity object class
 */
public class Entity implements IEntity {
	
	protected String symbol;
	private double health, maxHealth;
	private Location location;
	
	public Entity(String symbol, Location location) {
		this.symbol = symbol;
		this.health = 20;
		this.maxHealth = 20;
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
	public double getMaxHealth() {
		return this.maxHealth;
	}

	@Override
	public void setMaxHealth(double health) {
		this.maxHealth = health;
	}
	
	@Override
	public void damage(double damage) {
		double health = getHealth() - damage;
		health = MathUtils.cap(health, 0, getMaxHealth());
		setHealth(health);
	}

	@Override
	public void attack(Entity entity, double damage) {
		entity.damage(damage);
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
		if(location.getX() > xBound || location.getX() < -xBound || location.getZ() > zBound || location.getZ() < -zBound)
			return false;
		else {
			this.location = location;
			return true;
		}
	}

	@Override
	public boolean isAlive() {
		return health > 0;
	}

	@Override
	public void respawn() {
		this.health = this.maxHealth;
		
		setLocation(new Location(location.getWorld(), 0, 0));
	}
	
	

}
