package competitor;

public class Competitor {

	//name of competitors
    private String name;

	// number of points of competitor
	private int nbPoints;
	
	/**
	 * create a competitor
	 * @param name the name of the competitor
	 */
	public Competitor (String name) {
		this.name = name;
		this.nbPoints = 0;
	}

	/**
	 * get the name of the competitor
	 * @return the name of the competitor
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set a name to the competitor
	 * @param name the name chosen
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the points of the competitor
	 * @return number of points
	 */
	public int getNbPoints() {
		return nbPoints;
	}
	
	/**
	 * set points to the competitor
	 * @param nbPoints the number of points chosen
	 */
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	/**
	 * add a point to the competitor
	 */
	public void addPoints() {
		this.nbPoints++;
	}
	
	/**
	 * description
	 */
	public String toString() {
		return name;
	}
    
}
