package com.mycompany.gloomhaven.Battlemap.Maps;

import com.mycompany.gloomhaven.Battlemap.elements.MapUnits;
import com.mycompany.gloomhaven.Battlemap.elements.World;

import java.util.ArrayList;

public class Map1 extends Map
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String BLACK_BACKGROUND = "\033[40m";  // Walls



    private int sizeX = 6;
    private int sizeY = 25;
    private int numUnits = 0; // everything that is added to the map
    ArrayList<MapUnits> allUnits;
    public World world;
    public Map1()
    {
        allUnits = new ArrayList<MapUnits>(numUnits);

        world = new World(sizeX, sizeY, 0, 0);
        populateMap(); // creates map

    }
    public void populateMap() {
        //Starting
        allUnits.add(new MapUnits(2, 23,0,1));
        allUnits.add(new MapUnits(3, 22,0,1));
        allUnits.add(new MapUnits(3, 23,0,1));
        allUnits.add(new MapUnits(3, 24,0,1));
        allUnits.add(new MapUnits(4, 22,0,1));
        allUnits.add(new MapUnits(4, 23,0,1));
        allUnits.add(new MapUnits(4, 24,0,1));
        //Doors
        allUnits.add(new MapUnits(2, 7,1,0));
        allUnits.add(new MapUnits(3, 15,1,0));
        //Traps
        allUnits.add(new MapUnits(3, 6,3,0));
        allUnits.add(new MapUnits(3, 8,3,0));
        //Obstacles
        allUnits.add(new MapUnits(1, 3,6,2));
        allUnits.add(new MapUnits(1, 5,6,2));
        allUnits.add(new MapUnits(1, 9,6,2));
        allUnits.add(new MapUnits(1, 11,6,2));
        //Treasure
        allUnits.add(new MapUnits(0, 3,7,1));
        allUnits.add(new MapUnits(0, 11,7,1));
        allUnits.add(new MapUnits(0, 12,7,0));
        allUnits.add(new MapUnits(1, 2,7,1));
        allUnits.add(new MapUnits(1, 12,7,1));
        //Enemies
        allUnits.add(new MapUnits(0, 4,8,5));
        allUnits.add(new MapUnits(0, 6,8,5));
        allUnits.add(new MapUnits(0, 8,8,5));
        allUnits.add(new MapUnits(0, 10,8,5));
        allUnits.add(new MapUnits(1, 6,8,6));
        allUnits.add(new MapUnits(1, 8,8,6));
        allUnits.add(new MapUnits(2, 6,8,6));
        allUnits.add(new MapUnits(2, 8,8,6));
        allUnits.add(new MapUnits(2, 16,8,4));
        allUnits.add(new MapUnits(2, 17,8,4));
        allUnits.add(new MapUnits(3, 0,8,5));
        allUnits.add(new MapUnits(3, 1,8,5));
        allUnits.add(new MapUnits(3, 10,8,4));
        allUnits.add(new MapUnits(3, 11,8,4));
        allUnits.add(new MapUnits(3, 16,8,4));
        allUnits.add(new MapUnits(3, 17,8,4));
        allUnits.add(new MapUnits(4, 0,8,5));
        allUnits.add(new MapUnits(4, 10,8,4));
        allUnits.add(new MapUnits(4, 16,8,4));
        allUnits.add(new MapUnits(4, 17,8,4));
        allUnits.add(new MapUnits(5, 16,8,4));
        //DeadSpace
        allUnits.add(new MapUnits(0, 0,20,0));
        allUnits.add(new MapUnits(0, 1,20,2));
        allUnits.add(new MapUnits(0, 13,20,2));
        allUnits.add(new MapUnits(0, 14,20,0));
        allUnits.add(new MapUnits(0, 15,20,0));
        allUnits.add(new MapUnits(0, 16,20,0));
        allUnits.add(new MapUnits(0, 17,20,0));
        allUnits.add(new MapUnits(0, 18,20,0));
        allUnits.add(new MapUnits(0, 19,20,0));
        allUnits.add(new MapUnits(0, 20,20,0));
        allUnits.add(new MapUnits(0, 21,20,0));
        allUnits.add(new MapUnits(0, 22,20,0));
        allUnits.add(new MapUnits(0, 23,20,0));
        allUnits.add(new MapUnits(0, 24,20,0));
        allUnits.add(new MapUnits(0, 25,20,0));
        allUnits.add(new MapUnits(1, 0,20,0));
        allUnits.add(new MapUnits(1, 1,20,2));
        allUnits.add(new MapUnits(1, 13,20,2));
        allUnits.add(new MapUnits(1, 14,20,0));
        allUnits.add(new MapUnits(1, 15,20,4));
        allUnits.add(new MapUnits(1, 16,20,0));
        allUnits.add(new MapUnits(1, 17,20,1));
        allUnits.add(new MapUnits(1, 18,20,0));
        allUnits.add(new MapUnits(1, 19,20,1));
        allUnits.add(new MapUnits(1, 20,20,0));
        allUnits.add(new MapUnits(1, 21,20,1));
        allUnits.add(new MapUnits(1, 22,20,0));
        allUnits.add(new MapUnits(1, 23,20,1));
        allUnits.add(new MapUnits(1, 24,20,0));
        allUnits.add(new MapUnits(1, 25,20,1));
        allUnits.add(new MapUnits(2, 0,20,0));
        allUnits.add(new MapUnits(2, 1,20,3));
        allUnits.add(new MapUnits(2, 3,20,1));
        allUnits.add(new MapUnits(2, 5,20,1));
        allUnits.add(new MapUnits(2, 9,20,1));
        allUnits.add(new MapUnits(2, 11,20,1));
        allUnits.add(new MapUnits(2, 13,20,3));
        allUnits.add(new MapUnits(2, 14,20,0));
        allUnits.add(new MapUnits(2, 15,20,3));
        allUnits.add(new MapUnits(4, 1,20,1));
        allUnits.add(new MapUnits(4, 3,20,1));
        allUnits.add(new MapUnits(4, 5,20,1));
        allUnits.add(new MapUnits(4, 7,20,1));
        allUnits.add(new MapUnits(4, 9,20,1));
        allUnits.add(new MapUnits(4, 11,20,1));
        allUnits.add(new MapUnits(4, 13,20,1));
        allUnits.add(new MapUnits(4, 15,20,4));
        allUnits.add(new MapUnits(5, 0,20,0));
        allUnits.add(new MapUnits(5, 1,20,0));
        allUnits.add(new MapUnits(5, 2,20,0));
        allUnits.add(new MapUnits(5, 3,20,0));
        allUnits.add(new MapUnits(5, 4,20,0));
        allUnits.add(new MapUnits(5, 5,20,0));
        allUnits.add(new MapUnits(5, 6,20,0));
        allUnits.add(new MapUnits(5, 7,20,0));
        allUnits.add(new MapUnits(5, 8,20,0));
        allUnits.add(new MapUnits(5, 9,20,0));
        allUnits.add(new MapUnits(5, 10,20,0));
        allUnits.add(new MapUnits(5, 11,20,0));
        allUnits.add(new MapUnits(5, 12,20,0));
        allUnits.add(new MapUnits(5, 13,20,0));
        allUnits.add(new MapUnits(5, 14,20,0));
        allUnits.add(new MapUnits(5, 15,20,3));
        allUnits.add(new MapUnits(5, 17,20,1));
        allUnits.add(new MapUnits(5, 19,20,1));
        allUnits.add(new MapUnits(5, 21,20,1));
        allUnits.add(new MapUnits(5, 23,20,1));
        allUnits.add(new MapUnits(5, 25,20,1));
        numUnits = allUnits.size();
        for (int i = 0; i < numUnits; i++)
        {
            world.placeUnitOnMap(allUnits.get(i).getX(), allUnits.get(i).getY(), allUnits.get(i).getType(), allUnits.get(i).getName());
        }


    }
    public void legend() // simple way to print legend of map, have to update per map files
    {
        System.out.println("Legend:");
        System.out.println(BLACK_BACKGROUND + "  " + ANSI_RESET + " = are deadspace");
        System.out.println(BLACK_BACKGROUND + "|-" + ANSI_RESET + " = are walls");
        System.out.println("[] = Open Space: ! are the starting tiles and acts like normal tiles after adding your characters");
        System.out.println(ANSI_BLUE+ "[] = Door" + ANSI_RESET);
        System.out.println(ANSI_RED + "() = Trap:" + ANSI_RESET + " D = Damage Trap ");
        System.out.println(ANSI_GREEN + "() = Obstacles:" + ANSI_RESET + " t = Table ");
        System.out.println(ANSI_YELLOW + "() = Treasure:" + ANSI_RESET + " C = Chest, T = Token ");
        System.out.println(ANSI_RED + "{} = Enemies:" + ANSI_RESET + " G = Bandit Guard, A = Bandit Archer, B = Living Bones");
        System.out.println(ANSI_RED + "<> = Players:" + ANSI_RESET + " The number is the order you enter them ");


    }
    public void printMap()
    {
        world.printBattle();

    }
    public int getType(int x, int y)
    {
        return world.getType(x,y);
    }
    public int getName(int x, int y)
    {
        return world.getName(x,y);
    }
    public void placeUnitOnMap(int x, int y, int type, int name)
    {
        world.placeUnitOnMap(x,y,type,name);

    }
    public void removeUnitFromTile(int x, int y)
    {
        world.removeUnitFromTile(x,y);
    }
    public boolean hasUnit(int x, int y)
    {
        return world.hasUnit(x,y);
    }
    public int getSizeX()
    {
        return sizeX;
    }
    public int getSizeY()
    {
        return sizeY;
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
