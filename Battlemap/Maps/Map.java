package com.mycompany.gloomhaven.Battlemap.Maps;

import com.mycompany.gloomhaven.Battlemap.elements.MapUnits;
import com.mycompany.gloomhaven.Battlemap.elements.World;

import java.util.ArrayList;

public class Map //Parent of the battlemap.
{

    public World world;

    public Map()
    {
        world = new World(0, 0, 0, 0);
    }
    public int getNumUnits()
    {
        return 0;
    }
    public int getType(int x, int y)
    {
        return 0;
    }
    public int getName(int x, int y)
    {
        return 0;
    }
    public void placeUnitOnMap(int x, int y, int type, int name)
    {

    }
    public void removeUnitFromTile(int x, int y)
    {

    }
    public boolean hasUnit(int x, int y)
    {
        return true;
    }

    public void populateMap()
    {

    }

    public void legend() {
    }

    public void printMap() {
    }


}
