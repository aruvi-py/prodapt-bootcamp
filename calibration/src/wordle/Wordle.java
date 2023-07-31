package wordle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Wordle {

	public static void judge(Word guess, Word answer) {
		List<WordleLetter> guessLetters = guess.getLettersWithFeedback();
		String answerString = answer.toString();
		for (WordleLetter guessLetter : guessLetters) {
			if (guessLetters.indexOf(guessLetter) == answerString.indexOf(guessLetter.getLetter()))
				guessLetter.setFeedback(Feedback.CORRECT_POSITION);
			else if (answerString.contains(guessLetter.getLetter()))
				guessLetter.setFeedback(Feedback.WRONG_POSITION);
			else
				guessLetter.setFeedback(Feedback.ABSENT);
		}
	}

	public static void judge(Word guess, List<String> userInputs) {
		for (int i = 0; i < userInputs.size(); i++) {
			guess.getLettersWithFeedback().get(i).setFeedback(Feedback.fromString(userInputs.get(i)));
		}
	}

	public static void main(String[] args) {
		Path p =Path.of("sowpods-5letteronly.txt");
		try {
			List<String> candidates = Files.readAllLines(p);
			Random r = new Random();
			Suggester firstSuggester = new StupidRandomSuggester();
			List<Word> firstSuggestions = firstSuggester.suggest(candidates, null);
			Word guess =  firstSuggestions.get(r.nextInt(firstSuggestions.size()));
			List<Word> guesses = new ArrayList<>();
			guesses.add(guess);
			Scanner sc = new Scanner(System.in);
			System.out.println("Computer has guessed: " + guess);

			while(true) {

				System.out.println("Enter a five-character string g=green, y=yellow, r=red");
				String userInput = sc.nextLine();
				List<String> parsedUserInputs = Arrays.stream(userInput.split(""))
						.map(w -> (
								w.equals("r") ? "red" :
									w.equals("g") ? "green" :
										"yellow"
								))
						.collect(Collectors.toList());
				judge(guess, parsedUserInputs);
				Suggester regularSuggester = new LastGuessFilteredRandomSuggester();
				candidates = regularSuggester.suggest(candidates, guesses).stream().map(w -> w.toString()).collect(Collectors.toList());
				if (candidates.size() == 0) {
					System.out.println("I give up, you're cheating");
					break;
				}
				guess = new Word(candidates.get(r.nextInt(candidates.size())));
				System.out.println("Computer has now guessed: " + guess);
				guesses.add(guess);
				System.out.println("is this correct?y/n ");
				String isCorrect = sc.nextLine();
				if (isCorrect.equals("y"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
