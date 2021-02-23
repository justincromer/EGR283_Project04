//EGR_283: Project04 
//Created by: Justin Cromer
//Date: Feb 20, 2021
//A program to build a small database of game information using singly linked lists.
//Note: All game data was obtained from BoardGameGeek.com. Any game rated without a top age was 
//	given a top age of 99. Game information that provided only an average time were given a max/min
//	of plus or minus 10 minutes (example: 120 minutes becomes 110-130 minutes).

package edu.mtc.egr283.project04;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class GameCatalogueDriver {
	
	public static void main(String[] args) {
		
		// Prepare variables and open data streams
		
		Scanner eReader = null;
		
		String fileName = "GameData.txt";
		
		GameCatalogue gc = new GameCatalogue();
		
		
		
		// Handle potential exception
		try {
			eReader = new Scanner(new File(fileName));
			
		}catch(FileNotFoundException fne) {
			System.out.println("File not found: " + fileName);
			System.exit(0);
		}
		
		// 				###############################
		//				#	BEGIN TESTING METHODS	 ##
		//				###############################
		
		
		// The method readFile in the GameCatalogue class also uses these methods:
		//		*Constructor			[Game class]
		// 		*All mutator methods 	[Game class]
		//		*readGame 				[Game class]
		//		*addGame				[GameCatalogue class]
		
		methodTesting("readFile");
		gc.readFile(eReader);
		
		
		// The method toString in the GameCatalogue class also uses these methods:
		// 		*All accessor methods 	[Game class]
		//		*toString				[Game class]
		//		*getSize 				[GameCatalogue class]
		
		methodTesting("toString");
		System.out.println(gc.toString());
	
		
		// The method findGame in the GameCatalogue class also uses these methods:
		//		*compareName			[Game class]
		//		*getGame				[GameCatalogue class]
	
		methodTesting("findGame");
		System.out.println("Find game 'Go':\n\n" + gc.findGame("Go").toString());
		System.out.println("Find game 'Chutes and Ladders':\n\n" + gc.findGame("Chutes and Ladders").toString());
		System.out.println("Find game 'Stratego':\n\n" + gc.findGame("Stratego").toString());
		
		
		methodTesting("sortCatalogue");
		gc.sortCatalogue();
		System.out.println(gc.toString());
		
	
		
		// TO DO:
		//	*removeGame
		
		
		// Close the Scanner object.
		eReader.close();
		
	}// Ending bracket of method main


	
	
	
	
	
	// A few simple helper methods for formatting.
	
	private static void methodTesting(String methodToTest) {
		GameCatalogueDriver.separationFormatting();
		System.out.println("\t\t\tTESTING METHOD: " + methodToTest); 
		GameCatalogueDriver.separationFormatting();
	}// Ending bracket of method methodTesting
	
	private static void separationFormatting() {
		System.out.println();
		for(int i = 0; i < 40; ++i) {
			System.out.print("##");
		}// Ending bracket of for loop
		System.out.println();
		System.out.println();
	}// Ending bracket of method separationFormatting


}// Ending bracket of class GameCatalogueDriver
