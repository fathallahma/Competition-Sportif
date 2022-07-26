package competition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competitor.Competitor;
import exception.ErrorNumberParticipants;
import match.MatchRandom;

public class TestTournament extends TestCompetition {

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
		
		return new Tournament(competitors, new MatchRandom(c1, c2));
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
		
		Tournament tournament =  new Tournament(competitors);
		
		assertEquals(tournament.description(), "Tournament");
		
	}
	
	@Test
	public void testIsFinished() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Tournament tournament =  new Tournament(competitors);
		
		assertEquals(tournament.isFinished(), false);
		
	}
	
	@Test
	public void testSetItFinished() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Tournament tournament =  new Tournament(competitors);
		
		assertEquals(tournament.isFinished(), false);
		tournament.setItFinished();
		assertEquals(tournament.isFinished(), true);
		
	}
	
	@Test
	public void testGetWinner() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Tournament tournament =  new Tournament(competitors);
		
		assertEquals(tournament.getWinner(), null);
		
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
		
		Tournament tournament =  new Tournament(competitors);
		
		assertEquals(tournament.toString(), "Tournament, competitors = " + competitors);
		
	}
	
	@Test
	public void testVerificationOk() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Tournament tournament =  new Tournament(competitors);
		
		try {
			tournament.verification();
		}
		catch (ErrorNumberParticipants e) {
			fail();
		}
		
		assertEquals(competitors.size() % 2, 0);
		assertNotEquals(competitors.size(), 0);
		
	}
	
	@Test
	public void testVerificationError() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		
		Tournament tournament =  new Tournament(competitors);
		
		assertThrows(ErrorNumberParticipants.class, () -> { tournament.verification(); });
		
	}

}
