package com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.Maps;

import com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.elements.MapUnits;
import com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.elements.BattleWorld;

import java.util.ArrayList;
// The info on what tiles the boss can spawn wasnt added yet.
public class Map48 extends Map
{
	private int sizeX= 10;
	private int sizeY = 7;
	private int numUnits;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String BLACK_BACKGROUND = "\033[40m";  // Walls




	ArrayList<MapUnits> allUnits;
	public BattleWorld battleWorld;

	public Map48()
	{

		allUnits = new ArrayList<MapUnits>(numUnits);

		battleWorld = new BattleWorld(sizeX, sizeY, 0, 0);
		populateMap(); // creates map
	}

	public void populateMap() {
		//starting
		allUnits.add(new MapUnits(3, 3, 0, 1));
		allUnits.add(new MapUnits(4, 2, 0, 1));
		allUnits.add(new MapUnits(4, 3, 0, 1));
		allUnits.add(new MapUnits(4, 4, 0, 1));
		allUnits.add(new MapUnits(5, 4, 0, 1));

		//Difficult terrain
		allUnits.add(new MapUnits(0, 1, 5, 0));
		allUnits.add(new MapUnits(0, 2, 5, 0));
		allUnits.add(new MapUnits(5, 5, 5, 0));
		allUnits.add(new MapUnits(5, 6,5 , 0));
		//Obstacles
		allUnits.add(new MapUnits(1, 5,6,1));
		allUnits.add(new MapUnits(2, 4,6,1));
		allUnits.add(new MapUnits(2, 5,6,1));
		allUnits.add(new MapUnits(3, 0,6,0));
		allUnits.add(new MapUnits(5, 2,6,1));
		allUnits.add(new MapUnits(5, 3,6,1));
		allUnits.add(new MapUnits(6, 2,6,1));
		allUnits.add(new MapUnits(7, 5,6,0));
		allUnits.add(new MapUnits(8, 1,6,0));
		//Treasure
		allUnits.add(new MapUnits(9, 0,7,0));
		//Enemies
		allUnits.add(new MapUnits(0, 5,8,2));
		allUnits.add(new MapUnits(1, 0,8,0));
		allUnits.add(new MapUnits(1, 1,8,1));
		allUnits.add(new MapUnits(1, 4,8,1));
		allUnits.add(new MapUnits(1, 6,8,1));
		allUnits.add(new MapUnits(6, 1,8,1));
		allUnits.add(new MapUnits(7, 1,8,2));
		allUnits.add(new MapUnits(8, 0,8,1));
		allUnits.add(new MapUnits(8, 4,8,0));
		allUnits.add(new MapUnits(8, 5,8,1));
		allUnits.add(new MapUnits(8, 6,8,2));
		allUnits.add(new MapUnits(9, 4,8,1));
		//deadspace
		allUnits.add(new MapUnits(9, 1,20,0)); // 20 is to remove tiles from the board, quick fix
		allUnits.add(new MapUnits(9, 3,20,0));
		allUnits.add(new MapUnits(9, 5,20,0));

		numUnits = allUnits.size();


		for (int i = 0; i < numUnits; i++)
		{
			this.battleWorld.placeUnitOnMap(allUnits.get(i).getX(), allUnits.get(i).getY(), allUnits.get(i).getType(), allUnits.get(i).getName());
		}

	}

	public void legend() // simple way to print legend of map, have to update per map files
	{
		System.out.println("Legend:");
		System.out.println(BLACK_BACKGROUND + "  " + ANSI_RESET + " = are deadspace");
		System.out.println("[] = Open Space: ! are the starting tiles and acts like normal tiles after adding your characters");
		System.out.println(ANSI_PURPLE + "() = Difficult terrain:" + ANSI_RESET + " L = Log ");
		System.out.println(ANSI_GREEN + "() = Obstacles:" + ANSI_RESET + " B = Brush, T = Tree ");
		System.out.println(ANSI_YELLOW + "() = Treasure:" + ANSI_RESET + " C = Chest ");
		System.out.println(ANSI_RED + "{} = Enemies:" + ANSI_RESET + " H = Harrower Infester, F = Forest Imp, E = Earth Demon, D = Dark Rider when summoned");
		System.out.println(ANSI_RED + "<> = Players:" + ANSI_RESET + " number is the order you enter them ");



	}
	public void printMap()
	{
		battleWorld.printBattle();

	}
	public int getType(int x, int y)
	{
		return battleWorld.getType(x,y);
	}
	public int getName(int x, int y)
	{
		return battleWorld.getName(x,y);
	}
	public void placeUnitOnMap(int x, int y, int type, int name)
	{
		battleWorld.placeUnitOnMap(x,y,type,name);

	}
	public void removeUnitFromTile(int x, int y)
	{
		battleWorld.removeUnitFromTile(x,y);
	}
	public boolean hasUnit(int x, int y)
	{
		return battleWorld.hasUnit(x,y);
	}



	public int getNumUnits()
	{
		return numUnits;
	}
	public int getNumberOfEnemies()
	{
		return MapUnits.getNames();
	}


}