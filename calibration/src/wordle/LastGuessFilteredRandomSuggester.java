package wordle;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LastGuessFilteredRandomSuggester implements Suggester{

	public static boolean matches(String candidate, Word guess) {
		List<WordleLetter> guessFeedbacks = guess.getLettersWithFeedback();
		for (WordleLetter letterWithFeedback : guessFeedbacks) {
			if (letterWithFeedback.getFeedback() == Feedback.CORRECT_POSITION)
				if (candidate.indexOf(letterWithFeedback.getLetter()) != guessFeedbacks.indexOf(letterWithFeedback))
					return false;
			if (letterWithFeedback.getFeedback() == Feedback.WRONG_POSITION)
				if (!candidate.contains(letterWithFeedback.getLetter()))
					return false;
			if (letterWithFeedback.getFeedback() == Feedback.ABSENT)
				if (candidate.contains(letterWithFeedback.getLetter()))
					return false;
		}
		return true;
	}
	
	@Override
	public List<Word> suggest(List<String> candidates, List<Word> guesses) {
		Word lastGuess = guesses.get(guesses.size() - 1);
		return candidates.stream()
				.filter(candidate -> matches(candidate, lastGuess))
				.map(candidate -> new Word(candidate))
				.collect(Collectors.toList());
	}

}
