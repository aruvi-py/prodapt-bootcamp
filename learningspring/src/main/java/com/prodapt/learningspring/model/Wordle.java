package com.prodapt.learningspring.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import wordle.Feedback;
import wordle.StupidRandomSuggester;
import wordle.Word;

@Component
public class Wordle {
  private List<Word> computerGuesses = new ArrayList<>();
  
  private StupidRandomSuggester suggester = new StupidRandomSuggester();
  
  private List<String> words = Arrays.asList("APPLE", "MANGO", "ORANGE");
  
  public Word getLatestGuess() {
    if (computerGuesses.size() == 0)
      addGuess();
    return computerGuesses.get(computerGuesses.size() - 1);
  }
  
  public List<Word> getComputerGuesses() {
    return computerGuesses;
  }
  
  public void setLatestFeedback(List<String> feedbacks) {
    Word latestGuess = getLatestGuess();
    for (int i = 0; i < feedbacks.size(); i++) {
      latestGuess.getLettersWithFeedback().get(i)
      .setFeedback(Feedback.fromString(feedbacks.get(i)));
    }
  }
  
  public Word getNextGuess() {
    Random random = new Random();
    int index = random.nextInt(0, words.size());
    return suggester.suggest(words, computerGuesses).get(index);
  }
  
  public void addGuess() {
    computerGuesses.add(getNextGuess());
  }
  
}
