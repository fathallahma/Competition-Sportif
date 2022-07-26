package match;

import competitor.Competitor;

public abstract class Match implements Cloneable{
	//the first competitor
    protected Competitor c1;

	//the second competitor
	protected Competitor c2;

	//the winner
	protected Competitor winner;

	//verification if the match is played or not
	protected boolean isPlayed;
	
	/**
	 * create a match
	 */
    public Match(){
	};
	
	/**
	 * create a match with two competitors
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	public Match(Competitor c1, Competitor c2) {
		this.c1 = c1;
		this.c2 = c2;
		this.winner = null;
		this.isPlayed = false;
    }

	

	/**
	 * get the first competitor
	 * @return the first competitor
	 */
	public Competitor getC1() {
		return this.c1;
	}

	/**
	 * set a competitor like the first
	 * @param c1 the competitor chosen
	 */
	public void setC1(Competitor c1) {
		this.c1 = c1;
	}

	/**
	 * get the second competitor
	 * @return the second competitor
	 */
	public Competitor getC2() {
		return this.c2;
	}
	
	/**
	 * set a competitor like the second
	 * @param c2 the competitor chosen
	 */
	public void setC2(Competitor c2) {
		this.c2 = c2;
	}

	/**
	 * verification if the match is played
	 * @return true if the match is played
	 */
	public boolean isPlayed() {
		return isPlayed;
	}

	/**
	 * get the winner
	 * @return the winner
	 * @throws IllegalStateException if the match is not played yet
	 */
	public Competitor getWinner() throws IllegalStateException{
		if(this.isPlayed)
			return winner;
		else {
			throw new IllegalStateException("The match is not played yet !, there is no winner for the moment.");
		}
	}

	/**
	 * display the result 
	 * @param c1 first competitor
	 * @param c2 second competitor
	 */
	public void displayResult(Competitor c1, Competitor c2) {
		System.out.println(c1.getName() + "\tvs\t" + c2.getName() + "\t-->\t" + this.winner + "\twins!");
	}

	/**
	 * return the winner of the match
	 * @param c1 first competitor
	 * @param c2 second competitor
	 * @return the winner of the match
	 */
	protected abstract Competitor winnerOfMatch(Competitor c1, Competitor c2);

	/**
	 * play match between two competitors
	 * @param c1 first competitor
	 * @param c2 second competitor
	 */
	public void playAMatch(Competitor c1, Competitor c2) {
		Competitor winner = this.winnerOfMatch(c1, c2) ; 
		this.isPlayed = true ;
		this.winner = winner;
		displayResult(c1, c2);
	} 
	
	/**
	 * @throws CloneNotSupportedException 
	 * return an object of match created
	 */
	public Object clone() throws CloneNotSupportedException {
		Match monClone = (Match) super.clone();
		return monClone;
	}
	
	/**
	 * Compare a match object and an object
	 *
	 * @param obj the object to compare with the Match
	 * return - true if both matches represents the same match
	 *        - false if obj is not a instance of match or both matches represent different matches
	 *
	 */
	public boolean equals(Object obj) {
		
		if (obj instanceof Match) {
			
			Match castObject = (Match) obj;
			boolean sameOpponents = (this.getC1() == castObject.getC1()) && (this.getC2() == castObject.getC2());
			
			if (this.isPlayed() == castObject.isPlayed()) {
				
				if (this.isPlayed() == false) {
					return sameOpponents;
				}
				else {
					return sameOpponents && (this.getWinner() == castObject.getWinner());
				}
				
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
	}
	
	
}
