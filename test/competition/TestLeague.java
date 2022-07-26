package competition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competitor.Competitor;
import match.MatchRandom;

public class TestLeague extends TestCompetition {
	
	@Override
	protected Competition createCompetition() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		return new League(competitors, new MatchRandom(c1, c2));
	}
	
	@Test
	public void testPlay() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		int len = competitors.size();
		
		League league = new League(competitors, new MatchRandom(c1, c2));
		
		assertEquals(league.getThePlayedMatchs().size(), 0);
		
		league.organiseMatches(competitors);
		league.play(competitors);
		
		assertEquals(league.getThePlayedMatchs().size(), len*(len - 1));
	}
	
	@Test
	public void testDescription() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		League league = new League(competitors, new MatchRandom(c1, c2));
		
		assertEquals(league.description(), "League");
		
	}
	
	@Test
	public void testToString() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		League league = new League(competitors, new MatchRandom(c1, c2));
		
		assertEquals(league.toString(), "League, competitors = " + competitors);
		
	}
	
}
