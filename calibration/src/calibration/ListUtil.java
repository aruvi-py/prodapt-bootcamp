package calibration;

import java.util.Arrays;

public class ListUtil {
	
	public static int[] append(int[] nums, int x) {
		int[] temp = new int[nums.length + 1];
		int i;
		for (i = 0; i < nums.length; i++)
			temp[i] = nums[i];
		temp[i] = x;
		return temp;
	}
	
	public static int[] removeItemAt(int[] nums, int index) {
		int[] temp = new int[nums.length - 1];
		int j = 0;
		for (int i = 0; i < nums.length; i++) 
			if (i != index) 
				temp[j++] = nums[i];
		return temp;
	}
	
	public static boolean contains(Integer[] nums, Integer item) {
		for (Integer num : nums)
			if (item.equals(num))
				return true;
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(append(arr, 6)));
		System.out.println(Arrays.toString(removeItemAt(arr, 0)));
	}

}
