package edu.mtc.egr283.project04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameDriver {

	public static void main(String[] args) {
		
		Game g = new Game();
		Game d = new Game();
		
		Scanner s = null;
		
		try{
			s = new Scanner(new File("GameData.txt"));
		} catch(FileNotFoundException fne) {
			System.out.println("File not found.");
			System.exit(0);
		}
		
		
		g.setName("Test_Game");
		g.setMinAge(1);
		g.setMaxAge(10);
		g.setMinPlayTime(5);
		g.setMaxPlayTime(60);
		g.setMinPlayers(2);
		g.setMaxPlayers(4);
		
		d.readGame(s);
		
		System.out.println(g.toString());
		System.out.println(d.toString());
		System.out.println("Both games have the same name: " + d.compareName(g.getName()));
		System.out.println("Compare test game to monopoly, 1 for goes after, 0 for same, -1 for goes before: " + g.compareTo(d));
		
		
		
		
		s.close();
		
	}// Ending bracket of method main
	
}// Ending bracket of class GameDriver
