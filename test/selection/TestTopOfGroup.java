package selection;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competitor.Competitor;

public class TestTopOfGroup {

	@Test
	public void testPossibleNbOfGroups() {
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		competitors.add(new Competitor("John"));
		competitors.add(new Competitor("Jean"));
		competitors.add(new Competitor("Johnny"));
		competitors.add(new Competitor("Joseph"));
		competitors.add(new Competitor("Johnathan"));
		competitors.add(new Competitor("Jotaro"));
		
		List<Integer> possibleGroups = new ArrayList<Integer>();
		
		possibleGroups.add(2);
		
		TopOfGroup t = new TopOfGroup();
		
		List<Integer> res = t.possibleNbOfGroups(competitors);
		
		assertEquals(possibleGroups, res);
		
	}
}
