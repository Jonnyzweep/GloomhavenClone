package main.environment;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.simulation.SimController;
import main.GloomhavenClone;
import main.entity.Enemy;
import main.entity.Entity;
import main.entity.Player;
import structure.Shop;
import structure.Structure;

public class World {

	private String name;

	private PrintStream stream;

	private boolean showCoordinates = false;

	private int height, width;

	private List<Entity> entities;
	private List<Structure> structures;

	public World(String name, PrintStream stream, int height, int width) {
		this.name = name;
		this.stream = stream;
		this.height = height;
		this.width = width;
		this.entities = new ArrayList<>();
		this.structures = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void registerEntity(Entity entity) {
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

	public void printWorld(GloomhavenClone gh, Player player) {
		boolean onInteractable = false;
		for(int h = height; h >= -height; h--) {
			String line = "";

			for(int w = -width; w <= width; w++) {
				String symbol;
				if(showCoordinates)
					symbol = " (" + w + "," + h + ")";
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

					if(entity.getLocation().equals(player.getLocation())) {
						if(entity instanceof Enemy)
						{
							/*SimController.runChoice(1);
								int temp = SimController.run();*/
							//tried to add my battle map, put was looping
								Enemy enemy = (Enemy) entity;

								if(enemy.isAlive())
								{
									enemy.battle(gh, stream, gh.getScanner(), player);
								}


						}

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
