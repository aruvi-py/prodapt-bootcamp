package wordle;

public class WordleLetter {
	
	private String letter;
	private Feedback feedback;
	
	public WordleLetter(String letter) {
		this.letter = letter;
		this.feedback = Feedback.ABSENT;
	}
	
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	
	public Feedback getFeedback() {
		return feedback;
	}
	
	public String getLetter() {
		return letter;
	}

}
