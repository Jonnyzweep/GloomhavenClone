package main.entity;

import java.util.Collection;
import java.util.HashMap;

import main.item.Item;
import main.item.Material;

public class Inventory {
	
	private HashMap<Integer, Item> contents;
	private int MAX_SIZE = 9;
	
	public Inventory() {
		this.contents = new HashMap<>();
	}
	
	public void addItem(Item item) {
		contents.put(getFirstSlot(), item);
	}
	
	public void removeItem(int slot) {
		
	}
	
	/**
	 * Get next empty slot in inventory
	 * @return Return next available slot or -1 if none available
	 */
	public int getFirstSlot() {
		for(int i = 0; i < MAX_SIZE; i++) {
			if(!contents.containsKey(i))
				return i;
			else if(contents.get(i).getMaterial() == Material.AIR)
				return i;
		}
		return -1;
	}
	
	public Collection<Item> getContents(){
		return contents.values();
	}

}
