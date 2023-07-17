package calibration;

import java.util.ArrayList;
import java.util.List;

public class Armstrong {
	
	public static int lastDigit(int num) {
		return num % 10;
	}
	
	public static int dropLastDigit(int num) {
		return num / 10;
	}
	
	public static int length(int num) {
		int len = 0;
		while (num > 0) {
			num = dropLastDigit(num);
			len++;
		}
		return len;
	}
	
	public static int digPowSum(int num) {
		int sum = 0;
		int len = length(num);
		while (num > 0) {
			sum += Math.pow(lastDigit(num), len);
			num = dropLastDigit(num);
		}
		return sum;
	}
	
	public static boolean isArmstrong(int num) {
		return num == digPowSum(num);
	}
	
	public static List<Integer> listArmstrong(int limit) {
		int choice = 0;
		List<Integer> armstrongs = new ArrayList<Integer>();
		while (choice < limit) {
			if(isArmstrong(choice))
				armstrongs.add(choice);
			choice++;
		}
		return armstrongs;
	}
	
	public static void main(String[] args) {
		System.out.println(listArmstrong(25000));
	}
}
