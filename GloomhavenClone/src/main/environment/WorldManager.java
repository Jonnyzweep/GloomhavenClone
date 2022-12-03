package main.environment;

import java.io.PrintStream;

public class WorldManager {
	
	private PrintStream stream;
	private World world;
	
	public WorldManager(PrintStream stream) {
		this.stream = stream;
		world = new World("main", stream);
	}
	
	public World getWorld() {
		return this.world;
	}

}
