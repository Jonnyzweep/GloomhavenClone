package com.mycompany.gloomhaven.Battlemap.simulation;


import java.util.Scanner;

public class SimController {

	static Map84 sim;


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		//System.out.println("Maps currently made are 84.");
		//System.out.print("Enter Map number to load:  ");
		//int map = sc.nextInt();
		// going to change this if there is more maps added
		int map = 84;
		if(map == 84)
		{
			sim = new Map84();
		}


		run();


	}

	public static void run()
	{
		Scanner sc = new Scanner(System.in);
		int whileV = 0;
		int choice = 0;
		int oldX, newX, oldY, newY = 0;
		sim.world.printBattle();
		System.out.println("");

		while(whileV == 0)
		{
			if(choice == 0)
			{
				System.out.println("Command Table:");
				System.out.println("Move a unit:        1");
				System.out.println("Move all units:     2");
				System.out.println("Add User unit:      3");
				System.out.println("Remove unit:        4");
				System.out.println("Map Legend:         5");
				System.out.println("Exit Battle:        6");
				System.out.print("Enter Command:       ");
				choice = sc.nextInt();
			}
			else if (choice == 1)
			{
				moveChoice();
				sim.world.printBattle();
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 2)
			{
				moveAll();
				sim.world.printBattle();
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 3)
			{
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 4)
			{
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
			System.out.println("Moveing unit at (" +x+", " + y +"): ");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new x coordinate: ");
			int newX = sc.nextInt();
			System.out.println("Enter new y coordinate: ");
			int newY = sc.nextInt();
			if(sim.world.hasUnit(newX -1, newY -1) == false)
			{
				sim.world.placeUnitOnMap(newX -1,newY -1,sim.world.getType(x -1,y -1), sim.world.getName(x -1,y -1));
				sim.world.removeUnitFromTile(x - 1,y - 1);
				whileV = 1;
			}
			else
			{
				System.out.println("Error: No unit on given tile; to skip this unit press 1:  to give new coordinates press any other number: ");
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
			System.out.println("Enter current x coordinate: ");
			int oldX = sc.nextInt();
			System.out.println("Enter current y coordinate: ");
			int oldY = sc.nextInt();
			if(sim.world.hasUnit(oldX - 1, oldY -1) == true) // all the minus 1 are for because all arrays start at 0
			{
				move(oldX,oldY);
				whileV =3;
			}
			else
			{
				System.out.println("Error: No unit on given tile; to return to command table press 1:  to give new coordinates press any other number: ");
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
				if(sim.world.getType(x,y) == 8)
				{
					indexX[tracker] = (x+1); // adding one so its gives the x as a human would enter it (x starting at 1)
					indexY[tracker] = (y+1);
					tracker += 1;
				}
			}
		}
		for( int i =0; i < tracker; i++)
		{
			move(indexX[i], indexY[i]);
		}

	}







}
