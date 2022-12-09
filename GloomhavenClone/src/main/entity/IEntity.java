package main.entity;

import main.environment.Location;

/*
 * Interface class for Entity object
 */
public interface IEntity {
	
	public String getSymbol();
	public void setSymbol(String symbol);
	
	public double getHealth();
	public void setHealth(double health);
	
	public double getMaxHealth();
	public void setMaxHealth(double health);
	
	public void damage(double damage);
	public void attack(Entity entity, double damage);
	
	public Location getLocation();
	public void setLocation(Location location);
	public boolean moveTo(Location location);
	
	public boolean isAlive();
	public void respawn();

}
