package cards;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{

	@Override
	public int compare(Card arg0, Card arg1) {
		if (arg0.getRank() == arg1.getRank())
			return Integer.compare(arg0.getSuit(), arg1.getSuit());
		else
			return Integer.compare(arg0.getRank(), arg1.getRank());
	}

}
