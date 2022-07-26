package util;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class TestMapUtil {
	
	@Test
	public void testSortByDescendingValue() {
		
		Map<String, Integer> scores = new LinkedHashMap<String, Integer>();
		Map<String, Integer> scoresSorted = new LinkedHashMap<String, Integer>();
		
		scores.put("Andreas", 2);
		scores.put("Ricardo", 3);
		scores.put("Jean", 0);
		scores.put("Johnny", 2);
		
		scoresSorted.put("Ricardo", 3);
		scoresSorted.put("Andreas", 2);
		scoresSorted.put("Johnny", 2);
		scoresSorted.put("Jean", 0);
		
		scores = MapUtil.sortByDescendingValue(scores);
		
		assertEquals(scores, scoresSorted);
		
	}
}
