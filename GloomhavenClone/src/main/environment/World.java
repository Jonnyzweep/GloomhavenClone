package main.environment;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import main.GloomhavenClone;
import main.entity.Entity;
import structure.Shop;
import structure.Structure;

public class World {

	private String name;

	private PrintStream stream;

	private boolean showCoordinates = false;

	private int height, width;

	private List<Entity> entities;
	private List<Structure> structures;

	public World(String name, PrintStream stream) {
		this.name = name;
		this.stream = stream;
		height = 5;
		width = 10;
		this.entities = new ArrayList<>();
		this.structures = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}

	public List<Entity> getEntities() {
		return this.entities;
	}

	public void addShop(Shop shop) {
		this.structures.add(shop);
	}

	public List<Structure> getStructures(){
		return this.structures;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Structure getStructureFromLocation(int x, int z) {
		for(Structure structure : structures) {
			Location loc = structure.getLocation();
			int xx = loc.getX(), zz = loc.getZ();
			if(xx == x && zz == z)
				return structure;
		}
		return null;
	}

	public void printWorld(GloomhavenClone gh) {
		boolean onInteractable = false;
		for(int h = 0; h < height; h++) {

			String line = "";

			for(int w = 0; w < width; w++) {
				String symbol;
				if(showCoordinates)
					symbol = w + "," + h;
				else
					symbol = "#";

				for(Structure structure : structures){
					if(structure instanceof Shop) {
						if(structure.getLocation().getX() == h && structure.getLocation().getZ() == w) {
							symbol = structure.getSymbol();
						}
					}
				}

				for(Entity entity : entities){
					Location loc = entity.getLocation();
					int xx = loc.getX(), zz = loc.getZ();
					if(xx == h && zz == w) {
						Structure structure = getStructureFromLocation(h, w);
						if(structure != null)
							onInteractable = true;
						symbol = entity.getSymbol();	
					}
				}

				line = line + symbol + " ";
			}

			gh.print(stream, line);
		}
		if(onInteractable)
			gh.print(stream, "Press 'I' to interact!");
	}

}
