package main.entity;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import main.GloomhavenClone;

public class CharacterManager {
	
	private Character character;
	
	private HashMap<Integer, Character> characters;
	
	public CharacterManager () {
		this.character = null;
		this.characters = new HashMap<>();
		
		//Sample character
		this.addCharacter(new Character("Sample"));
	}
	
	/**
	 * Displays menu to allow user character selection
	 * @param gh GloomhavenClone instance
	 * @param stream PrintStream for user output
	 * @param scanner Scanner for user input
	 */
	public void characterSelectionMenu(GloomhavenClone gh, PrintStream stream, Scanner scanner) {
		gh.print(stream, "Please select your character:");
		
		//Prints each character as well as ID
		this.characters.forEach((id, character) -> gh.print(stream, id + " " + character.getName()));
		
		//Keep looping until user inputs valid character selection
		while(true) {
			String selection = scanner.nextLine();
			
			//TODO integer parse exception
			
			//Check if the input is a valid character ID
			if(characters.containsKey(Integer.parseInt(selection))) {
				Character selectedCharacter = characters.get(Integer.parseInt(selection));
				
				setCharacter(selectedCharacter);
				gh.print(stream, "Selected character " + selectedCharacter.getName() + "!");
			}else {
				gh.print(stream, "Invalid character selection!");
			}
		}
	}
	
	/**
	 * Checks if user has already selected character
	 * @return whether character object is not null
	 */
	public boolean hasSelectedCharacter() {
		return this.character != null;
	}
	
	/**
	 * Add character to selection menu
	 * @param character Character object
	 */
	public void addCharacter(Character character) {
		this.characters.put(this.characters.size(), character);
	}
	
	/**
	 * Program starts here when program is ran.
	 * @param character Character object
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}

}
