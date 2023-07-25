package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
	
	private List<Card> cards;
	
	public Hand(List<Card> cards) {
		List<Card> temp = new ArrayList<>(cards);
		this.cards = temp;
	}
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void add(Card c) {
		if (!cards.contains(c))
			cards.add(c);
	}
	
	public void sortByRankThenSuit() {
		Collections.sort(cards, 
				((c1, c2) -> (
						c1.getRank() == c2.getRank() 
						? 
						Integer.compare(c1.getSuit(), c2.getSuit())
						: 
						Integer.compare(c1.getRank(), c2.getRank())
						))
				);
	}
	
	public Hand sortedByRankThenSuit() {
		Hand temp = new Hand(this.cards);
		temp.sortByRankThenSuit();
		return temp;
	}
	
	public void sortBySuitThenRank() {
		Collections.sort(cards, 
				(c1, c2) -> (
						c1.getSuit() == c2.getSuit() 
						? 
						Integer.compare(c1.getRank(), c2.getRank())
						: 
						Integer.compare(c1.getSuit(), c2.getSuit())
						)
				);
	}
	
	public Hand sortedBySuitThenRank() {
		Hand temp = new Hand(this.cards);
		temp.sortBySuitThenRank();
		return temp;
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}

}
