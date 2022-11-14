package rss_summary.main;

import java.util.Arrays;

public class WordSentence implements Sentence {

	private final String[] words;
	
	public WordSentence(String[] words) {
		this.words = words;
	}

	@Override
	public AbundanceTable subsequences() {
		AbundanceTable abundances = new HashMapAbundanceTable();
	
		for (int startIndex = 0; startIndex < words.length; startIndex++) {
			for (int length = 1; length <= words.length - startIndex; length++) {
				abundances.add(
					new StringPhrase(
						String.join(
							" ",
							Arrays.copyOfRange(words, startIndex, startIndex + length)
						)
					)
				);
			}
		}
		
		return abundances;
	}

}
