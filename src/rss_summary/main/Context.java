package rss_summary.main;

/**
 * grouping of phrases which occur in related situations
 * e.g. a particular article, all articles within a certain timespan
 */
public interface Context {
	//TODO: maybe add human-readable identifier method
	AbundanceTable phrases();
}
