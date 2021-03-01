//EGR_283: Project04 
//Created by: Justin Cromer
//Date: Feb 20, 2021
//A program to build a small database of game information using singly linked lists.
//Note: All game data was obtained from BoardGameGeek.com. Any game rated without a top age was 
//	given a top age of 99. Game information that provided only an average time were given a max/min
//	of plus or minus 10 minutes (example: 120 minutes becomes 110-130 minutes).

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
		this.index.addAtHead(this.getSize());
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
		a = this.games.getDataAtPosition(this.index.getDataAtPosition(index));
		
		if(a == null) {
			b = null;
		} else {
		// Copy the data to a new object so as not to break encapsulation
			b = new Game();
			b.setName(a.getName());
			b.setMinAge(a.getMinAge());
			b.setMaxAge(a.getMaxAge());
			b.setMinPlayers(a.getMinPlayers());
			b.setMaxPlayers(a.getMaxPlayers());
			b.setMinPlayTime(a.getMinPlayTime());
			b.setMaxPlayTime(a.getMaxPlayTime());
		}// Ending bracket of else
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
	 * @return Copy of game data requested.
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
		int temp;
		for(int i = 0; i < this.getSize(); ++i) {
			if(this.getGame(i) == null) {
				continue;
			}// Ending bracket of if
			if(this.games.getDataAtPosition(this.index.getDataAtPosition(i)).compareName(gameName)) {
				System.out.println("Successfully removed " + "'" + gameName + "'.");
				temp = this.index.getDataAtPosition(i);
				this.games.removeData(this.games.getDataAtPosition(this.index.getDataAtPosition(i)));
				this.index.remove(i);
				
				// After removing the game and index data, remaining index data must be
				//	shifted to retain an index without gaps.
				this.shiftIndexData(temp);
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
		
	}// Ending bracket of method removeGame
	
	/**
	 * Method to sort the catalog into lexographic order. The purpose of this method
	 * is to sort the index list while leaving the raw game data untouched.
	 */
	public void sortCatalogue() {		
		int tempIndex;
		
		for(int length = this.getSize(); length > 1; --length) {
			
			for(int i = 0; i < length - 1; ++i) {
				if(this.getGame(i) == null) {
					continue;
				}// Ending bracket of if
				if(this.getGame(i).compareTo(this.getGame(i + 1)) > 0 ) {
					
					tempIndex = this.index.getDataAtPosition(i);
					
					this.index.setData(this.index.getDataAtPosition(i + 1), i);
					
					this.index.setData(tempIndex, i + 1);
				}//end of if (lexographic comparison)
			}//end of INNER for loop
		}//end of OUTER for loop
	}// Ending bracket of method sortCatalogue
	
	@Override
	/**
	 * Method to return game catalog data as a String.
	 * @return String form of the catalog.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		 // Header Section
		sb.append("NAME\t\t\tAGE\t\tPLAYERS\tTIME\t\t\tINDEX\tDATA\n"); 
		for(int i = 0; i < 85; ++i) {
			sb.append("-");
		}//end of for loop (formatting)
		sb.append("\n");
		
		
		// Game data 
		for(int i = 0; i < this.getSize(); ++i) {
			if(this.getGame(i) == null) {
				System.out.println("break");
				break;
			}// Ending bracket of if
			sb.append(this.getGame(i).toString() + "\t");
			sb.append(i + "\t"); //index position
			sb.append(this.index.getDataAtPosition(i) + "\n"); //index data
		
		}//end of for loop
		
		return sb.toString();
	}// Ending bracket of method toString\
	
	
	// Helper method to deal with reIndexing every time a game is removed. Though the 
	//	index itself gets shifted with game removal, the raw data in the index remains
	//	the same.  To correct this, we shift the data after the removed index data.
	private void shiftIndexData(int dataRemoved) {
		for(int i = 0; i < this.getSize(); ++i) {
			if(this.index.getDataAtPosition(i) > dataRemoved) {
				this.index.setData(this.index.getDataAtPosition(i) - 1, i);
			}// Ending bracket of if
		}// End of for loop
	}// Ending bracket of method shiftIndexData
	
	
	
}// Ending bracket of class GameCatalogue
