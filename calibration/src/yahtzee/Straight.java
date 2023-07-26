package yahtzee;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Straight implements CategoryScorer{
	
	public static final int SMALL = 4;
	public static final int LARGE = 5;
	
	private static final int SMALL_SCORE = 30;
	private static final int LARGE_SCORE = 40;
	
	private static String[] SMALL_STRAIGHTS = {"1234", "2345", "3456"};
	private static String[] LARGE_STRAIGHTS = {"12345", "23456"};
	
	private int seqLength;
	
	public Straight(int seqLength) {
		if (!(seqLength == SMALL || seqLength == LARGE))
			seqLength = 0;
		this.seqLength = seqLength;
	}
	
	@Override
	public int score(List<? extends Die> dice) {
		//
		String sortedDistinctDice = dice.stream()
				.sorted((d1, d2) -> Integer.compare(d1.show(), d2.show()))
				.map(d -> String.valueOf(d.show()))
				.collect(Collectors.joining())
				.chars()
				.distinct()
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		
		if (seqLength == LARGE) {
			for (String possibility : LARGE_STRAIGHTS)
				if (sortedDistinctDice.equals(possibility))
					return LARGE_SCORE;
		}
		else {
			for (String possibility : SMALL_STRAIGHTS)
				if (sortedDistinctDice.equals(possibility))
					return SMALL_SCORE;
		}
		
		return 0;
		
//		IntStream frequencies = dice.stream()
//				.mapToInt(d -> Collections.frequency(dice, d));
//		int maxFreq = frequencies.max().orElse(-1);
//		int numDoubleSkips = 0;
//		for (int i = 1; i < sortedDice.size(); i++) {
//			if (sortedDice.get(i).show() - sortedDice.get(i-1).show() > 1)
//				numDoubleSkips++;
//		}
//		if (seqLength == 4 && numDoubleSkips <= 1 && maxFreq <= 2)
//			return SMALL_SCORE;
//		if (seqLength == 5 && numDoubleSkips == 0 && maxFreq == 1)
//			return LARGE_SCORE;
//		return 0;
	}
}
