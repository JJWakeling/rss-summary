package rss_summary.main;

import java.util.Collection;

public class StringSentenceFactory implements SentenceFactory {

	private final String text;

	public StringSentenceFactory(String text) {
		this.text = text;
	}

	@Override
	public Collection<Sentence> sentences() {
		// TODO Auto-generated method stub
		return null;
	}

}
