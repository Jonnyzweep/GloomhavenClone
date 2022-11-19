package main;

import java.util.Scanner;

public class GloomhavenClone {
	
	/** Game run boolean */
	private boolean running = false;
	
	/**
	 * Program starts here when program is ran.
	 * @param args Program starting arguments
	 */
	public static void main(String args[]) {
		//Instance of GloomhavenClone class
		GloomhavenClone instance = new GloomhavenClone();
		//Call run method to begin game loop
		instance.run(instance);
	}
	
	/**
	 * Method ran when game starts. Contains main game loop.
	 */
	public void run(GloomhavenClone gloomhavenClone) {
		
		//Set running to true once run method is called
		this.running = true;
		//Scanner variable to handle user input
		Scanner scanner = new Scanner(System.in);
		
		//Game loop will keep looping until running is false
		while(running) {
			
			//TODO game functions
			
		}
		
		//Once game is not longer running close our scanner
		scanner.close();
	}

}
