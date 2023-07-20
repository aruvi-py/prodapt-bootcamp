package biggerproblems;

import java.util.Arrays;

public class Anagrams {
	public static boolean areAnagrams(String aWord, String bWord, boolean caseSensitive) {
		if (!caseSensitive) {
			aWord = aWord.toLowerCase();
			bWord = bWord.toLowerCase();
		}
		char[] aWordAsChars = aWord.toCharArray();
		Arrays.sort(aWordAsChars);
		char[] bWordAsChars = bWord.toCharArray();
		Arrays.sort(bWordAsChars);
		return String.valueOf(aWordAsChars).equals(String.valueOf(bWordAsChars));
	}
	
	/*
	 * Same as calling Anagrams::areAnagrams(aWord, bWord, false)
	 */
	public static boolean areAnagrams(String aWord, String bWord) {
		return areAnagrams(aWord, bWord, false);
	}
	
	public static void main(String[] args) {
		System.out.println(areAnagrams("Spare", "spear"));
		String[] words = {"spare", "spear", "hello", "bun", "nub", "reaps", "rose", "sore"};
		
	}
}
