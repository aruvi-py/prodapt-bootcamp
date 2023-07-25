package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for (int rank = Card.MIN_RANK; rank <= Card.MAX_RANK; rank++)
			for (int suit = Card.MIN_SUIT; suit <= Card.MAX_SUIT; suit++)
				cards.add(new Card(rank, suit));
	}
	
	public Card removeFromTop() {
		if (cards.isEmpty()) {
			System.out.println("No more cards left!");
			return null;
		}
		return cards.remove(0);
	}
	
	public void addToTop(Card c) {
		cards.add(0, c);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}

}
