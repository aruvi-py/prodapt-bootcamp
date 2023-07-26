package yahtzee;

public enum Category {
	
	ACES (new UpperCategory(1)),
	TWOS (new UpperCategory(2)),
	THREES (new UpperCategory(3)),
	FOURS (new UpperCategory(4)),
	FIVES (new UpperCategory(5)),
	SIXES (new UpperCategory(6)),
	THREE_OF_A_KIND (new MultiplesOfAKind(MultiplesOfAKind.THREE_OF_A_KIND)),
	FOUR_OF_A_KIND (new MultiplesOfAKind(MultiplesOfAKind.FOUR_OF_A_KIND)),
	FULL_HOUSE (new FullHouse()),
	SMALL_STRAIGHT (new Straight(Straight.SMALL)),
	LARGE_STRAIGHT (new Straight(Straight.LARGE)),
	YAHTZEE (new MultiplesOfAKind(MultiplesOfAKind.YAHTZEE)),
	CHANCE (new Chance());
	
	private CategoryScorer scorer;
	
	private Category(CategoryScorer scorer) {
		this.scorer = scorer;
	}
	
	public CategoryScorer getScorer() {
		return scorer;
	}

}
