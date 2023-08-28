package calibration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpenHouseDiscussions {
	
	public static int min(int[] nums) {
		int min = Integer.MIN_VALUE;
		for (int num : nums)
			if (num < min)
				num = min;
		return min;
	}
	
	public static int minAlt(int[] nums) {
		return Arrays.stream(nums)
				.reduce((x1, x2) -> (x1 < x2) ? x1 : x2)
				.getAsInt();
	}
	
	public static int sum(int[] nums) {
		return Arrays.stream(nums)
				.reduce((x1, x2) -> x1 + x2)
				.getAsInt();
	}
	
	public static int minIndex(int[] nums, int from) {
		int minIndex = from;
		for (int i = from; i < nums.length; i++)
			if (nums[i] < nums[minIndex])
				minIndex = i;
		return minIndex;
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			swap(nums, i, minIndex(nums, i));
		}
	}
	
	public static Integer min(List<Integer> nums, int from) {
		//return nums.indexOf(nums.stream().min(Integer::compare).get());
		//return nums.indexOf(nums.stream().min((x, y) -> Integer.compare(x,  y)).get());
		//return nums.indexOf(nums.stream().min((x, y) -> x.compareTo(y)).get());
		return nums.stream().skip(from).min(Integer::compareTo).get();
	}
	
	private static String extractIpAddresses(String input) {
		Pattern pattern = Pattern.compile("(\\b25[0-5]|\\b2[0-4][0-9]|\\b[01]?[0-9][0-9]?)"
				+ "(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}\\b");
		Matcher matcher = pattern.matcher(input);
		return matcher.results().map(result -> result.group()).collect(Collectors.joining(" "));
	}
	
	private static Integer square(Integer x) {
		return x * x;
	}
	
	private static boolean isEven(Integer x) {
		return x % 2 == 0;
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public static int add(int... operands) {
		return Arrays.stream(operands).sum();
	}
	
	public static Pair<Integer> divMod(int dividend, int divisor) {
	  return new Pair<>(dividend / divisor, dividend % divisor);
	}
	
	public static boolean update(int[] scores, int winner) {
	  int loser = winner == 0 ? 1 : 0;
	  if (scores[winner] < 3 || 
	      (scores[winner] == 3 && scores[loser] == 3)) {
	    scores[winner]++;
	    return false;
	  }
	  else {
	    if (scores[winner] == 4 || scores[loser] < 3) {
	      scores[0] = scores[1] = 0;
	      return true;
	    }
	    else {
	      scores[loser]--;
	      return false;
	    }
	  }
	}
	
	public static boolean altUpdate(int[] scores, int winner) {
	  scores[winner]++;
	  if (scores[winner] > 3) {
	    if (diff(scores) >= 2) {
	      scores[0] = scores[1] = 0;
	      return true;
	    }
	    else if (diff(scores) == 0) {
	      scores[0] = scores[1] = 3;
	      return false;
	    }
	  }
	  return false;
	}
	
	private static int diff(int[] scores) {
	  return Math.abs(scores[0] - scores[1]);
	}
	
	public static void main(String[] args) {
//		Path source = Path.of("/home/aruvi/Downloads/sowpods.txt");
//		Path target = Path.of("/home/aruvi/prodapt/calibration/sowpods-5letteronly.txt");
//		try {
//			Stream<String> lines = Files.lines(source);
//			List<String> ips = lines
//					.filter(line -> line.length() == 5)
//					.collect(Collectors.toList());
//			Files.write(target, ips);
//			Integer[] numArr = {1, 2, 3, 4, 5};
//			List<Integer> nums = Arrays.asList(numArr);
//			List<Integer> squaredNums = nums.stream().map(new Squarer()).collect(Collectors.toList());
//			List<Integer> evenNums = nums.stream().filter(new EvennessVerifier()).collect(Collectors.toList());
//			System.out.println(squaredNums);
//			System.out.println(evenNums);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Integer[] nums = {1, 2, 3, 4, 1, 2, 3};
//		List<Integer> numList = Arrays.asList(nums);
//		System.out.println(min(numList, 5));
//	    System.out.println(divMod(25, 3));
	    int[] scores = {3, 3};
	    System.out.println(altUpdate(scores, 0));
	    System.out.println(Arrays.toString(scores));
	    
	}

}
