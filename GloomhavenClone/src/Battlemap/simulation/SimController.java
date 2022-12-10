package com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.simulation;


import com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.Maps.Map;
import com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.Maps.Map1;
import com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.Maps.Map48;

import java.util.InputMismatchException;
import java.util.Scanner;
//Created by Jonny
//Could add on option to print map scenario infomation and rules for the specific map, but not important now
//Need to figure out how to work enemy levels

public class SimController {


	private static Map sim;

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);


		int map= 0;
		int trying = 0;
		while(trying == 0)
		{
			System.out.println("Maps currently made are: 1, 48.");
			try
			{

				System.out.print("Enter Map number to load:  ");
				map = sc.nextInt();

			}
			catch (InputMismatchException e)
			{
				System.err.println("Wrong input! Input only integer numbers please...");
				sc.nextLine();
			}
			if(map == 1 || map == 48)
			{
				break;
			}
			else
			{
				System.out.println("Invalid map number.");

			}

		}

		if(map == 1)
		{
			sim = new Map1();
		}
		else if(map == 48)
		{
			sim = new Map48();
		}

		System.out.println("Loaded Map " + map + ":");

		run();

	}
	public static void runChoice(int map)// trying to implement it to main driver
	{
		if(map == 1)
		{
			sim = new Map1();
		}
		System.out.println("Loaded Map " + map + ":");

	}



	public static int run()
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



				int trying = 0;
				while(trying == 0)
				{
					System.out.print("Enter Command: ");
					try
					{
						choice = sc.nextInt();
						break;
					}
					catch (InputMismatchException e) // catching non ints
					{
						System.err.println("Wrong input! Input only integer numbers please...");
						System.out.println();
						sc.nextLine();
					}

				}

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
				int c = 0;


				int trying = 0;
				while(trying == 0) {
					try {
						System.out.print("Enter 1 to add player: Enter anything else to add enemy: ");
						c = sc.nextInt();
						break;
					} catch (InputMismatchException e) // catching non ints
					{
						System.err.println("Wrong input! Input only integer numbers please...");
						System.out.println();
						sc.nextLine();
					}
				}
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
				return 0;
				//run battle sim
		/*		System.out.println("Not made yet");
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();*/


			}
			else if (choice == 7)
			{
				/*break;*/
				return 1;
			}
			else
			{
				System.out.println("Error: Not a valid command enter, returning to commands");
				choice = 0;
			}
		}
		System.out.println("Exiting battlemaps");
		return players;
	}

	public static void move(int x, int y)
	{
		int whileV = 0;
		while(whileV == 0)
		{

			Scanner sc = new Scanner(System.in);
			int newY= -1;
			int newX = -1;
			int error = 0;

			int trying = 0;
			while(trying == 0)
			{
				try
				{
					System.out.print("Enter new x coordinate: ");
					newX = sc.nextInt();
					System.out.print("Enter new y coordinate: ");
					newY = sc.nextInt();
					break;
				}
				catch (InputMismatchException e) // catching non ints
				{
					System.err.println("Wrong input! Input only integer numbers please...");
					System.out.println();
					sc.nextLine();
				}

			}
			if(((newX - 1) >=0 ) && ((newY - 1) >=0 ))
			{
				if(sim.hasUnit(newX -1, newY -1) == false)
				{
					sim.placeUnitOnMap(newX -1,newY -1,sim.getType(x -1,y -1), sim.getName(x -1,y -1));
					sim.removeUnitFromTile(x - 1,y - 1);
					whileV = 1;
				}
				else
				{
					System.out.println("Error: There is a unit on given tile");
					error = 1;


				}

			}
			else
			{
				System.out.println("Error: negative coordinate, only positive");
				error = 1;
			}
			if(error == 1)
			{
				int c = 0;
				while (trying == 0)
				{

					try {
						System.out.print("to return to command table press 1:  to give new coordinates press any other number:  ");
						c = sc.nextInt();
						break;
					} catch (InputMismatchException e) // catching non ints
					{
						System.err.println("Wrong input! Input only integer numbers please...");
						System.out.println();
						sc.nextLine();
					}
				}
				if (c == 1)
				{
					whileV = 3;
				}
			}



		}

	}
	public static void moveChoice() // moving one unit at a time
	{
		int whileV = 0;
		while (whileV == 0) {
			Scanner sc = new Scanner(System.in);
			int oldX = -1;
			int oldY = -1;
			int error =0;
			int trying = 0;
			while (trying == 0)
			{
				try {
					System.out.print("Enter new x coordinate: ");
					oldX = sc.nextInt();
					System.out.print("Enter new y coordinate: ");
					oldY = sc.nextInt();
					break;
				} catch (InputMismatchException e) // catching non ints
				{
					System.err.println("Wrong input! Input only integer numbers please...");
					System.out.println();
					sc.nextLine();
				}
			}
			if(((oldX - 1) >=0) &&((oldY - 1) >=0))
			{
				if (sim.hasUnit(oldX - 1, oldY - 1) == true && (sim.getType(oldX-1,oldY-1) != 20)) // all the minus 1 are for because all arrays start at 0
				{
					move(oldX, oldY);
					whileV = 3;
				}
				else
				{
					error = 1;
					System.out.println("Error: No unit on given tile ");

				}
			}
			else
			{
				System.out.println("Error: negative coordinate, only positive; ");
				error = 1;

			}
			if(error == 1)
			{
				int c = 0;
				while (trying == 0)
				{

					try {
						System.out.print("to return to command table press 1:  to give new coordinates press any other number:  ");
						c = sc.nextInt();
						break;
					} catch (InputMismatchException e) // catching non ints
					{
						System.err.println("Wrong input! Input only integer numbers please...");
						System.out.println();
						sc.nextLine();
					}
				}
				if (c == 1)
				{
					whileV = 3;
				}
			}



		}

	}


	public static void moveAll()
	{
		Scanner sc = new Scanner(System.in);
		int indexX[] = new int[sim.getNumUnits()];
		int indexY[] = new int[sim.getNumUnits()];
		int tracker  = 0;
		for(int y= 0; y < sim.getSizeY() ; y++)
		{
			for(int x = 0; x < sim.getSizeX(); x++)
			{
				if(sim.getType(x,y) == 8)
				{
					indexX[tracker] = (x+1); // adding one so its gives the x as a human would enter it (x starting at 1)
					indexY[tracker] = (y+1);
					tracker += 1;
				}
				else if(sim.getType(x,y) == 9)
				{
					indexX[tracker] = (x+1); // adding one so its gives the x as a human would enter it (x starting at 1)
					indexY[tracker] = (y+1);
					tracker += 1;
				}
			}
		}
		for( int i =0; i < tracker; i++)
		{
			int trying = 0;
			int c = 1;
			while (trying == 0)
			{
				try
				{
					System.out.println("Moving unit at (" +indexX[i]+", " +indexY[i] +"): To skip this unit enter the same coordinates press 1");
					c = sc.nextInt();
					break;
				}
				catch (InputMismatchException e) // catching non ints
				{
					System.err.println("Wrong input! Input only integer numbers please...");
					System.out.println();
					sc.nextLine();
				}
			}
			if (c != 1)
			{
				move(indexX[i], indexY[i]);

			}

		}

	}

	public static int addPlayer(int players)
	{

		int whileV = 0;
		while(whileV == 0)
		{
			Scanner sc = new Scanner(System.in);
			int error =0;
			int newX= -1;
			int newY = -1;
			int trying = 0;
			while (trying == 0)
			{
				try {
					System.out.println("Enter the coordinates where you want new player to be :");
					System.out.print("X = ");
					newX = sc.nextInt();
					System.out.print("Y = ");
					newY = sc.nextInt();
					break;
				} catch (InputMismatchException e) // catching non ints
				{
					System.err.println("Wrong input! Input only integer numbers please...");
					System.out.println();
					sc.nextLine();
				}
			}

			if(sim.getType(newX -1, newY -1) == 0)
			{
				if(sim.getName(newX-1,newY-1) == 1)
				{
					players +=1; // adding one so it will start the first player as 1 on the map
					sim.placeUnitOnMap(newX - 1, newY -1, 9, players);
					whileV = 4;
				}
				else
				{
					System.out.print("Error: Not a Starting tile, [!];  ");
					error = 1;

				}

			}
			else
			{
				System.out.print("Error: Not a Starting tile; ");
				error = 1;

			}
			if(error == 1)
			{
				int c = 0;
				while (trying == 0)
				{

					try {
						System.out.print("to return to command table press 1:  to give new coordinates press any other number:  ");
						c = sc.nextInt();
						break;
					} catch (InputMismatchException e) // catching non ints
					{
						System.err.println("Wrong input! Input only integer numbers please...");
						System.out.println();
						sc.nextLine();
					}
				}
				if (c == 1)
				{
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
			int newX = -1;
			int newY = -1;
			int newName = -1;
			int error = 0;
			int trying = 0;
			while (trying == 0)
			{
				try {

					System.out.print("Enter x coordinate for new enemy:");
					newX = sc.nextInt();
					System.out.print("Enter y coordinate for new enemy: ");
					newY = sc.nextInt();
					System.out.print("Enter number for enemy name: (refer to map cheatsheet for numbers) "); // need to add a better system later
					newName = sc.nextInt();
					break;
				} catch (InputMismatchException e) // catching non ints
				{
					System.err.println("Wrong input! Input only integer numbers please...");
					System.out.println();
					sc.nextLine();
				}
			}
				if (((newX - 1) >= 0) && ((newY - 1) >= 0)) {
					if (sim.hasUnit(newX - 1, newY - 1) == false) {
						if (newName <= sim.getNumberOfEnemies() && newName >= 0) {
							sim.placeUnitOnMap(newX - 1, newY - 1, 8, newName);
							whileV = 3;
						} else {
							System.out.println("Error: name number is not valid");
							error = 1;
						}

					} else {
						System.out.print("Error: There is a unit on given tile;  ");
						error = 1;
					}
				} else {
					System.out.println("Error: negative coordinate, only positive");
					error = 1;

				}
				if (error == 1) {
					int c = 0;
					while (trying == 0) {

						try {
							System.out.print("to return to command table press 1:  to give new coordinates press any other number:  ");
							c = sc.nextInt();
							break;
						} catch (InputMismatchException e) // catching non ints
						{
							System.err.println("Wrong input! Input only integer numbers please...");
							System.out.println();
							sc.nextLine();
						}
					}
					if (c == 1) {
						whileV = 3;
					}

				}


			}
		}


	public static void removeUnit()
	{
		Scanner sc = new Scanner(System.in);


		int whileV = 0;
		while(whileV == 0)
		{
			int error =0;
			int newX= -1;
			int newY = -1;
			int trying = 0;


			while (trying == 0)
			{
				try {
					System.out.println("Enter the coordinates of the unit you want to remove:");
					System.out.print("X = ");
					newX = sc.nextInt();
					System.out.print("Y = ");
					newY = sc.nextInt();
					break;
				} catch (InputMismatchException e) // catching non ints
				{
					System.err.println("Wrong input! Input only integer numbers please...");
					System.out.println();
					sc.nextLine();
				}
			}
			if(((newX - 1) >=0 ) && ((newY - 1) >=0 ))
			{
				if(sim.hasUnit(newX -1, newY -1) == true && sim.getType(newX-1,newY-1) !=20)
				{
					// adding one so it will start the first player as 1 on the map
					sim.removeUnitFromTile(newX - 1, newY -1);
					whileV = 4;
				}
				else
				{
					System.out.print("Error: No unit on given tile  ");
					error = 1;
				}

			}
			else
			{
				System.out.println("Error: negative coordinate, only positive ");
				error = 1;
			}
			if(error == 1)
			{
				int c = 0;
				while (trying == 0)
				{

					try
					{
						System.out.print("to return to command table press 1:  to give new coordinates press any other number:  ");
						c = sc.nextInt();
						break;
					} catch (InputMismatchException e) // catching non ints
					{
						System.err.println("Wrong input! Input only integer numbers please...");
						System.out.println();
						sc.nextLine();
					}
				}
				if (c == 1)
				{
					whileV = 3;
				}
			}

		}

	}







}
