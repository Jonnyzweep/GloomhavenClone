package main.item;

public class Item {

	private String name;
	private Material material;
	
	public Item(String name, Material material) {
		this.name = name;
		this.material = material;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Material getMaterial() {
		return this.material;
	}
	
}
