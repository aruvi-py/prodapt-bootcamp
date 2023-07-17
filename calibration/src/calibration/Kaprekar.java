package calibration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kaprekar {
	
	public static int lastDigit(int num) {
		return num % 10;
	}
	
	public static int dropLastDigit(int num) {
		return num / 10;
	}
	
	public static List<Integer> numToDigits(int num) {
		List<Integer> digits = new ArrayList<>();
		while (num > 0) {
			digits.add(0, lastDigit(num));
			num = dropLastDigit(num);
		}
		return digits;
	}
	
	public static int digitsToNum(List<Integer> digits) {
		int exp = 0;
		int num = 0;
		Collections.reverse(digits);
		for (Integer digit : digits) {
			num += digit * Math.pow(10, exp++);
		}
		return num;
	}
	
	public static int largestArrangement(int num) {
		List<Integer> digits = numToDigits(num);
		Collections.sort(digits);
		Collections.reverse(digits);
		return digitsToNum(digits);
	}
	
	public static int smallestArrangement(int num) {
		List<Integer> digits = numToDigits(num);
		Collections.sort(digits);
		return digitsToNum(digits);
	}
	
	public static int nextKaprekar(int num) {
		return largestArrangement(num) - smallestArrangement(num);
	}
	
	public static List<Integer> kaprekarSequence(int start) {
		List<Integer> sequence = new ArrayList<Integer>();
		sequence.add(start);
		int current = start;
		int next = nextKaprekar(start);
		while (next != current) {
			sequence.add(next);
			current = next;
			next = nextKaprekar(current);
		}
		return sequence;
	}
	
	public static List<Integer> kaprekarAlt(int start) {
		List<Integer> sequence = new ArrayList<>();
		sequence.add(start);
		int next = nextKaprekar(start);
		if(start != next) {
			sequence.addAll(kaprekarAlt(next));
		}
		return sequence;
	}
	
	
	public static void main(String[] args) {
		System.out.println(kaprekarAlt(3987));
	}

}
