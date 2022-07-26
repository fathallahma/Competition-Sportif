package main;

import competition.Competition;
import competition.League;
import competition.Tournament;
import selection.Util;

public class TournamentMain {
	
	public static void main(String[] args) {
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		System.out.println("\t START OF THE Tournamant ! \n");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		
		Util.initialiseListCompetitors();
		Util.createCompetitors(16);
		
		Competition Tournament = new Tournament(Util.competitors);

		Tournament.play();
		Tournament.ranking();
		
		Util.displayCompetitors();
		
	}

}
