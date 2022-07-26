package competition;

import java.util.ArrayList;    
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competitor.Competitor;
import match.Match;
import selection.*;
import exception.NumberInsufisant;
import exception.ErrorNumberParticipants;
 

 

public class Master extends Competition{
	 
	// leagues played in the first part
	protected List<League> leagues;
	// tournament played in the second part
	protected Tournament tournament; 
	// number of pools
	protected int nbOfPools;
	//the mode of selection in the pool
	protected Selection selection;

	/**
     * create a master between the competitors in a specific number of pool chosen
     * @param competitors the list of competitors
     * @param selection the type of selection to the second phase
     * @param nbPool number of pools chosen
     */
	public Master(List<Competitor> competitors, Selection selection, int nbPool) {
		super(competitors) ;
		this.tournament = new Tournament(null);
		this.leagues = new ArrayList<League>();
		this.nbOfPools = nbPool;
		this.selection = selection;
	}
	
	/**
     * create a master between the competitors 
     * @param competitors the list of competitors
     * @param selection the type of selection to the second phase
     */
	public Master(List<Competitor> competitors, Selection selection) {
		super(competitors);
		this.selection = selection;	
		this.nbOfPools = selection.getNbOfGroups(competitors);
		this.leagues = new ArrayList<League>();
		this.tournament = new Tournament(null);
	}
	
	/**
	 * return the number of pools
	 * @return the number of pools
	 */
	public int getNbOfPools() {
		return nbOfPools;
	}
	
	/**
	 * return the leagues of the master
	 * @return the leagues of the master
	 */
	public List<League> getLeagues() {
		return leagues;
	}
	
	/**
	 * return the tournament
	 * @return the tournament
	 */
	public Tournament getTournament() {
		return tournament;
	}
	
	/**
	 * set a tournament
	 * @param tournament the tournament chosen
	 */
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	/**
	 * return the selection chosen
	 * @return the selection chosen
	 */
	public Selection getSelection() {
		return selection;
	}
	
    /** 
     * Verifies if the number of the competitors is even
	 * @throws NumberInsufisant when the number of competitors is not even
	 * */
    public void verification()throws NumberInsufisant{
		if (super.competitors.size() % 2 != 0) {
			throw new NumberInsufisant();
		}	
	}
    
    /** 
     * fills the played Matches with the played Matches of the leagues and the tournament of the master
	 */
    public void fillsThePlayedMatches() {
		for(League l : leagues) {
			List<Match> leagueMatchs = l.getThePlayedMatchs();
			for (Match m : leagueMatchs) {
				this.thePlayedMatchs.add(m);
			}
		}
		List<Match> tournamentMatchs = this.tournament.getThePlayedMatchs();
		for (Match m : tournamentMatchs) {
			this.thePlayedMatchs.add(m);
		}
	}
    
    /**
     * description of pools 
     * @param i the number of the pool
     * @param c the league
     */
    private void poulDescription(int i, League c) {
		System.out.println("\n------------------------------\n");
		System.out.println(" --> Groupe "+i+" : " +c);
		System.out.println("--------------------------------\n");
	}
    
    /**
     * description
     * @param i the first or second phase
     */
    private void phaseOneDescription(int i) {
		System.out.println("\n");
		System.out.println("\t\t\t Phase " + i + " START");
		System.out.println("\n");
	}
    
    /** 
     * fills the ranking map with all the competitors and their ranking
	 * @param map an empty map which will contain the rankings of each of the competitors.
	 * @param league a League to play
	 */
    public void fillsTheRankingMap(Map<Competitor, Integer> map, League league) {
		Map<Competitor, Integer> leagueRanking = league.ranking();
		int i = 0;
		for(Competitor k : leagueRanking.keySet()) {
			i++;
			map.put(k, i);
		}
	}
    
    /**
     * description 
     */
    private void tournamentDescription() {
		System.out.println("\n-----------------------------------------------\n");
		System.out.println(" -> " + tournament);
		System.out.println("\n-----------------------------------------------\n");
	}
    
    /**
     * description
     */
    private void masterFinishedDescription() {
		System.out.println("\n-----------------------------------------------\n");
		System.out.println("\t\t\t End Of the Master ");
		System.out.println("\\n-----------------------------------------------\\n");
	}
    
    /** 
     * plays the master between a list of competitors
	 * @param competitors the list of the competitors
	 * */
    @Override
    protected void play(List<Competitor> competitors) {
		Map < Competitor , Integer> map = new HashMap< Competitor, Integer>();
		int i = 1;
		
		this.phaseOneDescription(1);
		
		for(League c : leagues) {
			this.poulDescription(i, c);
			c.play();
			fillsTheRankingMap(map, c);
			i++;
		}
		
		this.phaseOneDescription(2);
		this.tournament.setCompetitors(selection.getPlayersSecondRound(map, competitors, this.nbOfPools));
		this.tournamentDescription();
		tournament.play();	
		tournament.ranking();
		this.masterFinishedDescription();
	}

    /**
     * get the groups of competitors
     * @param competitors the competitors
     * @return the groups of competitors
     */
    public List<List<Competitor>> getGroups(List<Competitor> competitors) {
		Collections.shuffle(competitors);
		List<Competitor> competitorsOfEachGroup = new ArrayList<Competitor>();
		List<List<Competitor>> listOfGroups = new ArrayList<List<Competitor>>();
		int nbCompetitorsByGroup = competitors.size() / this.nbOfPools;
		int indexCompetitor = 0;
		for(int i = 0 ; i < this.nbOfPools ; i++) {
			for (int j = 0; j < nbCompetitorsByGroup; j++ ) {	
				competitorsOfEachGroup.add(competitors.get(indexCompetitor));
				indexCompetitor ++;
			}
			listOfGroups.add(competitorsOfEachGroup);
			competitorsOfEachGroup = new ArrayList<Competitor>();
		}
		return listOfGroups;
		
	}
    
    /**
     * organize the matches
     * @param competitors list of competitors
     */
    protected void organiseMatches(List<Competitor> competitors) {
		try {
			verification();
			List<List<Competitor>> groups = getGroups(competitors);
			for(int i = 0 ; i < nbOfPools; i++) {
				this.leagues.add(new League(groups.get(i)));
			}
			
		}
		catch (NumberInsufisant e) {
			System.out.println("correct the number of Competitors !!");
		}		
	}
    
	/**
     * returns description of the master
     * @return description of the master
     */
    protected String description() {
		return "Master";
	}
}