package rss_summary.main;

/**
 * wraps a string for consistent formatting of phrases identical for my purposes
 * and database optimisation
 */
public abstract class Phrase {
	public abstract String text();
	
	public boolean equals(Object obj) {
		//TODO: make this elegant
		//N.b. making this elegant may become less necessary as you start to
		// tie implementation to a database
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Phrase)) return false;
        
        return ((Phrase) obj).text().equals(text());
	}
	
	public int hashCode() {
		return text().hashCode();
	}
}
