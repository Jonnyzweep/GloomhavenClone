package com.mycompany.gloomhaven.Battlemap.elements;

public class MapUnits {
	private int pos[] = new int[4];

	public MapUnits(int setPosX, int setPosY, int setType, int setName) {
		pos[0] = setPosX;
		pos[1] = setPosY;
		pos[2] = setType;
		pos[3] = setName;
	}

	public void setPosition(int newPosX, int newPosY) {
		pos[0] = newPosX;
		pos[1] = newPosY;
	}

	public int getX() {
		return pos[0];
	}

	public int getY() {
		return pos[1];
	}
	public int getType() {
		return pos[2];
	}
	public int getName() {
		return pos[3];
	}

	public String geteType() // no need yet to get name
	{
		// 0 is nothing
		if(pos[2] == 1)
		{
			return "Doors";
		}
		else if(pos[2] == 2)
		{
			return "Corridor";
		}
		else if(pos[2] == 3)
		{
			return "Traps";
		}
		else if(pos[2] == 4)
		{
			return "Hazardous terrain";
		}
		else if(pos[2] == 5)
		{
			return "Difficult terrain";
		}
		else if(pos[2] == 6)
		{
			return "Obstacles";
		}
		else if(pos[2] == 7)
		{
			return "Treasure";
		}
		else if(pos[2] == 8)
		{
			return "Players";
		}

		return null;
	}
	public String geteName() // return the names half finish
	{
		if(pos[2] == 1) // doors
		{
			return "Doors";
		}




		if(pos[2] == 2) // Corridor
		{
			return "Doors";
		}




		if(pos[2] == 3) // Traps
		{
			return "Doors";
		}



		if(pos[2] == 4) // Hazardous terrain
		{
			return "Doors";
		}



		if(pos[2] == 5) // Difficult terrain
		{
			if(pos[3] == 0)
			{
				return "Log";
			}
			else if(pos[3] == 1)
			{
				return null;
			}
		}


		if(pos[2] == 6) // Obstacles
		{
			if(pos[3] == 0)
			{
				return "Bush";
			}
			else if(pos[3] == 1)
			{
				return "Tree";
			}
		}



		if(pos[2] == 7) // Treasures
		{
			if(pos[3] == 0)
			{
				return "chest";
			}
			return "Doors";
		}



		else if(pos[2] == 8) // players
		{
			if(pos[3] == 0)
			{
				return "Harrower Infester";
			}
			else if(pos[3] == 1)
			{
				return "Forest Imp";
			}
			else if(pos[3] == 2)
			{
				return "Earth Demon";
			}
			else if(pos[3] == 3)
			{
				return null;
			}
		}

		return null;

	}


	public int[] getPosition() {
		return pos;
	}

}
