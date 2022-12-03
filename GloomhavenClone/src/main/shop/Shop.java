package main.shop;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.GloomhavenClone;
import main.entity.Player;
import main.environment.Location;
import main.utils.MathUtils;

public class Shop {

	private List<ShopItem> shopItems;
	private Location location;

	public Shop(Location location) {
		this.shopItems = new ArrayList<>();
		this.location = location;
	}

	public void addShopItem(ShopItem shopItem) {
		shopItems.add(shopItem);
	}

	public Location getLocation() {
		return this.location;
	}

	public void openShop(GloomhavenClone gh, PrintStream stream, Scanner scanner, Player player) {
		while(true) {
			gh.print(stream, "Type 'i' to exit shop.");
			int index = 0;
			for(ShopItem shopItem : shopItems) {
				gh.print(stream, index + " - " + shopItem.getItem().getName() + " $" + shopItem.getPrice());
				index++;
			}

			String input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("i"))
				break;

			if(!MathUtils.isInt(input)) {
				gh.print(stream, "Invalid input!");
				continue;
			}

			int selection = Integer.parseInt(input);

			if(selection > index || selection < 0) {
				gh.print(stream, "Invalid input!");
				continue;
			}
			
			ShopItem item = shopItems.get(selection);

			if(player.canAfford(item.getPrice())){
				player.removeBalance(item.getPrice());
				player.getInventory().addItem(item.getItem());
				gh.print(stream, "You bought " + item.getItem().getName() + " for " + item.getPrice() + "! Your new balance $" + player.getBalance());
			
			}

		}

	}

}
