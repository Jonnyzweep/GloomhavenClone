package main.shop;

import main.item.Item;

public class ShopItem {
	
	private Item item;
	private double price;
	
	public ShopItem(Item item, double price) {
		this.item = item;
		this.price = price;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public double getPrice() {
		return this.price;
	}

}
