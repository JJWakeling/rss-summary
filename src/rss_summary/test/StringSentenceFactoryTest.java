package rss_summary.test;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.junit.Assert;
import rss_summary.main.*;

public class StringSentenceFactoryTest {

	@Test
	public void testTextSplitIntoSentences() {
		AbundanceTable phrases = new HashMapAbundanceTable();
		for (
			Sentence sentence :
			(
				new StringSentenceFactory(
					"I do not like them in a box. I do not like them with a fox. I do not like them in a house. I do not like them with a mouse."
				)
			).sentences()
		) {
			phrases =  phrases.sum(sentence.subPhrases());
		}
	
		//TODO: compare the phrases resulting from splitting a multi-sentence text into phrases
		// with HashMap you would accept
		Assert.assertEquals(
			new HashSet<Map.Entry<Phrase,Integer>>(
				Arrays.asList(
					new PhraseCount("i", 4).mapEntry(),
					new PhraseCount("do", 4).mapEntry(),
					new PhraseCount("not", 4).mapEntry(),
					new PhraseCount("like", 4).mapEntry(),
					new PhraseCount("them", 4).mapEntry(),
					new PhraseCount("in", 2).mapEntry(),
					new PhraseCount("a", 4).mapEntry(),
					new PhraseCount("box", 1).mapEntry(),
					new PhraseCount("with", 2).mapEntry(),
					new PhraseCount("fox", 1).mapEntry(),
					new PhraseCount("house", 1).mapEntry(),
					new PhraseCount("mouse", 1).mapEntry(),
					
					new PhraseCount("i do", 4).mapEntry(),
					new PhraseCount("do not", 4).mapEntry(),
					new PhraseCount("not like", 4).mapEntry(),
					new PhraseCount("like them", 4).mapEntry(),
					new PhraseCount("them in", 2).mapEntry(),
					new PhraseCount("in a", 2).mapEntry(),
					new PhraseCount("a box", 1).mapEntry(),
					new PhraseCount("them with", 2).mapEntry(),
					new PhraseCount("with a", 2).mapEntry(),
					new PhraseCount("a fox", 1).mapEntry(),
					new PhraseCount("a house", 1).mapEntry(),
					new PhraseCount("a mouse", 1).mapEntry(),
					
					new PhraseCount("i do not", 4).mapEntry(),
					new PhraseCount("do not like", 4).mapEntry(),
					new PhraseCount("not like them", 4).mapEntry(),
					new PhraseCount("like them in", 2).mapEntry(),
					new PhraseCount("them in a", 2).mapEntry(),
					new PhraseCount("in a box", 1).mapEntry(),
					new PhraseCount("like them with", 2).mapEntry(),
					new PhraseCount("them with a", 2).mapEntry(),
					new PhraseCount("with a fox", 1).mapEntry(),
					new PhraseCount("in a house", 1).mapEntry(),
					new PhraseCount("with a mouse", 1).mapEntry(),
					
					new PhraseCount("i do not like", 4).mapEntry(),
					new PhraseCount("do not like them", 4).mapEntry(),
					new PhraseCount("not like them in", 2).mapEntry(),
					new PhraseCount("like them in a", 2).mapEntry(),
					new PhraseCount("them in a box", 1).mapEntry(),
					new PhraseCount("not like them with", 2).mapEntry(),
					new PhraseCount("like them with a", 2).mapEntry(),
					new PhraseCount("them with a fox", 1).mapEntry(),
					new PhraseCount("them in a house", 1).mapEntry(),
					new PhraseCount("them with a mouse", 1).mapEntry(),
					
					new PhraseCount("i do not like them", 4).mapEntry(),
					new PhraseCount("do not like them in", 2).mapEntry(),
					new PhraseCount("not like them in a", 2).mapEntry(),
					new PhraseCount("like them in a box", 1).mapEntry(),
					new PhraseCount("do not like them with", 2).mapEntry(),
					new PhraseCount("not like them with a", 2).mapEntry(),
					new PhraseCount("like them with a fox", 1).mapEntry(),
					new PhraseCount("like them in a house", 1).mapEntry(),
					new PhraseCount("like them with a mouse", 1).mapEntry(),
					
					new PhraseCount("i do not like them in", 2).mapEntry(),
					new PhraseCount("do not like them in a", 2).mapEntry(),
					new PhraseCount("not like them in a box", 1).mapEntry(),
					new PhraseCount("i do not like them with", 2).mapEntry(),
					new PhraseCount("do not like them with a", 2).mapEntry(),
					new PhraseCount("not like them with a fox", 1).mapEntry(),
					new PhraseCount("not like them in a house", 1).mapEntry(),
					new PhraseCount("not like them with a mouse", 1).mapEntry(),
					
					new PhraseCount("i do not like them in a", 2).mapEntry(),
					new PhraseCount("do not like them in a box", 1).mapEntry(),
					new PhraseCount("i do not like them with a", 2).mapEntry(),
					new PhraseCount("do not like them with a fox", 1).mapEntry(),
					new PhraseCount("do not like them in a house", 1).mapEntry(),
					new PhraseCount("do not like them with a mouse", 1).mapEntry(),
					
					new PhraseCount("i do not like them in a box").mapEntry(),
					new PhraseCount("i do not like them with a fox").mapEntry(),
					new PhraseCount("i do not like them in a house").mapEntry(),
					new PhraseCount("i do not like them with a mouse").mapEntry()
				)
			),
			phrases.table().entrySet()
		);
	}

}
