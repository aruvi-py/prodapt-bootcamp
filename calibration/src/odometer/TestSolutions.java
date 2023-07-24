package odometer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestSolutions {
	
	private static final String ALPHAS = "abcdefghijklmnopqrstuvwxyzabcdefghijklmn"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMN";
	
	public static char encryptRot13(char c) {
		if (!Character.isAlphabetic(c))
			return c;
		return ALPHAS.charAt(ALPHAS.indexOf(c) + 13);
	}
	
	public static String encryptRot13(String input) {
		char[] inputAsChars = input.toCharArray();
		String output = "";
		for (char c : inputAsChars)
			output += encryptRot13(c);
		return output;
	}
	
	public static String reverse(String input) {
		return new StringBuilder(input).reverse().toString();
	}
	
	private static final String SPACE = " ";
	
	public static String wordWiseReverse(String input) {
		String[] words = input.split(SPACE);
		return Arrays.stream(words).map(word -> reverse(word)).collect(Collectors.joining(SPACE));
	}
	
	public static int[] wonkySort(int[] nums) {
		Arrays.sort(nums);
		int[] output = new int[nums.length];
		int ltr = 0;
		int rtl = nums.length - 1;
		int i = 0;
		while (i < nums.length) {
			output[i] = nums[rtl--];
			i += 2;
		}
		i = 1;
		while (i < nums.length) {
			output[i] = nums[ltr++];
			i += 2;
		}
		return output;
	}
	
	public static void main(String[] args) {
		//System.out.println(encryptRot13("Take Care of Edge Cases!"));
		System.out.println(wordWiseReverse("multiple  spaces  shouldn't  cripple  the method"));
		int[] nums = {5, 10, 15, 20, 25, 30};
		System.out.println(Arrays.toString(wonkySort(nums)));
	}

}
