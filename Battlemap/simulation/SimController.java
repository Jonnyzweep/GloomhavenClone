package com.mycompany.gloomhaven.Battlemap.simulation;


import java.util.Scanner;

public class SimController {

	static Map84 sim;


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Maps currently made are 84.");
		System.out.print("Enter Map number to load:  ");
		int map = sc.nextInt();
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
				System.out.println("Add unit:           3");
				System.out.println("Remove unit:        4");
				System.out.println("Map Legend:         5");
				System.out.println("Exit Battle:        6");
				System.out.print("Enter Command:        ");
				choice = sc.nextInt();
			}
			else if (choice == 1)
			{
				move1();
				sim.world.printBattle();
				System.out.print("Enter Command: 0 to reshow command table: ");
				choice = sc.nextInt();

			}
			else if (choice == 2)
			{

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
	public static void move1() // moving one unit at a time
	{
		Scanner sc = new Scanner(System.in);
		int oldX, newX, oldY, newY = 0;
		System.out.println("Enter current x coordinate: ");
		oldX = sc.nextInt();
		System.out.println("Enter current y coordinate: ");
		oldY = sc.nextInt();
		if(sim.world.hasUnit(oldX - 1, oldY -1) == true) // all the minus 1 are for because all arrays start at 0
		{
			System.out.println("Enter new x coordinate: ");
			newX = sc.nextInt();
			System.out.println("Enter new y coordinate: ");
			newY = sc.nextInt();
			if(sim.world.hasUnit(newX -1, newY -1) == false)
			{
				sim.world.placeUnitOnMap(newX -1,newY -1,sim.world.getType(oldX -1,oldY -1), sim.world.getName(oldX -1,oldY -1));
				sim.world.removeUnitFromTile(oldX - 1,oldY - 1);
			}
			else
			{
				System.out.println("Error: There is a unit on given tile returning back to command table  ");
			}
		}
		else
		{
			System.out.println("Error: No unit on given tile returning back to command table  ");
		}
	}




}
