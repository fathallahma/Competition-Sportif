package selection;

import java.util.ArrayList; 
import java.util.List;
import java.util.Map;


import competitor.Competitor;

public class TopOfGroup implements Selection{
	
	/**
	 * get the possible number of groups
	 * @param competitors list of competitors
	 * @return the possible number of groups
	 */
	public List<Integer> possibleNbOfGroups(List<Competitor> competitors) {
		List<Integer> possibleNbOfGroups = new ArrayList<Integer>();
		List<Integer> dividers = Util.dividers(competitors.size());
        for( int i=0;i< dividers.size() ;i++){
            if (Util.isPowerOfTwo(dividers.get(i))) {
            	possibleNbOfGroups.add(dividers.get(i));
            }
        }
		return possibleNbOfGroups;
	}
	
	/**
	 * return the number of groups
	 * @param competitors list of competitors
	 * @return the number of groups
	 */
	public int getNbOfGroups(List<Competitor> competitors) {
		List<Integer> possibleNbOfGroups = possibleNbOfGroups(competitors);
        return Util.getRandomElementFromList(possibleNbOfGroups);
	}
	
	/**
	 * 
	 * @param ranking a map to rank competitors
	 * @param competitors list of competitors
	 * @param nbOfPools the number of pools
	 * @return list of competitors
	 */
	public List<Competitor> getPlayersSecondRound(Map<Competitor, Integer> ranking, List<Competitor> competitors, int nbOfPools) {
		List<Competitor> res = new ArrayList<Competitor>();
		for(Competitor c : ranking.keySet()) {
			if (ranking.get(c)==1) {
				res.add(c);
			}
		}
		return res; 
	}
}
