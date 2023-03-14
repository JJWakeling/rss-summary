package rss_summary.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapAbundanceTable implements AbundanceTable {

	private final HashMap<Phrase, Integer> table;
	
	public HashMapAbundanceTable(HashMap<Phrase, Integer> table) {
		this.table = table;
	}

	public HashMapAbundanceTable() {
		this(new HashMap<Phrase, Integer>());
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
		Map<Phrase, Integer> summandTable = summand.table();
	
		// Set returned by HashMap<T>.keySet is not guaranteed to implement Set.addAll(Set) - Java devs should learn OOP!
		Set<Phrase> keys = new HashSet<Phrase>(table.keySet());
		keys.addAll(summand.table().keySet());
		
		HashMap<Phrase, Integer> sumTable = new HashMap<Phrase, Integer>();
		for (Phrase key : keys) {
			sumTable.put(
				key,
				(table.containsKey(key) ? table.get(key) : 0)
				+ (summandTable.containsKey(key) ? summandTable.get(key) : 0)
			);
		}
		
		return new HashMapAbundanceTable(sumTable);
	}

	@Override
	public Map<Phrase, Integer> table() {
		//TODO: ensure that this does not expose the source key-value pairs to modification
		return new HashMap<Phrase, Integer>(table);
	}
}
