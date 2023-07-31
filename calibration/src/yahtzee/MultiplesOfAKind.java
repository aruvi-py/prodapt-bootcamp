package yahtzee;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplesOfAKind extends LowerCategory{
	
	public static final int THREE_OF_A_KIND = 3;
	public static final int FOUR_OF_A_KIND = 4;
	public static final int YAHTZEE = 5;
	
	private static final int YAHTZEE_SCORE = 50;
	
	int numMultiples;
	
	private static String getName(int numMultiples) {
		switch(numMultiples) {
		case(THREE_OF_A_KIND):
			return "Three of a Kind";
		case (FOUR_OF_A_KIND):
			return "Four of a Kind";
		default:
			return "Yahtzee";
		}
	}
	
	public MultiplesOfAKind(int numMultiples) {
		super(getName(numMultiples));
		this.numMultiples = numMultiples;
		
	}
	
	@Override
	public int score(List<? extends Die> dice) {
		int highestDiceFrequency = dice.stream()
				.mapToInt(d -> Collections.frequency(dice, d))
				.max().orElse(0);
		if (highestDiceFrequency >= numMultiples)
			if (numMultiples == YAHTZEE)
				return YAHTZEE_SCORE;
			else
				return dice.stream()
					.mapToInt(d -> d.show())
					.sum();
		else
			return 0;
	}
}
