package edu.mtc.egr283.project04;

public class GameDriver {

	public static void main(String[] args) {
		
		Game g = new Game();
		Game d = new Game();
		
		d.setName("Apples To Apples");
		
		g.setName("Monopoly");
		g.setMinAge(1);
		g.setMaxAge(10);
		g.setMinPlayTime(5);
		g.setMaxPlayTime(60);
		g.setMinPlayers(2);
		g.setMaxPlayers(4);
		
		System.out.println(g.toString());
		System.out.println(d.compareName(g.getName()));
		System.out.println(g.compareTo(d));
	}// Ending bracket of method main
	
}// Ending bracket of class GameDriver
