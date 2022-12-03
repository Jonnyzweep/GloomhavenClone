package main.environment;

public class Location {
	
	private World world;
	private int x, z;
	
	public Location(World world, int x, int z) {
		this.world = world;
		this.x = x;
		this.z = z;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getX() {
		return x;
	}

	public Location setX(int x) {
		this.x = x;
		return this;
	}

	public int getZ() {
		return z;
	}

	public Location setZ(int z) {
		this.z = z;
		return this;
	}
	
	public Location clone() {
		return new Location(world, x, z);
	}

}
