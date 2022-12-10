package com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.Maps;

import com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.elements.BattleWorld;

public class Map //Parent of the battlemap.
{

    public BattleWorld battleWorld;


    public Map()
    {
        battleWorld = new BattleWorld(0, 0, 0, 0);
    }
    public int getNumUnits()
    {
        return -1;
    }
    public int getType(int x, int y)
    {
        return -1;
    }
    public int getName(int x, int y)
    {
        return -1;
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


    public int getSizeY()
    {
        return -1;
    }
    public int getSizeX() {
        return -1;
    }

    public int getNumberOfEnemies()
    {
        return -1;
    }
}
