package yahtzee;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FullHouse extends LowerCategory{
	
	private static final int FULL_HOUSE_SCORE = 25;
	
	public FullHouse() {
		super("Full House");
	}
	
	@Override
	public int score(List<? extends Die> dice) {
		Supplier<IntStream> frequencies = () -> dice.stream()
				.mapToInt(d -> Collections.frequency(dice, d));
		int maxFreq = frequencies.get().max().orElse(0);
		int minFreq = frequencies.get().min().orElse(0);
		if (!(maxFreq == 3 && minFreq == 2))
			return 0;
		return FULL_HOUSE_SCORE;
	}
}
