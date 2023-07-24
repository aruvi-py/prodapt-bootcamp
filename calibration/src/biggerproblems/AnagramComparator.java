package biggerproblems;

import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		return Anagrams.rearrangeAlphabetic(arg0)
				.compareTo(Anagrams.rearrangeAlphabetic(arg1));
	}

}
