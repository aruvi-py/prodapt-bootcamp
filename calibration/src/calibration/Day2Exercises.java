package calibration;

import java.util.ArrayList;
import java.util.List;

public class Day2Exercises {
	
	public static boolean isPrime(int n) {
		for (int div = 2; div * div <= n; div++)
			if (n % div == 0)
				return false;
		return true;
	}
	
	public static List<Integer> listPrimes(int limit) {
		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < limit; i++)
			if (isPrime(i))
				primes.add(i);
		return primes;
	}
	
	public static List<Integer> primeFactors(int n) {
		List<Integer> primes = listPrimes((int) Math.sqrt(n) + 1);
		List<Integer> primeFactors = new ArrayList<>();
		for (Integer prime : primes)
			if (n % prime == 0)
				primeFactors.add(prime);
		if (isPrime(n))
			primeFactors.add(n);
		return primeFactors;
	}
	
	public static final int ABUNDANT = 1;
	public static final int DEFICIENT = -1;
	public static final int PERFECT = 0;
	
	public static int aliquotSum(int n) {
		int aliquotSum = 1;
		int div;
		for (div = 2; div * div <= n; div++)
			if (n % div == 0) {
				aliquotSum += div;
				if (div != n / div)
					aliquotSum += n / div;
			}
		return aliquotSum;
	}
	
	public static int classify(int n) {
		if (n > aliquotSum(n))
			return ABUNDANT;
		else if (n < aliquotSum(n))
			return DEFICIENT;
		return PERFECT;
	}
	
	public static boolean areAmicable(int a, int b) {
		return aliquotSum(a) == b && aliquotSum(b) == a;
	}
	
	public static List<List<Integer>> amicablePairsUpto(int limit) {
		List<List<Integer>> amicablePairs = new ArrayList<List<Integer>>();
		for (int i = 1; i < limit; i++) {
			if (areAmicable(i, aliquotSum(i)) && i > aliquotSum(i)) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				temp.add(aliquotSum(i));
				amicablePairs.add(temp);
			}
		}
		return amicablePairs;
	}
	
	public static void main(String[] args) {
		System.out.println(amicablePairsUpto(10000));
	}
	
}
