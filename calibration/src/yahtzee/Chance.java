package yahtzee;

import java.util.List;

public class Chance extends LowerCategory{
	
	public Chance() {
		super("Chance");
	}
	@Override
	public int score(List<? extends Die> dice) {
		return dice.stream().mapToInt(d -> d.show()).sum();
	}
}
