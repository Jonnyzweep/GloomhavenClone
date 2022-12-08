package com.mycompany.gloomhaven.Battlemap.elements;

public class HexTile 
{
	private int[] position = new int[4];
	private boolean hasAgent;

	public HexTile(int newPosX, int newPosY,int newType, int newName)
	{
		position[0] = newPosX;
		position[1] = newPosY;
		position[2] = newType;
		position[3] = newName;
	}
	
	public boolean hasAgent()
	{
		if(position[2] == 0)
		{
			hasAgent = false;
		}
		else
		{
			hasAgent = true;
		}
		return hasAgent;
	}


	public void removeAgent()
	{
		position[2] = 0;
		hasAgent = false;
	}

	
	public boolean addAgent(int type, int name)
	{

		hasAgent = true;
		position[2] = type;
		position[3] = name;
		return true;
	}

	public int[] getPosition()
	{
		return position;
	}

	public void setPosition(int[] newPosition)
	{
		position[0] = newPosition[0];
		position[1] = newPosition[1];
	}

	public int getType()
	{
		return position[2];
	}
	public int getName()
	{
		return position[3];
	}



	//return image


}