package competition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import competitor.Competitor;
import exception.NumberInsufisant;
import selection.Selection;
import selection.TopOfGroup;

public class TestMaster extends TestCompetition {

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
		
		return new Master(competitors, new TopOfGroup(), 2);
	}
	
	@Test
	public void testGetNbOfPools() {
		
		int nbPools = 2;
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Master master = new Master(competitors, new TopOfGroup(), nbPools);
		
		assertEquals(master.getNbOfPools(), nbPools);
		
	}
	
	@Test
	public void testGetLeagues() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Master master = new Master(competitors, new TopOfGroup(), 2);
		
		ArrayList<League> leagues = new ArrayList<League>();
		
		assertEquals(master.getLeagues(), leagues);
		
	}
	
	@Test
	public void testGetTournament() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Master master = new Master(competitors, new TopOfGroup(), 2);
		
		Tournament t = new Tournament(null);
		
		assertEquals(master.getTournament().getCompetitors(), t.getCompetitors());
		
	}
	
	@Test
	public void testSetTournament() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Master master = new Master(competitors, new TopOfGroup(), 2);
		
		Tournament t = new Tournament(competitors);
		
		master.setTournament(t);
		
		assertSame(master.getTournament(), t);
		
	}
	
	@Test
	public void testGetSelection() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Selection select = new TopOfGroup();
		
		Master master = new Master(competitors, select, 2);
		
		assertSame(master.getSelection(), select);
		
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
		
		Master master = new Master(competitors, new TopOfGroup(), 2);
		
		try {
			master.verification();
		}
		catch (NumberInsufisant e) {
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
		
		Master master = new Master(competitors, new TopOfGroup(), 2);
		
		assertThrows(NumberInsufisant.class, () -> { master.verification(); });
		
	}
	
	@Test
	public void testFillsTheRankingMap() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		c4.addPoints();
		c4.addPoints();
		c4.addPoints();
		c2.addPoints();
		c2.addPoints();
		c1.addPoints();
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Master master = new Master(competitors, new TopOfGroup(), 2);
		
		League league = new League(competitors);
		
		Map<Competitor, Integer> ranking = new LinkedHashMap<Competitor, Integer>();
		
		master.fillsTheRankingMap(ranking, league);
		
		assertEquals((int) ranking.get(c4), 1);
		assertEquals((int) ranking.get(c2), 2);
		assertEquals((int) ranking.get(c1), 3);
		assertEquals((int) ranking.get(c3), 4);
		
	}
	
	@Test
	public void testOrganiseMatches() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		Competitor c4 = new Competitor("Joseph");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Master master = new Master(competitors, new TopOfGroup(), 2);
		
		master.organiseMatches(competitors);
			
		assertEquals(master.getLeagues().size(), master.getNbOfPools());
		
	}
	
	@Test
	public void testDescription() {
		
		Competitor c1 = new Competitor("John");
		Competitor c2 = new Competitor("Johnny");
		Competitor c3 = new Competitor("Johnatan");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		
		Master master = new Master(competitors, new TopOfGroup(), 2);
		
		assertEquals(master.description(), "Master");
		
	}
}
