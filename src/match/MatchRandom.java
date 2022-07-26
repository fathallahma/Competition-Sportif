package match;

import competitor.Competitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MatchRandom extends Match{

    /**
	 * create a random match
	 */
    public MatchRandom(){
        super() ;
    }

    /**
	 * create a random match with two competitors
	 * @param c1 first competitor
	 * @param c2 second competitor
	 */
	public MatchRandom(Competitor c1, Competitor c2) {
		super(c1, c2) ;
		
    }

    /**
     * get a random integer
     * @param sup the sup of integers chosen
     * @return a number
     */
    public int getRandomInt(int sup) {
		Random r = new Random();
		return r.nextInt(2);
	}

    /**
	 * return the winner of the match
	 * @param c1 first competitor
	 * @param c2 second competitor
	 * @return the winner of the match
	 */
    protected Competitor winnerOfMatch(Competitor c1, Competitor c2){
        List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(c1);
		competitors.add(c2);
		int pos = getRandomInt(1);
		return competitors.get(pos);
    }
    
}
