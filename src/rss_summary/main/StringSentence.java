package rss_summary.main;

public class StringSentence implements Sentence {

	private final String text;

	public StringSentence(String text) {
		this.text = text;
	}

	@Override
	public AbundanceTable subPhrases() {
		String[] words = text
			.trim()
			.toLowerCase()
			.split("\\s+");
		return new WordSentence(
			words
		)
			.subPhrases();
	}

}
