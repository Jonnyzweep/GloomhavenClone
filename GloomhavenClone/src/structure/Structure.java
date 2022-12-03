package structure;

import main.environment.Location;

public class Structure {
	
	private Location location;
	private String name, symbol;
	private boolean canInteract;
	
	public Structure(Location location, String name, String symbol, boolean canInteract) {
		this.location = location;
		this.name = name;
		this.symbol = symbol;
		this.canInteract = canInteract;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbol() {
		return this.symbol;
	}

	public boolean isInteractable() {
		return this.canInteract;
	}
	
}
