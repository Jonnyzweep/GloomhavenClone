package main.environment;

import java.io.PrintStream;

public class WorldManager {
	
	private World world;
	
	public WorldManager(PrintStream stream) {
		world = new World("main", stream);
	}
	
	public World getWorld() {
		return this.world;
	}

}
