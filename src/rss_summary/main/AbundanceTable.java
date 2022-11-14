package rss_summary.main;

import java.util.Map;

/**
 * Maintains for a set of distinct phrases a record of their number of occurrences within a certain context
 */
public interface AbundanceTable {
	/**
	 * adds entry for phrase, or increments its count if it already exists
	 */
	void add(Phrase phrase);
	
	/**
	 * returns AbundanceTable whose counts are the sums of the counts for 
	 * each of the summands
	 */
	AbundanceTable sum(AbundanceTable summand);
	
	/**
	 * @return map from phrases to their frequencies
	 * for all phrases that occur in the context
	 */
	Map<Phrase, Integer> table();
}
