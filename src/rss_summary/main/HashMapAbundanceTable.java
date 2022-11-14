package rss_summary.main;

import java.util.HashMap;
import java.util.Map;

public class HashMapAbundanceTable implements AbundanceTable {

	private final HashMap<Phrase, Integer> table;

	public HashMapAbundanceTable() {
		table = new HashMap<Phrase, Integer>();
	}

	@Override
	public void add(Phrase phrase) {
		table.put(
			phrase,
			table.containsKey(phrase) ? table.get(phrase) + 1 : 1
		);
	}

	@Override
	public AbundanceTable sum(AbundanceTable summand) {
		// TODO implement
		return null;
	}

	@Override
	public Map<Phrase, Integer> table() {
		//TODO: ensure that this does not expose the source key-value pairs to modification
		return new HashMap<Phrase, Integer>(table);
	}
}
