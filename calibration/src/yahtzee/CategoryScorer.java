package yahtzee;

import java.util.List;

public interface CategoryScorer {
	
	public abstract int score(List<? extends Die> dice);

}
