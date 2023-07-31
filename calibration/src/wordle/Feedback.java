package wordle;

public enum Feedback {
	
	CORRECT_POSITION("green"),
	WRONG_POSITION("yellow"),
	ABSENT("red");
	
	private String color;
	
	private Feedback(String color) {
		this.color = color;
	}
	
	public static Feedback fromString(String color) {
		for (Feedback f : Feedback.values())
			if (f.color.equals(color))
				return f;
		return Feedback.ABSENT;
	}

}
