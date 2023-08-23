package com.learning.hello.model.mankatha;

import cards.Card;

public class Player {

  private Card card;
  private int bet;
  private Orientation orientation;

  public Player(Card card, int bet, Orientation orientation) {
    this.card = card;
    this.bet = bet;
    this.orientation = orientation;
  }

  public Card getCard() {
    return card;
  }
  public int getBet() {
    return bet;
  }
  public Orientation getOrientation() {
    return orientation;
  }

}
