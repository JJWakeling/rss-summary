package rss_summary.demo.count_frequency;

import java.util.Map;
import java.util.Scanner;
import rss_summary.main.*;

public class MainClass {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter a sentence");
			Sentence sentence = new StringSentence(scanner.nextLine());
			
			for (Map.Entry<Phrase, Integer> row : sentence.subPhrases().table().entrySet()) {
				System.out.println(
					String.format(
						"%s : %d",
						row.getKey().text(),
						row.getValue()
					)
				);
			}
		}
	}

}
