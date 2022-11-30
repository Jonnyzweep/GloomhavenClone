package com.mycompany.gloomhaven.Battlemap.simulation;

import com.mycompany.gloomhaven.Battlemap.elements.Enemies;
import com.mycompany.gloomhaven.Battlemap.elements.Log;
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
	private int numLog = 4;
	private int numEnemies= 12;
	ArrayList<Log> allLog;
	ArrayList<Enemies> allEnemies;
	World world;
	Random prng;
	Grid grid;
	Integer tick;

	public Sim() {
		allLog = new ArrayList<Log>(numLog);
		allEnemies = new ArrayList<Enemies>(numLog);
		world = new World(sizeX, sizeY);
		populateMap();
		grid = new Grid(world);
	}

	public void populateMap() {
		allLog.add(new Log(0, 1));
		allLog.add(new Log(0, 2));
		allLog.add(new Log(4, 5));
		allLog.add(new Log(4, 6));
		for (int i = 0; i < numLog; i++)
		{
			world.placeUnitOnTile(allLog.get(i).getX(), allLog.get(i).getY());
		}
		allEnemies.add(new Enemies(1, 0));
		allEnemies.add(new Enemies(8, 0));
		allEnemies.add(new Enemies(1, 1));
		allEnemies.add(new Enemies(7, 1));
		allEnemies.add(new Enemies(8, 1));
		allEnemies.add(new Enemies(1, 4));
		allEnemies.add(new Enemies(8, 4));
		allEnemies.add(new Enemies(9, 4));
		allEnemies.add(new Enemies(0, 5));
		allEnemies.add(new Enemies(9, 5));
		allEnemies.add(new Enemies(1, 6));
		allEnemies.add(new Enemies(8, 6));

		for (int i = 0; i < numEnemies; i++)
		{
			world.placeUnitOnTile(allEnemies.get(i).getX(), allEnemies.get(i).getY());
		}






		}



	public void run() {
		for (tick = 0; tick < maxTicks; tick++) {
			invokeAgentActions();
			fireEvent(new TickEnd(tick));
		}
	}

	public void invokeAgentActions() {
		fireEvent(new TickStart());
		for (int i = 0; i < numLog; i++) {
			Random r = new Random();
			int[] newPos = { -1, -1 };
			boolean placedSuccessfully = false;
			while (!placedSuccessfully) {
				newPos[0] = r.nextInt(world.getSizeX());
				newPos[1] = r.nextInt(world.getSizeY());
				placedSuccessfully = world.placeUnitOnTile(newPos[0], newPos[1]);
			}
			world.removeUnitFromTile(allLog.get(i).getX(), allLog.get(i).getY());
			allLog.get(i).setPosition(newPos[0], newPos[1]);
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