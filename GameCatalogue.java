package edu.mtc.egr283.project04;

import java.util.Scanner;

public class GameCatalogue {

	private SLL<Integer> index;
	private SLL<Game> games;
	
	/**
	 * Constructor.
	 * Initialize the index and games lists.
	 */
	public GameCatalogue() {
		this.index = new SLL<Integer>();
		this.games = new SLL<Game>();
	}// Ending bracket of no-args constructor
	
	/**
	 * Method to add a single game to the catalog and also create an index number
	 * for the game being added.
	 * @param newGame
	 */
	public void addGame(Game newGame) {	
		this.index.addAtHead(Integer.valueOf(this.getSize()));
		this.games.addAtHead(newGame);
	}// Ending bracket of method addGame
	
	/**
	 * Method to retrieve a game's information from the catalog.
	 * @param index of game to retrieve.
	 * @return game requested.
	 */
	public Game getGame(int index) {
		Game a, b;
		
		// Make a temporary variable for the game sought
		a = this.games.getDataAtPosition(this.index.getDataAtPosition(Integer.valueOf(index)));
		
		// Copy the data to a new object so as not to break encapsulation
		b = new Game();
		b.setName(a.getName());
		b.setMinAge(a.getMinAge());
		b.setMaxAge(a.getMaxAge());
		b.setMinPlayers(a.getMinPlayers());
		b.setMaxPlayers(a.getMaxPlayers());
		b.setMinPlayTime(a.getMinPlayTime());
		b.setMaxPlayTime(a.getMaxPlayTime());
		
		// Return a copy of the game information requested
		return b;
	}// Ending bracket of method getGame
	
	/**
	 * Method to get the current size of the catalog
	 * @return size of the catalog.
	 */
	public int getSize() {
		return this.games.size();
	}// Ending bracket of method getSize
	
	/**
	 * A simple linear search method to retrieve a game's information from the catalog.
	 * @param gameName of game to retrieve.
	 * @return game requested.
	 */
	public Game findGame(String gameName) {
		Game a, b;
		
		a = null;
		
		// Search the game list to find a game with the desired name, create a 
		// 	reference variable.
		for(int i = 0; i <this.getSize(); ++i) {
			if(this.getGame(i).compareName(gameName)){
				a = this.getGame(i);
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		// Copy the data to a new object so as not to break encapsulation
		b = new Game();
		b.setName(a.getName());
		b.setMinAge(a.getMinAge());
		b.setMaxAge(a.getMaxAge());
		b.setMinPlayers(a.getMinPlayers());
		b.setMaxPlayers(a.getMaxPlayers());
		b.setMinPlayTime(a.getMinPlayTime());
		b.setMaxPlayTime(a.getMaxPlayTime());
		
		
		return b;
	}// Ending bracket of method findGame
	
	/**
	 * Method to read the file from an input Scanner file.
	 * This reads the entire file. 
	 * @param inputStream Scanner from which to read.
	 */
	public void readFile(Scanner inputStream) {
		int count = 0;
		while(inputStream.hasNextLine()) {
			++count;
			Game g = new Game();
			g.readGame(inputStream);
			this.addGame(g);
			
			// This line is for testing verification and can be removed if desired:
			System.out.println("Added game " + count + ": " + g.getName());  
			
		}// Ending bracket of while loop
	
	}// Ending bracket of method readFile
	
	/**
	 * Method for removing games from the catalog.
	 * @param gameName of which to remove.
	 */
	public void removeGame(String gameName) {
		System.out.println("Removed game: " + this.findGame(gameName).toString());
		System.out.println();
		System.out.println();
		
		//STILL NEED TO DEAL WITH INDEX REMOVAL
		this.games.remove(getMemoryAddress(gameName));
		
	}// Ending bracket of method removeGame
	
	/**
	 * Method to sort the catalog into lexographic order. The purpose of this method
	 * is to sort the index list while leaving the raw game data untouched.
	 */
	public void sortCatalogue() {
		int tempIndex;
		
		for(int length = this.getSize(); length > 1; --length) {
			
			for(int i = 0; i < length - 1; ++i) {
				
				if(this.getGame(this.index.getDataAtPosition(i)).compareTo(this.
								getGame(this.index.getDataAtPosition(i + 1))) > 0 ) {
					
					tempIndex = this.index.getDataAtPosition(i + 1);
					
					this.index.remove(i + 1);
					this.index.add(Integer.valueOf(tempIndex), i);
					
				}//end of if
			}//end of INNER for loop
		}//end of OUTER for loop

	}// Ending bracket of method sortCatalogue
	
	
	@Override
	/**
	 * Method to return game catalog data as a String
	 * @return String form of the catalog.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < this.getSize(); ++i) {
			sb.append(this.getGame(this.index.getDataAtPosition(i)).toString() + "\n");
		}//end of for loop
		
		return sb.toString();
	}// Ending bracket of method toString\
	
	
	
	// Helper method for game removal
	private Game getMemoryAddress(String gameName) {
		Game actual = null;
		
		// Find the game
		for(int i = 0; i <this.getSize(); ++i) {
			if(this.getGame(i).compareName(gameName)){
				actual = this.getGame(i);
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		return actual;
	}// Ending bracket of method getMemoryAddress
	
	
	
}// Ending bracket of class GameCatalogue
