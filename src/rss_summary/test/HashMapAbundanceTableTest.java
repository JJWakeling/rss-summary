package rss_summary.test;

import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import rss_summary.main.*;
import rss_summary.test.helpers.PhraseCount;

public class HashMapAbundanceTableTest {

	@Test
	public void testSum() {
		AbundanceTable tableA = new HashMapAbundanceTable();
		AbundanceTable tableB = new HashMapAbundanceTable();
		
		addPhrase(tableA, "a");
		addPhrase(tableA, "man");
		addPhrase(tableA, "a");
		addPhrase(tableA, "plan");
		addPhrase(tableA, "a");
		addPhrase(tableA, "canal");
		
		addPhrase(tableB, "a");
		addPhrase(tableB, "man");
		addPhrase(tableB, "in");
		addPhrase(tableB, "a");
		addPhrase(tableB, "canal");
		
		Assert.assertEquals(
			new HashSet<Map.Entry<Phrase, Integer>>(
				Arrays.asList(
					new PhraseCount("a", 5).mapEntry(),
					new PhraseCount("man", 2).mapEntry(),
					new PhraseCount("plan").mapEntry(),
					new PhraseCount("canal", 2).mapEntry(),
					new PhraseCount("in").mapEntry()
				)
			),
			tableA
				.sum(tableB)
				.table()
				.entrySet()
		);
	}
	
	private void addPhrase(AbundanceTable table, String phrase) {
		table.add(new StringPhrase(phrase));
	}
}
