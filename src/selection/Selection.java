package selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import competitor.Competitor;

public interface Selection {
	
	
	/**
	 * get the possible number of groups
	 * @param competitors list of competitors
	 * @return the possible number of groups
	 */
	public List<Integer> possibleNbOfGroups(List<Competitor> competitors) ;
	
	/**
	 * return the number of groups
	 * @param competitors list of competitors
	 * @return the number of groups
	 */
	public int getNbOfGroups(List<Competitor> competitors);
	
	/**
	 * 
	 * @param ranking a map to rank competitors
	 * @param competitors list of competitors
	 * @param nbOfPools the number of pools
	 * @return list of competitors
	 */
	public  List<Competitor> getPlayersSecondRound(Map<Competitor, Integer> ranking, List<Competitor> competitors, int nbOfPools);
		
}
