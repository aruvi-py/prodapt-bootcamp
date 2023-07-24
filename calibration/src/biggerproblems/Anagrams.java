package biggerproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {
	
	public static String rearrangeAlphabetic(String word) {
		char[] wordAsChars = word.toCharArray();
		Arrays.sort(wordAsChars);
		return String.valueOf(wordAsChars);
	}
	
	public static boolean areAnagrams(String aWord, String bWord, boolean caseSensitive) {
		if (!caseSensitive) {
			aWord = aWord.toLowerCase();
			bWord = bWord.toLowerCase();
		}
		return rearrangeAlphabetic(aWord).equals(rearrangeAlphabetic(bWord));
	}
	
	/*
	 * Same as calling Anagrams::areAnagrams(aWord, bWord, false)
	 */
	public static boolean areAnagrams(String aWord, String bWord) {
		return areAnagrams(aWord, bWord, false);
	}
	
	public static List<List<String>> groupAnagrams(List<String> words) {
		Map<String, List<String>> groupings = new HashMap<>();
		for (String word : words) {
			String rearranged = rearrangeAlphabetic(word);
			if (!groupings.containsKey(rearranged))
				groupings.put(rearranged, new ArrayList<>());
			groupings.get(rearranged).add(word);
		}
		List<List<String>> groupedAnagrams = new ArrayList<>();
		for (String rearrangement: groupings.keySet()) {
			if (groupings.get(rearrangement).size() > 1)
				groupedAnagrams.add(groupings.get(rearrangement));
		}
		return groupedAnagrams;
	}
	
	public static void main(String[] args) {
		System.out.println(areAnagrams("Spare", "spear"));
		String[] words = {"spare", "spear", "hello", "bun", "nub", "reaps", "rose", "sore"};
		List<String> wordList = Arrays.asList(words);
		//System.out.println(groupAnagrams(wordList));
		List<String> sortedWordList = wordList.stream()
			.sorted(new AnagramComparator())
			.collect(Collectors.toList());
		
		Map<String, List<String>> groupedAnagrams =  wordList.stream()
			.collect(Collectors.groupingBy(lambda -> rearrangeAlphabetic(lambda)));
		
		List<List<String>> groupedAnagramsNoSolo = groupedAnagrams.entrySet().stream()
				.filter(entry -> entry.getValue().size() > 1)
				.map(entry -> entry.getValue())
				.collect(Collectors.toList());
		
		//System.out.println(sortedWordList);
		System.out.println(groupedAnagramsNoSolo);
	}
}
