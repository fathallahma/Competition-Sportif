package selection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competitor.Competitor;

public class TestUtil {
	
	@Test
	public void testInitializeListCompetitors() {
		
		Util.competitors = null;
		
		List<Competitor> emptyList = new ArrayList<Competitor>();
		
		Util.initialiseListCompetitors();
		assertEquals(Util.competitors, emptyList);
		
	}
	
	@Test
	public void testCreateCompetitors() {
		
		Util.competitors = null;
		
		int ncompetitors = 10;
		
		Util.createCompetitors(ncompetitors);
		assertEquals(Util.competitors.size(), ncompetitors);
		
	}
	
	@Test
	public void testDividers() {
		
		int ncompetitors = 32;
		
		List<Integer> dividers = new ArrayList<Integer>();
		
		dividers.add(2);
		dividers.add(4);
		dividers.add(8);
		dividers.add(16);
		
		List<Integer> res = Util.dividers(ncompetitors);
		
		assertEquals(dividers, res);
	}
	
	@Test
	public void testIsPowerOfTwo() {
		
		int n1 = 0;
		int n2 = 511;
		int n3 = 512;
		int n4 = 513;
		int n5 = 1024;
		
		assertFalse(Util.isPowerOfTwo(n1));
		assertFalse(Util.isPowerOfTwo(n2));
		assertTrue(Util.isPowerOfTwo(n3));
		assertFalse(Util.isPowerOfTwo(n4));
		assertTrue(Util.isPowerOfTwo(n5));
		
	}
}
