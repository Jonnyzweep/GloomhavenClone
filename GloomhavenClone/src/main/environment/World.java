package main.environment;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import main.GloomhavenClone;
import main.entity.Entity;
import main.entity.Player;
import main.shop.Shop;

public class World {

	private String name;

	private PrintStream stream;

	private boolean showCoordinates = false;

	private int height, width;

	private List<Entity> entities;
	private List<Shop> shops;

	public World(String name, PrintStream stream) {
		this.name = name;
		this.stream = stream;
		height = 5;
		width = 10;
		this.entities = new ArrayList<>();
		this.shops = new ArrayList<>();
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
		this.shops.add(shop);
	}
	
	public List<Shop> getShops(){
		return this.shops;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
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
				
				for(Shop shop : shops){

					if(shop.getLocation().getX() == h && shop.getLocation().getZ() == w) {
						symbol = "$";
					}
				}


				for(Entity entity : entities){

					if(entity.getLocation().getX() == h && entity.getLocation().getZ() == w) {
						if(symbol.equals("$"))
							onInteractable = true;
						symbol = entity.getSymbol();
					}
				}

				line = line + symbol + " ";
			}
			
			gh.print(stream, line);
		}
		if(onInteractable)
			gh.print(stream, "Press 'I' to open the shop!");
	}

}
