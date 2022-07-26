package match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import competitor.Competitor;

public abstract class TestMatch {
	
	protected Match myMatch;
	
	protected abstract Match createMatch();
	
	@BeforeEach
	public void init() {
		this.myMatch = this.createMatch();
	}
	
	@Test
	public void testGetC1() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		assertSame(match.getC1(), c1);
		
	}
	
	@Test
	public void testSetC1() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		Competitor c3 = new Competitor("Johnny");
		
		MockMatch match = new MockMatch(c1, c2);
		
		assertSame(match.getC1(), c1);
		match.setC1(c3);
		assertSame(match.getC1(), c3);
		
	}
	
	@Test
	public void testGetC2() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		assertSame(match.getC2(), c2);
		
	}
	
	@Test
	public void testSetC2() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		Competitor c3 = new Competitor("Johnny");
		
		MockMatch match = new MockMatch(c1, c2);
		
		assertSame(match.getC2(), c2);
		match.setC2(c3);
		assertSame(match.getC2(), c3);
		
	}
	
	@Test
	public void testIsPlayed() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		assertSame(match.isPlayed(), false);
		
	}
	
	@Test
	public void testgetWinnerOk() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		/* assertEquals(match.getWinner(), null); -> Exception */
		
		match.playAMatch(c1, c2);
		
		assertSame(match.getWinner(), c1);
		
	}
	
	@Test
	public void testgetWinnerError() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		assertThrows(IllegalStateException.class, () -> { match.getWinner(); });
		
	}
	
	@Test
	public void testDisplayResult() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		assertEquals(match.displayCalled, 0);
		
		match.displayResult(c1, c2);
		
		assertEquals(match.displayCalled, 1);
		
	}
	
	@Test
	public void testWinnerOfMatch() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		/* assertEquals(match.getWinner(), null); -> Exception */
		match.winnerOfMatch(c1, c2);
		assertEquals(match.getWinner(), c1);
		
	}
	
	@Test
	public void testPlayAMatch() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		assertEquals(match.isPlayed(), false);
		/* assertEquals(match.getWinner(), null); -> Exception */
		
		match.playAMatch(c1, c2);
		
		assertEquals(match.isPlayed(), true);
		assertSame(match.getWinner(), c1);
		
	}
	
	@Test
	public void testClone() {
		
		Competitor c1 = new Competitor("Johnatan");
		Competitor c2 = new Competitor("Joseph");
		
		MockMatch match = new MockMatch(c1, c2);
		
		try {
			MockMatch match2 = match.clone();
			assertEquals(match, match2);
			assertNotSame(match, match2);
		}
		catch (CloneNotSupportedException e){
			fail();
		}
		
	}
	
	/* --------------------------------------------------------------------------------------------------------------------------------- */
	
	private class MockMatch extends Match {
		
		// to track method displayResult calls
		public int displayCalled = 0;
		
		public MockMatch(Competitor c1, Competitor c2) {
			super(c1, c2);
		}
		
		@Override
		public Competitor winnerOfMatch(Competitor c1, Competitor c2) {
			this.isPlayed = true;
			this.winner = this.c1;
			return this.c1;
		}
		
		@Override
		public void displayResult(Competitor c1, Competitor c2) {
			super.displayResult(c1, c2);
			this.displayCalled++;
		}
		
		@Override
		public MockMatch clone() throws CloneNotSupportedException {
			MockMatch clone = (MockMatch) super.clone();
			return clone;
		}
	}
	
	
}