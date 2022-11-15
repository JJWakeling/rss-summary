package rss_summary.test;

import org.junit.Test;
import org.junit.Assert;
import java.util.Set;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import rss_summary.main.*;

public class StringSentenceTest {

	@Test
	public void testPhraseCounting() {
		Set<Map.Entry<Phrase, Integer>> actualSubsequences = 
			new StringSentence("we'll weather the weather whatever the weather")
				.subPhrases()
				.table()
				.entrySet();
		Assert.assertEquals(
			actualSubsequences,
			new HashSet<Map.Entry<Phrase,Integer>>(
				Arrays.asList(
					uniquePhrase("we'll"),
					phraseCount("weather", 3),
					phraseCount("the", 2),
					uniquePhrase("whatever"),
					uniquePhrase("we'll weather"),
					uniquePhrase("weather the"),
					phraseCount("the weather", 2),
					uniquePhrase("weather whatever"),
					uniquePhrase("whatever the"),
					uniquePhrase("we'll weather the"),
					uniquePhrase("weather the weather"),
					uniquePhrase("the weather whatever"),
					uniquePhrase("weather whatever the"),
					uniquePhrase("whatever the weather"),
					uniquePhrase("we'll weather the weather"),
					uniquePhrase("weather the weather whatever"),
					uniquePhrase("the weather whatever the"),
					uniquePhrase("weather whatever the weather"),
					uniquePhrase("we'll weather the weather whatever"),
					uniquePhrase("weather the weather whatever the"),
					uniquePhrase("the weather whatever the weather"),
					uniquePhrase("we'll weather the weather whatever the"),
					uniquePhrase("weather the weather whatever the weather"),
					uniquePhrase("we'll weather the weather whatever the weather")					
				)
			)
		);
	}

	private Map.Entry<Phrase, Integer> phraseCount(String phrase, Integer count) {
		return new AbstractMap.SimpleImmutableEntry<Phrase, Integer>(
			new StringPhrase(phrase),
			count
		);
	}
	
	private Map.Entry<Phrase, Integer> uniquePhrase(String phrase) {
		return phraseCount(phrase, 1);
	}
}
