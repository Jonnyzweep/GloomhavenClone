package com.mycompany.gloomhaven.Battlemap.events;

public class TickEnd
{
	int tick;

	public TickEnd(int newTick)
	{
		this.tick = newTick;
	}

	public int getTick()
	{
		return tick;
	}
}
