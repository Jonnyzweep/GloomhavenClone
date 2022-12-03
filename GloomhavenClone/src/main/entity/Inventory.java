package main.entity;

import java.util.Collection;
import java.util.HashMap;

import main.item.Item;

public class Inventory {
	
	private HashMap<Integer, Item> contents;
	
	public Inventory() {
		this.contents = new HashMap<>();
	}
	
	public void addItem(Item item) {
		
	}
	
	public void removeItem(int slot) {
		
	}
	
	public Collection<Item> getContents(){
		return contents.values();
	}

}
