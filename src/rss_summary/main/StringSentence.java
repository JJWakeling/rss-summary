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
			
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i]
			.replaceFirst("^\\W+", "")
			.replaceFirst("\\W+$", "");
		}
		
		return new WordSentence(words)
			.subPhrases();
	}

}
