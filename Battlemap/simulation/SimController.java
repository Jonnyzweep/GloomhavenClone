package com.mycompany.gloomhaven.Battlemap.simulation;


import com.mycompany.gloomhaven.Battlemap.events.EventManager;
import com.mycompany.gloomhaven.Battlemap.gui.Frame;

import java.awt.*;

public class SimController {

	static Sim sim;


	public static void main(String[] args) {
		sim = new Sim();
		sim.run();


	} 
}
