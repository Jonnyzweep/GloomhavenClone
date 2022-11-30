package main.entity;

/*
 * Base Entity object class
 */
public class Entity implements IEntity {
	
	private double health;

	@Override
	public double getHealth() {
		return this.health;
	}

	@Override
	public void setHealth(double health) {
		this.health = health;
	}

}
