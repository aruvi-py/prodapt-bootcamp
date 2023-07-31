package wordle;

import java.util.List;

public interface Suggester {
	
	public List<Word> suggest(List<String> candidates, List<Word> guesses);

}
