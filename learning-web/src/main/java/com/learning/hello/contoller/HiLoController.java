package com.learning.hello.contoller;

import java.util.Random;

public class HiLoController {
  private int correct;
  private int guess;
  
  public void setGuess(int guess) {
    this.guess = guess;
  }
  
  public void reset() {
    this.correct = new Random().nextInt(0, 100);
  }
  
  public int judge() {
    return Integer.compare(guess, correct);
  }
  
  public String feedback() {
    return judge() == 0 ? "Correct!" : judge() == 1 ? "Guess lower" : "guess higher";
  }
}
