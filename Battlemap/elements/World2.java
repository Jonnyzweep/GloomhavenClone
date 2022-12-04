package com.mycompany.gloomhaven.Battlemap.elements;


import java.util.Observable;

public class World2 extends Observable
{

	private int sizeX;
	private int sizeY;
	private int type;
	private int name;
	HexTile theWorld[][];

	public World2(int sizeX, int sizeY, int type, int name)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.type = type;
		this.name = name;
		theWorld = new HexTile[sizeX][sizeY];

		for (int x = 0; x < sizeX; x++) 
		{
			for (int y = 0; y < sizeY; y++) 
			{
				theWorld[x][y] = new HexTile(x, y, type, name);
			}
		}

	}

	public HexTile getHex(int x, int y)
	{
		if (x >= sizeX || x < 0)
		{
			return null;
		}
		if (y >= sizeY || y < 0)
		{
			return null;
		}
		return theWorld[x][y];
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

	public boolean placeUnitOnTile(int x, int y, int type, int name)
	{
		if (x >= sizeX || x < 0)
		{
			return false;
		}
		if (y >= sizeY || y < 0)
		{
			return false;
		}
		if (theWorld[x][y].hasAgent())
		{
			return false;
		}
		return theWorld[x][y].addAgent(type, name);

	}

	public int getSizeX()
	{
		return sizeX;
	}

	public int getSizeY()
	{
		return sizeY;
	}
	public int getType()
	{
		return type;
	}
	public int getName()
	{
		return name;
	}
}