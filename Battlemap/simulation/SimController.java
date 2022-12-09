package com.mycompany.gloomhaven.Battlemap.simulation;


import com.mycompany.gloomhaven.Battlemap.Maps.Map;
import com.mycompany.gloomhaven.Battlemap.Maps.Map1;
import com.mycompany.gloomhaven.Battlemap.Maps.Map84;

import java.util.Scanner;


public class SimController {


	private static Map sim;

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);

		System.out.println("Maps currently made are: 1, 84.");
		System.out.print("Enter Map number to load:  ");
		int map = sc.nextInt();


		if(map == 1)
		{
			sim = new Map1();
		}
		else if(map == 84)
		{
			sim = new Map84();
		}


		run();

	}

	public static void run()
	{
		int players = 0;
		Scanner sc = new Scanner(System.in);
		int whileV = 0;
		int choice = 0;
		int oldX, newX, oldY, newY = 0;
		sim.printMap();
		System.out.println("");

		while(whileV == 0)
		{
			if(choice == 0)
			{
				System.out.println("Command Table:");
				System.out.println("Move a unit:        1");
				System.out.println("Move all units:     2");
				System.out.println("Add unit:           3");
				System.out.println("Remove unit:        4");
				System.out.println("Map Legend:         5");
				System.out.println("Battle sim:         6");
				System.out.println("Exit Battle:        7");
				System.out.print("Enter Command:      ");
				choice = sc.nextInt();
			}
			else if (choice == 1)
			{
				moveChoice();
				sim.printMap();
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 2)
			{
				moveAll();
				sim.printMap();
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 3)
			{
				System.out.print("Enter 1 to add player: Enter anything else to add enemy: ");
				int c = sc.nextInt();
				if(c == 1)
				{
					players = addPlayer(players);
				}
				else
				{
					addEnemy();
				}
				sim.printMap();
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 4)
			{
				removeUnit();
				sim.printMap();
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 5)
			{
				sim.legend();

				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 6)
			{
				//run battle sim
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();


			}
			else if (choice == 7)
			{
				whileV = 1;
				sc.close();
				break;
			}
			else
			{
				System.out.println("Error: Not a valid command enter, returning to commands");
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();
			}
		}
		System.out.println("Exiting battlemap");
	}

	public static void move(int x, int y)
	{
		int whileV = 0;
		while(whileV == 0)
		{

			Scanner sc = new Scanner(System.in);
			System.out.print("Enter new x coordinate: ");
			int newX = sc.nextInt();
			System.out.print("Enter new y coordinate: ");
			int newY = sc.nextInt();
			if(sim.hasUnit(newX -1, newY -1) == false)
			{
				sim.placeUnitOnMap(newX -1,newY -1,sim.getType(x -1,y -1), sim.getName(x -1,y -1));
				sim.removeUnitFromTile(x - 1,y - 1);
				whileV = 1;
			}
			else
			{
				System.out.print("Error: There is a unit on given tile; to skip this unit press 1:  to give new coordinates press any other number: ");
				int c = sc.nextInt();
				if(c == 1)
				{
					whileV =3;
				}
			}

		}

	}
	public static void moveChoice() // moving one unit at a time
	{
		int whileV = 0;
		while(whileV == 0)
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter current x coordinate: ");
			int oldX = sc.nextInt();
			System.out.print("Enter current y coordinate: ");
			int oldY = sc.nextInt();
			if(sim.hasUnit(oldX - 1, oldY -1) == true) // all the minus 1 are for because all arrays start at 0
			{
				move(oldX,oldY);
				whileV =3;
			}
			else
			{
				System.out.print("Error: No unit on given tile; to return to command table press 1:  to give new coordinates press any other number: ");
				int c = sc.nextInt();
				if(c == 1)
				{
					whileV =3;
				}
			}

		}

	}

	public static void moveAll()
	{
		int indexX[] = new int[sim.getNumUnits()];
		int indexY[] = new int[sim.getNumUnits()];
		int tracker  = 0;
		for(int y= 0; y < sim.world.getSizeY() ; y++)
		{
			for(int x = 0; x < sim.world.getSizeX(); x++)
			{
				if(sim.getType(x,y) == 8)
				{
					indexX[tracker] = (x+1); // adding one so its gives the x as a human would enter it (x starting at 1)
					indexY[tracker] = (y+1);
					tracker += 1;
				}
			}
		}
		for( int i =0; i < tracker; i++)
		{
			System.out.println("Moving unit at (" +indexX[i]+", " +indexY[i] +"): To skip this unit enter the same coordinates given and press 1");
			move(indexX[i], indexY[i]);
		}

	}

	public static int addPlayer(int players)
	{

		int whileV = 0;
		while(whileV == 0)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the coordinates where you want new player to be :");
			System.out.print("X = ");
			int newX = sc.nextInt();
			System.out.print("Y = ");
			int newY = sc.nextInt();
			if(sim.hasUnit(newX -1, newY -1) == false)
			{
				players +=1; // adding one so it will start the first player as 1 on the map
				sim.placeUnitOnMap(newX - 1, newY -1, 9, players);
				whileV = 4;

			}
			else
			{
				System.out.print("Error: There is a unit on given tile; to return to command table press 1:  to give new coordinates press any other number: ");
				int c = sc.nextInt();
				if (c == 1) {
					whileV = 3;
				}
			}
		}
		return players;
	}
	public static void addEnemy() {
		int whileV = 0;
		while (whileV == 0) {

			Scanner sc = new Scanner(System.in);
			System.out.print("Enter x coordinate for new enemy:");
			int newX = sc.nextInt();
			System.out.print("Enter y coordinate for new enemy: ");
			int newY = sc.nextInt();
			System.out.print("Enter number for enemy name: (refer to map cheatsheet for numbers) "); // need to add a better system later
			int newName = sc.nextInt();
			if (sim.hasUnit(newX - 1, newY - 1) == false) {
				sim.placeUnitOnMap(newX - 1, newY - 1, 8, newName);
				whileV = 3;
			} else {
				System.out.print("Error: There is a unit on given tile; to return to command table press 1:  to give new coordinates press any other number: ");
				int c = sc.nextInt();
				if (c == 1) {
					whileV = 3;

				}

			}
		}
	}

	public static void removeUnit()
	{
		int whileV = 0;
		while(whileV == 0)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the coordinates of the unit you want to remove:");
			System.out.print("X = ");
			int newX = sc.nextInt();
			System.out.print("Y = ");
			int newY = sc.nextInt();
			if(sim.hasUnit(newX -1, newY -1) == true)
			{
				 // adding one so it will start the first player as 1 on the map
				sim.removeUnitFromTile(newX - 1, newY -1);
				whileV = 4;

			}
			else
			{
				System.out.print("Error: No unit on given tile; to return to command table press 1:  to give new coordinates press any other number: ");
				int c = sc.nextInt();
				if (c == 1) {
					whileV = 3;
				}
			}
		}

	}







}
