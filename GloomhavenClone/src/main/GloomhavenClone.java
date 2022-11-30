package main;

import java.io.PrintStream;
import java.util.Scanner;

import main.entity.CharacterManager;
import main.entity.EntityManager;

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
		PrintStream stream = System.out;
		
		EntityManager entityManager = new EntityManager();
		CharacterManager characterManager = new CharacterManager();
		
		//Checks if user has selected a character previously
		if(!characterManager.hasSelectedCharacter())
			characterManager.characterSelectionMenu(gloomhavenClone, stream, scanner);
		
		//Game loop will keep looping until running is false
		while(running) {
			
			//TODO game functions
			
		}
		
		//Once game is not longer running close our scanner
		scanner.close();
	}
	
	public void print(PrintStream stream, String line) {
		stream.println(line);
	}

}