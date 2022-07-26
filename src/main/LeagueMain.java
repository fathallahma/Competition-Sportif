package main; 

import competition.* ; 
import selection.TopOfGroup;
import selection.Util;

public class LeagueMain {
	
	public static void main(String[] args) {
			
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
			System.out.println("\t START OF THE League ! \n");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
			
			Util.initialiseListCompetitors();
			Util.createCompetitors(16);
			
			Competition league = new League(Util.competitors);

			league.play();
			league.ranking();
			
			Util.displayCompetitors();
			
		}
	
	

}
