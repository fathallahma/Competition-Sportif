package competitor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCompetitor {
	
	@Test 
	public void testGetName() {
		
		Competitor c1 = new Competitor("Andreas");
		assertEquals(c1.getName(), "Andreas");
		
	}
	
	@Test
	public void testSetName() {
		
		Competitor c1 = new Competitor("Andreas");
		
		assertEquals(c1.getName(), "Andreas");
		c1.setName("Johnny");
		assertEquals(c1.getName(), "Johnny");
	}
	
	@Test
	public void testGetNbPoints() {
		
		Competitor c1 = new Competitor("Andreas");
		assertEquals(c1.getNbPoints(), 0);
		
	}
	
	@Test
	public void testSetNbPoints() {
		
		Competitor c1 = new Competitor("Andreas");
		
		assertEquals(c1.getNbPoints(), 0);
		c1.setNbPoints(3);
		assertEquals(c1.getNbPoints(), 3);
		
	}
	
	@Test
	public void testAddPoints() {
		
		Competitor c1 = new Competitor("Andreas");
		
		assertEquals(c1.getNbPoints(), 0);
		c1.addPoints();
		assertEquals(c1.getNbPoints(), 1);
		
	}
	
	@Test
	public void testToString() {
		
		Competitor c1 = new Competitor("Andreas");
		assertEquals(c1.getName(), "Andreas");
		
	}

}
