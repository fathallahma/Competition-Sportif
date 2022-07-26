package competition;

import java.util.ArrayList;

import java.util.List;
import competitor.Competitor;
import match.Match;
import exception.*;
import selection.Util;
import java.util.Random;
import java.util.Iterator;

public class Tournament extends Competition{

	//list of the winners
	private List<Competitor> listOfWinners;
	//verification if the tournament finished
	private boolean isFinished;
    // winner of the tournament 
    private Competitor winner;

    /**
     * create a tournament between the competitors
     * @param competitors the list of competitors
     */
    public Tournament(List<Competitor> competitors) {
		super(competitors);
		this.isFinished = false;
		this.listOfWinners = new ArrayList<Competitor>();	
		this.winner = null;
	}	

    /**
     * create a tournament in a specific match
     * @param competitors the list of competitors
     * @param match the match choose
     */
    public Tournament(List<Competitor> competitors, Match match) {
		super(competitors, match);
		this.listOfWinners = new ArrayList<Competitor>();	
		this.isFinished = false;
		this.winner = null;
	}

    /**
     * returns description of the Tournament
     * @return description of the Tournament
     */
    protected String description() {
		return "Tournament";
	}
    
    /**
     * verification if the tournament is finished
     * @return a boolean if the tournament is finished
     */
    public boolean isFinished() {
		return isFinished;
	}

    /**
     * make the tournament finished
     */
    public void setItFinished() {
		this.isFinished = true;
	}
    
    /**
     * returns the winner
     * @return the winner
     */
    public Competitor getWinner() {
		return winner;
	}

    /**
     * description needed
     * @return description needed
     */
    public String toString() {
    	return "Tournament, competitors = " + competitors;
	}
    
    /**
     * verification of size of competitors if it's power of two
     * @throws ErrorNumberParticipants of it's not power of two
     */
    public void verification() throws ErrorNumberParticipants{
		int numberOfCompetitors = super.competitors.size();
		if(numberOfCompetitors != 0) {
			if(! Util.isPowerOfTwo(numberOfCompetitors)) {
				throw new ErrorNumberParticipants();
			}
		}	
	}
    
    /**
     * choose two competitor randomly in the list of competitors
     * @param competitors the list of competitors
     * @return the two competitors chosen
     */
    public Match matchBetweenTwoCompetitorsRandom(List<Competitor> competitors) {
		Random r = new Random();
		
		Competitor c1 = competitors.get(r.nextInt(competitors.size()));
		competitors.remove(c1);
		
		Competitor c2 = competitors.get(r.nextInt(competitors.size()));
		competitors.remove(c2);
		
		Match m = this.match;
		m.setC1(c1);
		m.setC2(c2);
		
		Match thisMatch = null;
		try {
			thisMatch = (Match) m.clone();
		} catch(CloneNotSupportedException e){}
	
		return thisMatch;
	}
    
    /**
     * organize the matches
     * @param competitors list of competitors
     */
    protected void organiseMatches(List<Competitor> competitors) {
		try {
			verification();
			List<Competitor> competitorslist = new ArrayList<Competitor>();
			this.setMatches.clear();
			competitorslist.addAll(competitors);
			int nbOfMatchs = (competitors.size())/2;
			for(int i = 0; i < nbOfMatchs; i++) {
				Match matchBetweenTwoCompetitorsRandom = matchBetweenTwoCompetitorsRandom(competitorslist);
				this.setMatches.add(matchBetweenTwoCompetitorsRandom);		
			}
			
		} catch (ErrorNumberParticipants e) {
			System.out.println("number of competitors should be power of two");
			System.exit(0);
		}
	}
    
    /**
     * plays the tournament between a list of competitors
     * @param competitors the list of competitors that will play
     */
    protected void play(List<Competitor> competitors) {
    	
		int tour = 0;
		Iterator<Match> currentRoundIterator = this.setMatches.iterator();
		
		while(!isFinished){
			
			System.out.println("Round " + (tour+1));
			
			while (currentRoundIterator.hasNext()){
				Match m = (Match) currentRoundIterator.next();
				this.match.setC1(m.getC1());
				this.match.setC2(m.getC2());
				playMatch(this.match.getC1(), this.match.getC2());
				if(this.match.isPlayed()) {
					Match matchCloned = cloneMatch(this.match.getC1(),this.match.getC2());
					thePlayedMatchs.add(matchCloned);
				}
				listOfWinners.add(this.match.getWinner());	
			}
			// s'il y a un seul matche
			if (this.setMatches.size() == 1) {
				this.winner = listOfWinners.get(0);
				this.isFinished = true;			
			}
			
			// verification du bon nombre de competiteurs
			organiseMatches(listOfWinners);
			listOfWinners.clear();
			currentRoundIterator = this.setMatches.iterator();
			tour++; 
		}
		 
		System.out.println("\n\t\t\t The end of the tournament ! \n");
		System.out.println("\t\t winner is ===>" + this.winner + "! \n");
		}
    
    
}
