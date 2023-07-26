package yahtzee;

import java.util.List;

public class UpperCategory implements CategoryScorer {
	
	private int targetValue;
	
	public UpperCategory(int targetValue) {
		this.targetValue = targetValue;
	}
	
	@Override
	public int score(List<? extends Die> dice) {
		return (int) dice.stream()
				.filter(d -> d.show() == targetValue)
				.mapToInt(d -> d.show())
				.sum();
	}

}
