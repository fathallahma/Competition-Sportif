package match;

import competitor.Competitor;

public class TestMatchRandom extends TestMatch {
	
	@Override
	protected Match createMatch() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Jack");
		
		return new MatchRandom(c1, c2);
	}

}
