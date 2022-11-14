package rss_summary.main;

public class StringPhrase extends Phrase {

	private final String text;

	public StringPhrase(String text) {
		this.text = text;
	}

	@Override
	public String text() {
		return text;
	}

}
