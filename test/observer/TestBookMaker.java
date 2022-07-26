package observer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import competition.League;
import competitor.Competitor;


public class TestBookMaker {

	
	@Test
	public void testCompetitionPlayed() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnson");
		Competitor c3 = new Competitor("Jackson");
		Competitor c4 = new Competitor("Joseph");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		League league = new League(competitors);
		CompetitionEvent leagueEvent = new CompetitionEvent(league);
		
		BookMaker book = new BookMaker();
		
		assertEquals(book.getTheCompetitorsOdds().isEmpty(), true);
		
		book.competitionPlayed(leagueEvent);
		
		assertEquals(book.getTheCompetitorsOdds().get(c1), (Integer) 1);
		assertEquals(book.getTheCompetitorsOdds().get(c2), (Integer) 1);
		assertEquals(book.getTheCompetitorsOdds().get(c3), (Integer) 1);
		assertEquals(book.getTheCompetitorsOdds().get(c4), (Integer) 1);
		
	}
	
}
