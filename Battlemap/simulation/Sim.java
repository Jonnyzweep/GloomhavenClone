package com.mycompany.gloomhaven.Battlemap.simulation;

import com.mycompany.gloomhaven.Battlemap.elements.MapUnits;
import com.mycompany.gloomhaven.Battlemap.elements.World;
import com.mycompany.gloomhaven.Battlemap.events.TickEnd;
import com.mycompany.gloomhaven.Battlemap.events.TickStart;
import com.mycompany.gloomhaven.Battlemap.gui.Grid;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class Sim extends Observable implements Runnable {
	private int sizeX = 10;
	private int sizeY = 7;
	private int maxTicks = 50;
	private int numUnits = 29;
	ArrayList<MapUnits> allUnits;
	World world;
	Random prng;
	Grid grid;
	Integer tick;

	public Sim() {
		allUnits = new ArrayList<MapUnits>(numUnits);

		world = new World(sizeX, sizeY, 0, 0);
		populateMap();
		grid = new Grid(world);
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

		allUnits.add(new MapUnits(1, 0,6,0));
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
			world.placeUnitOnTile(allUnits.get(i).getX(), allUnits.get(i).getY(), allUnits.get(i).getType(), allUnits.get(i).getName());
		}






		}



	public void run() {
		for (tick = 0; tick < maxTicks; tick++) {
			invokeAgentActions();
			fireEvent(new TickEnd(tick));
		}
	}

	public void invokeAgentActions() { // not in use
		fireEvent(new TickStart());
		for (int i = 0; i < numUnits; i++) {
			Random r = new Random();
			int[] newPos = { -1, -1 };
			boolean placedSuccessfully = false;
			while (!placedSuccessfully) {
				newPos[0] = r.nextInt(world.getSizeX());
				newPos[1] = r.nextInt(world.getSizeY());
				placedSuccessfully = world.placeUnitOnTile(newPos[0], newPos[1], 0, 0);
			}
			world.removeUnitFromTile(allUnits.get(i).getX(), allUnits.get(i).getY());
			allUnits.get(i).setPosition(newPos[0], newPos[1]);
			try {
				Thread.sleep(200); //slow down to see the movement
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void fireEvent(Object event) {
		setChanged();
		notifyObservers(event);
	}

	public World getWorld() {
		return world;
	}



}