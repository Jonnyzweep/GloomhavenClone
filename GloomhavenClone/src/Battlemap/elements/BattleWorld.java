package com.mycompany.gloomhaven.GloomhavenClone.src.Battlemap.elements;

public class BattleWorld {
    private int sizeX;
    private int sizeY;
    private int type;
    private int name;

    HexTile theWorld[][];
    private PrintMap Printer;
    private boolean hasUnit;

    public BattleWorld(int sizeX, int sizeY, int type, int name)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        theWorld = new HexTile[sizeX][sizeY];
        for (int x = 0; x < sizeX; x++)
        {
            for (int y = 0; y < sizeY; y++)
            {
                theWorld[x][y] = new HexTile(x, y, type, name);
            }
        }


    }

    public void removeUnitFromTile(int x, int y)
    {
        if (x >= sizeX || x < 0)
        {
            return;
        }
        if (y >= sizeY || y < 0)
        {
            return;
        }
        theWorld[x][y].removeAgent();
    }

    public boolean placeUnitOnMap(int x, int y, int type, int name)
    {
        if (x >= sizeX || x < 0)
        {
            return false;
        }
        if (y >= sizeY || y < 0)
        {
            return false;
        }
        return theWorld[x][y].addAgent(type, name);

    }
    public boolean hasUnit(int x, int y)
    {
        if(theWorld[x][y].hasAgent() == true)
        {
            hasUnit = true;
        }
        else
        {
            hasUnit = false;
        }
        return hasUnit;
    }

    public void printBattle()
    {
        Printer = new PrintMap(theWorld, sizeX, sizeY);
    }


    public int getSizeX()
    {
        return sizeX;
    }

    public int getSizeY()
    {
        return sizeY;
    }
    public int getType(int x, int y)
    {
        return theWorld[x][y].getType();
    }
    public int getName(int x, int y)
    {
        return theWorld[x][y].getName();
    }










}
