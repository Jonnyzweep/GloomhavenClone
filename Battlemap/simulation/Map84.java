package com.mycompany.gloomhaven.Battlemap.simulation;

import com.mycompany.gloomhaven.Battlemap.elements.MapUnits;
import com.mycompany.gloomhaven.Battlemap.elements.World;


import java.util.ArrayList;
public class Map84 {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE = "\u001B[35m";



	private int sizeX = 10;
	private int sizeY = 7;
	private int numUnits = 29;
	ArrayList<MapUnits> allUnits;
	World world;

	public Map84()
	{
		allUnits = new ArrayList<MapUnits>(numUnits);

		world = new World(sizeX, sizeY, 0, 0);
		populateMap(); // creates map
	}

	public void populateMap() {
		allUnits.add(new MapUnits(0, 1, 5, 0));
		allUnits.add(new MapUnits(0, 2, 5, 0));
		allUnits.add(new MapUnits(5, 5, 5, 0));
		allUnits.add(new MapUnits(5, 6,5 , 0));

		allUnits.add(new MapUnits(1, 0,8,0));
		allUnits.add(new MapUnits(8, 0,8,1));
		allUnits.add(new MapUnits(1, 1,8,1));
		allUnits.add(new MapUnits(6, 1,8,1));
		allUnits.add(new MapUnits(7, 1,8,2));
		allUnits.add(new MapUnits(1, 4,8,1));
		allUnits.add(new MapUnits(8, 4,8,0));
		allUnits.add(new MapUnits(9, 4,8,1));
		allUnits.add(new MapUnits(0, 5,8,2));
		allUnits.add(new MapUnits(8, 5,8,1));
		allUnits.add(new MapUnits(1, 6,8,1));
		allUnits.add(new MapUnits(8, 6,8,2));

		allUnits.add(new MapUnits(9, 0,7,0));

		allUnits.add(new MapUnits(3, 0,6,0));
		allUnits.add(new MapUnits(8, 2,6,0));
		allUnits.add(new MapUnits(5, 1,6,1));
		allUnits.add(new MapUnits(6, 2,6,1));
		allUnits.add(new MapUnits(5, 3,6,1));
		allUnits.add(new MapUnits(2, 4,6,1));
		allUnits.add(new MapUnits(1, 5,6,1));
		allUnits.add(new MapUnits(2, 5,6,1));
		allUnits.add(new MapUnits(7, 5,6,0));

		allUnits.add(new MapUnits(9, 1,20,0)); // 20 is to remove tiles from the board, quick fix
		allUnits.add(new MapUnits(9, 3,20,0));
		allUnits.add(new MapUnits(9, 5,20,0));

		for (int i = 0; i < numUnits; i++)
		{
			world.placeUnitOnMap(allUnits.get(i).getX(), allUnits.get(i).getY(), allUnits.get(i).getType(), allUnits.get(i).getName());
		}

	}

	public void legend() // simple way to print legend of map, have to update per map files
	{
		System.out.println("Legend:");
		System.out.println(ANSI_PURPLE + "Difficult terrain:" + ANSI_RESET + " L = Log ");
		System.out.println(ANSI_GREEN + "Obstacles:" + ANSI_RESET + " B = Brush, T = Tree ");
		System.out.println(ANSI_YELLOW + "Treasure:" + ANSI_RESET + " C = Chest ");
		System.out.println(ANSI_BLACK + "Enemies:" + ANSI_RESET + " H = Harrower Infester, F = Forest Imp, E = Earth Demon ");
		System.out.println(ANSI_RED + "Players:" + ANSI_RESET + " When added ");



	}





	public void run() 
	{
		world.printBattle();
		
	}

	public int getNumUnits()
	{
		return numUnits;
	}





	public World getWorld() {
		return world;
	}



}