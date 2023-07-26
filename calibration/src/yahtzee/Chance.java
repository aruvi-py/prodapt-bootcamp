package yahtzee;

import java.util.List;

public class Chance implements CategoryScorer{
	@Override
	public int score(List<? extends Die> dice) {
		return dice.stream().mapToInt(d -> d.show()).sum();
	}
}
