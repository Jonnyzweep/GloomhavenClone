package com.mycompany.gloomhaven.Battlemap.simulation;


import com.mycompany.gloomhaven.Battlemap.events.EventManager;
import com.mycompany.gloomhaven.Battlemap.gui.Frame;

import java.awt.*;

public class SimController {

	static Sim sim;
	Frame frame;
	static EventManager emgr;
	static SimController controller;


	public static void main(String[] args) {
		sim = new Sim();
		Frame frame = new Frame(sim.getWorld(), emgr);
		frame.open();
		sim.addObserver(frame.getUserControls());


	} 
}
