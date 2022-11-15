package rss_summary.main;

public class StringSentence implements Sentence {

	private final String text;

	public StringSentence(String text) {
		this.text = text;
	}

	@Override
	public AbundanceTable subsequences() {
		return new WordSentence(
			text.split(" ")
		)
			.subsequences();
	}

}
