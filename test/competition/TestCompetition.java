package competition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import competitor.Competitor;
import match.Match;
import match.MatchRandom;
import observer.BookMaker;

public abstract class TestCompetition {
	
	protected Competition myCompetition;
	
	protected abstract Competition createCompetition();
	
	@BeforeEach
	public void init() {
		this.myCompetition = this.createCompetition();
	}
	
	@Test
	public void testGetCompetitors() {
		
		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertSame(competition.getCompetitors(), competitors);
		
	}
	
	@Test
	public void testSetCompetitors() {

		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		ArrayList<Competitor> newcompetitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertSame(competition.getCompetitors(), competitors);
		
		competition.setCompetitors(newcompetitors);
		
		assertSame(competition.getCompetitors(), newcompetitors);
		
	}
	
	@Test
	public void testGetMatch() {

		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertSame(competition.getMatch(), match);
		
	}
	
	@Test
	public void testGetSetOfMatches() {
		
		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		Set<Match> matches = new HashSet<Match>();
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertEquals(competition.getSetOfMatches(), matches);
		
	}
	
	@Test
	public void testGetThePlayedMatchs() {
		
		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		ArrayList<Match> playedMatches = new ArrayList<Match>();
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertEquals(competition.getThePlayedMatchs(), playedMatches);
		
	}
	
	@Test
	public void testAddCompetitor() {
		
		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		Competitor c3 = new Competitor("Jean");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertFalse(competitors.contains(c3));
		competition.addCompetitor(c3);
		assertTrue(competitors.contains(c3));
		
	}
	
	@Test
	public void testAddCompetitionListener() {
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Andreas");
		
		competitors.add(c2);
		competitors.add(c1);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		BookMaker compListener1 = new BookMaker();
		BookMaker compListener2 = new BookMaker();
		
		assertTrue(competition.getCompetitionObservers().isEmpty());
		
		competition.addCompetitionListener(compListener1);
		assertEquals(competition.getCompetitionObservers().size(), 1);
		
		competition.addCompetitionListener(compListener1);
		assertEquals(competition.getCompetitionObservers().size(), 1);
		
		competition.addCompetitionListener(compListener2);
		assertEquals(competition.getCompetitionObservers().size(), 2);
	}
	
	@Test
	public void testRemoveCompetitionListener() {
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Andreas");
		
		competitors.add(c2);
		competitors.add(c1);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		BookMaker compListener1 = new BookMaker();
		BookMaker compListener2 = new BookMaker();
		
		competition.addCompetitionListener(compListener1);
		competition.addCompetitionListener(compListener2);
		
		assertEquals(competition.getCompetitionObservers().size(), 2);
		
		competition.removeCompetitionListener(compListener1);
		assertEquals(competition.getCompetitionObservers().size(), 1);
		
		competition.removeCompetitionListener(compListener1);
		assertEquals(competition.getCompetitionObservers().size(), 1);
		
		competition.removeCompetitionListener(compListener2);
		assertEquals(competition.getCompetitionObservers().size(), 0);
	}
	
	@Test
	public void testOrganiseMatches() {
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Andreas");
		
		competitors.add(c2);
		competitors.add(c1);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		competition.organiseMatches(competitors);
		
		Match[] organizedMatches = {new MatchRandom(c1, c2), new MatchRandom(c2,c1)};
		Match[] res = competition.getSetOfMatches().toArray(new Match[0]);
		
		assertEquals(organizedMatches.length, res.length);
		assertEquals(organizedMatches.length, 2);
	}
	
	@Test
	public void testPlay1() {
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Andreas");
		
		competitors.add(c2);
		competitors.add(c1);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		competition.organiseMatches(competitors);
		competition.play(competitors);
		
		assertEquals(competition.getSetOfMatches().size(), competition.getThePlayedMatchs().size());
		assertEquals(competition.getSetOfMatches().size(), 2);
	}
	
	@Test
	public void testPlay2() {
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Andreas");
		
		competitors.add(c2);
		competitors.add(c1);
		
		int len = competitors.size();
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertEquals(competition.getSetOfMatches().size(), competition.getThePlayedMatchs().size());
		assertEquals(competition.getSetOfMatches().size(), 0);
		
		competition.play();
		
		assertEquals(competition.getSetOfMatches().size(), competition.getThePlayedMatchs().size());
		assertEquals(competition.getThePlayedMatchs().size(), len*(len - 1));
	}
	
	@Test
	public void testPlayMatch() {
		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertEquals(competition.getMatch().isPlayed(), false);
		
		competition.playMatch(c1, c2);
		
		assertEquals(competition.getMatch().isPlayed(), true);
		assertEquals(c1.getNbPoints() + c2.getNbPoints(), 1);
	}
	
	@Test
	public void testDescription() {
		
		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertEquals(competition.description(), "The MockCompetition has the following participants: " + competitors);
	}
	
	@Test
	public void testResultListCompetitors() {
		
		Competitor c1 = new Competitor("Henri");
		Competitor c2 = new Competitor("Kévin");
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		Map<Competitor, Integer> scores = new LinkedHashMap<Competitor, Integer>();
		
		scores.put(c1, c1.getNbPoints());
		scores.put(c2, c2.getNbPoints());
		
		competitors.add(c1);
		competitors.add(c2);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		assertEquals(scores, competition.resultList());
		
	}
	
	@Test
	public void testRanking() {
		
		ArrayList<Competitor> competitors = new ArrayList<Competitor>();
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Andreas");
		Competitor c3 = new Competitor("Johnny");
		Competitor c4 = new Competitor("Jotaro");
		
		competitors.add(c4);
		competitors.add(c3);
		competitors.add(c2);
		competitors.add(c1);
		
		MatchRandom match = new MatchRandom(c1, c2);
		
		MockCompetition competition = new MockCompetition(competitors, match);
		
		c4.addPoints();
		c4.addPoints();
		c4.addPoints();
		c3.addPoints();
		c3.addPoints();
		c2.addPoints();
		
		Map<Competitor, Integer> ladder = competition.ranking();
		
		Competitor[] order = ladder.keySet().toArray(new Competitor[0]);
		
		assertSame(order[0], c4);
		assertSame(order[1], c3);
		assertSame(order[2], c2);
		assertSame(order[3], c1);
		
	}
	
	/* --------------------------------------------------------------------------------------------------------------------------------- */
	
	private class MockCompetition extends Competition {
		
		MockCompetition(List<Competitor> competitors) {
			super(competitors);
		}
		
		MockCompetition(List<Competitor> competitors, Match match) {
			super(competitors, match);
		}

		@Override
		protected void organiseMatches(List<Competitor> competitors) {
			
			List<Competitor> listCompetitors = new ArrayList<Competitor>();
			
			listCompetitors.addAll(competitors);
			for (Competitor c1 : listCompetitors) {
				for (Competitor c2 : listCompetitors) {
					if (c1 != c2) {
						this.setMatches.add(new MatchRandom(c1, c2));
					}
				}
			}
			
		}

		@Override
		protected void play(List<Competitor> competitors) {
			for (Match m : this.setMatches) {
				this.playMatch(m.getC1(), m.getC2());
				this.thePlayedMatchs.add(m);
			}
			
		}

		@Override
		protected String description() {
			return "The MockCompetition has the following participants: " + competitors;
		}
		
	}
}