package wordle;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StupidRandomSuggester implements Suggester{

	@Override
	public List<Word> suggest(List<String> candidates, List<Word> guesses) {
		return candidates.stream().map(candidate -> new Word(candidate)).collect(Collectors.toList());
	}

}
