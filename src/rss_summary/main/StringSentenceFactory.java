package rss_summary.main;

import java.util.ArrayList;
import java.util.Collection;

public class StringSentenceFactory implements SentenceFactory {

	private final String text;

	public StringSentenceFactory(String text) {
		this.text = text;
	}

	@Override
	public Collection<Sentence> sentences() {
		String[] sentenceStrings = text.split("\\.");
		
		ArrayList<Sentence> sentences = new ArrayList<Sentence>(sentenceStrings.length);
		for (String sentenceString : sentenceStrings) {
			sentences.add(new StringSentence(sentenceString));
		}
		
		return sentences;
	}

}
