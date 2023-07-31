package yahtzee;

public abstract class LowerCategory implements CategoryScorer{
	
	protected String name;
	
	protected LowerCategory(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

}
