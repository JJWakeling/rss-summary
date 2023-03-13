package rss_summary.test;

import java.util.AbstractMap;
import java.util.Map;
import rss_summary.main.*;

public class PhraseCount {
	private final String phrase;
	private final Integer count;

	public PhraseCount(String phrase, Integer count) {
		this.phrase = phrase;
		this.count = count;
	}
	
	public PhraseCount(String phrase) {
		this(phrase, 1);
	}
	
	public Map.Entry<Phrase, Integer> mapEntry() {
		return new AbstractMap.SimpleImmutableEntry<Phrase, Integer>(
			new StringPhrase(phrase),
			count
		);
	}
}
