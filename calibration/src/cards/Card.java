package cards;

public class Card {
	
	int rank;
	int suit;
	
	static final String ABBR_RANKS = " A23456789TJQK";
	static final String ABBR_SUITS = " CDHS";
	
	static final int MIN_RANK = 1;
	static final int MAX_RANK = 13;
	static final int MIN_SUIT = 1;
	static final int MAX_SUIT = 4;
	
	static final int CLUBS = 1;
	static final int DIAMONDS = 2;
	static final int HEARTS = 3;
	static final int SPADES = 4;
	
	static final String BLACK = "Black";
	static final String RED = "Red";
	
	public Card(int newRank, int newSuit) {
		if (newRank > MAX_RANK || newRank < MIN_RANK) {
			System.out.println("hey, not allowed, expect invalid behaviour");
		}
		else if (newSuit > MAX_SUIT || newSuit < MIN_SUIT) {
			System.out.println("hey, not allowed, expect invalid behaviour");
		}
		else {
			rank = newRank;
			suit = newSuit;
		}
	}
	
	/*
	 * Requires an input String abbr
	 * That is formatted as `RS`
	 * where R is one among A23456789TJQK
	 * and S is one among CDHS
	 */
	public Card(String abbr) {
		rank = ABBR_RANKS.indexOf(abbr.charAt(0));
		if (rank == -1) {
			System.out.println("Invalid rank, expect invalid behaviour");
			rank = 0;
		}
		suit = ABBR_SUITS.indexOf(abbr.charAt(1));
		if (suit == -1) {
			System.out.println("Invalid suit, expect invalid behaviour");
			suit = 0;
		}
	}
	
	public String color() {
		return (suit == SPADES || suit == CLUBS) ? BLACK : RED;
	}
	
	public boolean isFaceCard() {
		return isFaceCard(false);
	}
	
	public boolean isFaceCard(boolean isAceIncluded) {
		if (isAceIncluded)
			return (rank == 1 || rank > 10);
		else
			return rank > 10;
	}
	
	@Override
	public String toString() {
		return ABBR_RANKS.substring(rank, rank+1) + ABBR_SUITS.substring(suit, suit+1);
	}
}
