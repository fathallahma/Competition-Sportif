package observer;

import competition.Competition;
import match.Match;

/** A journalist gets the results of the matches and displays them*/
public class Journalist implements CompetitionListener {
	
	/** displays the result of all the matches
	 * @param c the competition event*/
	public void competitionPlayed(CompetitionEvent c) {
		Competition competition = (Competition) c.getSource();
		System.out.println("\n-------------");
		System.out.println("LES RÉSULTATS DES MATCHS PUBLIÉS PAR LE JOURNALISTE");
		System.out.println("\n-------------");
		for (Match m : competition.getThePlayedMatchs()) {
			m.displayResult(m.getC1(), m.getC2());
		}
	}

}