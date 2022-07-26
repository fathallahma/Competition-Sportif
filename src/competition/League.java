package competition;

import java.util.Collections; 
import java.util.List;
import java.util.ArrayList;

import competitor.Competitor;
import match.Match;

public class League extends Competition{

    /**
     * create a league between the competitors
     * @param competitors the list of competitors
     */
	public League(List<Competitor> competitors) {
		super(competitors);
	}		

    /**
     * create a league in a specific match
     * @param competitors the list of competitors
     * @param match the match choose
     */
    public League(List<Competitor> competitors, Match match) {
		super(competitors, match);
	}

    /**
     * organize the matches
     * @param competitors list of competitors
     */
    @Override
    protected void organiseMatches(List<Competitor> competitors) {
		List<Competitor> competitorslist = new ArrayList<Competitor>();
		competitorslist.addAll(competitors);
		Collections.shuffle(competitorslist);
		Match m = this.match;
		Match thisMatch = null;
		for(Competitor c1 : competitorslist){
			for(Competitor c2 : competitorslist){
				if(!c1.equals(c2)){
					m.setC1(c1);
					m.setC2(c2);
					try {
						thisMatch = (Match) m.clone();
					}
					catch (CloneNotSupportedException e) {
						
					}
					this.setMatches.add(thisMatch);
				}
			}
		}
    }
    
    /**
     * plays the league between a list of competitors
     * @param competitors the list of competitors that will play
     */
    @Override
    protected void play(List<Competitor> competitors) {
    	for (Match m : this.setMatches) {
			this.match.setC1(m.getC1());
			this.match.setC2(m.getC2());
			playMatch(this.match.getC1(),this.match.getC2());
			if(this.match.isPlayed()) {
				Match matchCloned = cloneMatch(this.match.getC1(),this.match.getC2());
				thePlayedMatchs.add(matchCloned);
			}		
		}
	}
 
    /**
     * returns description of the league
     * @return description of the league
     */
    protected String description() {
		return "League";
	}

    /**
     * description needed
     * @return description needed
     */
    public String toString() {
    	return "League, competitors = " + competitors;
	}


    
}
