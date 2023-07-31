package wordle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Word {
	
	private List<WordleLetter> lettersWithFeedback;
	
	public Word(String word) {
		lettersWithFeedback = Arrays.stream(word.split(""))
				.map(l -> new WordleLetter(l))
				.collect(Collectors.toList());
	}
	
	public List<WordleLetter> getLettersWithFeedback() {
		return lettersWithFeedback;
	}
	
	@Override
	public String toString() {
		return lettersWithFeedback.stream()
				.map(lwf -> lwf.getLetter())
				.collect(Collectors.joining());
	}

}
