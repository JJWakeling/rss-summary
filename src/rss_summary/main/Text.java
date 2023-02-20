package rss_summary.main;

/**
 * Simplest derived type of Context
 * Has a string representation which is the source of all phrases associated with the text
 */
public interface Text extends Context {
	String content();
}
