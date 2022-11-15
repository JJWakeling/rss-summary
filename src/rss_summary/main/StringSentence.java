package rss_summary.main;

public class StringSentence implements Sentence {

	private final String text;

	public StringSentence(String text) {
		this.text = text;
	}

	@Override
	public AbundanceTable subPhrases() {
		return new WordSentence(
			text.split(" ")
		)
			.subPhrases();
	}

}
