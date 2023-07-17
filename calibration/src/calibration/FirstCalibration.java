package calibration;

public class FirstCalibration {
	
	public static int count(int[] nums, int val) {
		int count = 0;
		for (int num: nums)
			if (num == val)
				count++;
		return count;
	}
	
	public static int uniqueSum(int[] nums) {
		int sum = 0;
		for (int num: nums)
			if (count(nums, num) == 1)
				sum += num;
		return sum;
	}
	
	public static int lastDigit(int num) {
		return num % 10;
	}
	
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}
	
	public static int numOddDigits(int num) {
		int numOddDigits = 0;
		while(num > 0) {
			if (!(isEven(lastDigit(num))))
				numOddDigits++;
			num /= 10;
		}
		return numOddDigits;
	}
	
	public static void main(String[] args) {
		int x = 589107582;
		System.out.println(numOddDigits(x));
	}

}
