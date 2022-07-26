package main;

import competition.* ; 
import selection.TopOfGroup;
import selection.Util; 

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		System.out.println("\t START OF THE MASTER ! \n");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		
		Util.initialiseListCompetitors();
		Util.createCompetitors(16);
		
		Competition master = new Master(Util.competitors, new TopOfGroup(), 4);
		
		Util.displayCompetitors();

		master.play();
		master.ranking();
		
	}

}
