package edu.mtc.egr283.project04;

import java.util.Scanner;

public class Game {

	private String name;
	
	private int minAge;
	private int maxAge;
	private int minPlayers;
	private int maxPlayers;
	private int minPlayTime;
	private int maxPlayTime;
	
	private static final String NEW_LINE = "\n";
	private static final int MAX_AGE = 99;
	
	public Game() {
		this.name = "New Game";
		this.minAge = 0;
		this.maxAge = 0;
		this.minPlayers = 0;
		this.maxPlayers = 0;
		this.minPlayTime = 0;
		this.maxPlayTime = 0;
	}// Ending bracket of constructor
	
	/**
	 * Accessor method for name.
	 * @return the name
	 */
	public String getName() {
		
		// Correct the file-formatting to a more user-friendly appearance.
		return name.replace("_", " ");
	}// Ending bracket of method getName
	
	/**	
	 * Accessor method for minimum age.
	 * @return the minAge
	 */
	public int getMinAge() {
		return minAge;
	}// Ending bracket of method getMinAge
	
	/** 
	 * Accessor method for maximum age.
	 * @return the maxAge
	 */
	public int getMaxAge() {
		return maxAge;
	}// Ending bracket of method getMaxAge
	
	/** 
	 * Accessor method for minimum players.
	 * @return the minPlayers
	 */
	public int getMinPlayers() {
		return minPlayers;
	}// Ending bracket of method getMinPlayers
	
	/** 
	 * Accessor method for maximum players.
	 * @return the maxPlayers
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}// Ending bracket for method getMaxPlayers
	
	/** 
	 * Accessor method for minimum play time.
	 * @return the minPlayTime
	 */
	public int getMinPlayTime() {
		return minPlayTime;
	}// Ending bracket of method getMinPlayTime
	
	/** 
	 * Accessor method for maximum play time.
	 * @return the maxPlayTime
	 */
	public int getMaxPlayTime() {
		return maxPlayTime;
	}// Ending bracket of method getMaxPlayTime
	
	/** 
	 * Mutator method for name.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}// Ending bracket of method setName
	
	/** 
	 * Mutator method for minimum age.
	 * @param minAge the minAge to set
	 */
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}// Ending bracket of method setMinAge
	
	/** 
	 * Mutator method for maximum age.
	 * @param maxAge the maxAge to set
	 */
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}// Ending bracket of method setMaxAge
	
	/** 
	 * Mutator method for minimum players.
	 * @param minPlayers the minPlayers to set
	 */
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}// Ending bracket of method setMinPlayers
	
	/** 
	 * Mutator method for maximum players.
	 * @param maxPlayers the maxPlayers to set
	 */
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}// Ending bracket of method setMaxPlayers
	
	/** 
	 * Mutator method for minimum play time.
	 * @param minPlayTime the minPlayTime to set
	 */
	public void setMinPlayTime(int minPlayTime) {
		this.minPlayTime = minPlayTime;
	}// Ending bracket of method
	
	/**
	 * Mutator method for maximum play time.
	 * @param maxPlayTime the maxPlayTime to set
	 */
	public void setMaxPlayTime(int maxPlayTime) {
		this.maxPlayTime = maxPlayTime;
	}// Ending bracket of method setMaxPlayTime
	
	/**
	 * Method to check if two game names are the same.
	 * @param otherGameName
	 * @return true if names are the same
	 */
	public boolean compareName(String otherGameName) {
		return this.getName().equalsIgnoreCase(otherGameName);
	}// Ending bracket of method compareTo
	
	
	/**
	 * Method to compare the name values of records.
	 * This does a lexicographic comparison on the data stored, so 
	 * @param otherGame the other record to compare to
	 * @return -1, 0, or +1 depending on how the comparison goes.
	 */
	public int compareTo(Game otherGame) {
		int rv;
		if(this.getName().compareTo(otherGame.getName()) < 0) {
			rv = -1;
		}else if(this.getName().compareTo(otherGame.getName()) > 0) {
			rv = +1;
		}else {
			rv = 0;
		}//end of if
		return rv;
	}// Ending bracket of method compareTo
	
	public void readGame(Scanner inputStream) {
		if(inputStream.hasNext()) {
			this.setName(inputStream.next());
			this.setMinAge(inputStream.nextInt());
			this.setMaxAge(inputStream.nextInt());
			this.setMinPlayers(inputStream.nextInt());
			this.setMaxPlayers(inputStream.nextInt());
			this.setMinPlayTime(inputStream.nextInt());
			this.setMaxPlayTime(inputStream.nextInt());
		}else { 
			System.out.println("No data to scan.");
		}//end of if - else
		
	}// Ending bracket of method readGame
	
	@Override
	/**
	 * Method to get individual game data in string format.
	 * @return String form of data
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Game Name:\t" + this.getName() + Game.NEW_LINE);
		
		// If maximum age is undefined (99), display as "(lowest age) +"
		if(this.getMaxAge() == Game.MAX_AGE) {
			sb.append("Player Age:\t" + this.getMinAge() + "+ yrs." + Game.NEW_LINE);
		}else {
			sb.append("Player Age:\t" + this.getMinAge() + "-" + this.getMaxAge() + " yrs." + Game.NEW_LINE);
		}//end of if else (age)
		
		// If the game has a fixed number of players, display only one number
		if(this.getMinPlayers() == this.getMaxPlayers()) {
			sb.append("Players:\t" + this.getMaxPlayers() + Game.NEW_LINE);
		}else {
			sb.append("Players:\t" + this.getMinPlayers() + "-" + this.getMaxPlayers() + Game.NEW_LINE);
		}//end of if else (number of players)
		
		sb.append("Time Needed:\t" + this.getMinPlayTime() + "-"+ this.getMaxPlayTime() + " minutes" + Game.NEW_LINE);
		
		return sb.toString();
	}// Ending bracket of method toString
	
	
}// Ending bracket of class Game
