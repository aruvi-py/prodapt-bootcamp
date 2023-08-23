package com.learning.hello.model.mankatha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import cards.Card;
import cards.Deck;

public class Game {
  
  private Deck deck;
  private List<Card> in;
  private List<Card> out;
  private List<Player> players;
  
  private static Game game;
  
  public static Game getInstance() {
    if (game == null)
      game = new Game();
    return game;
  }
  
  private List<Card> getCardsIn(Orientation orientation) {
    return orientation == Orientation.IN ? in : out;
  }
  
  public Game() {
    deck = new Deck();
    deck.shuffle();
    in = new ArrayList<>();
    out = new ArrayList<>();
    players = new ArrayList<>();
  }
  
  public void addPlayer(Player player) {
    players.add(player);
  }
  
  public void deal(Orientation orientation) {
    getCardsIn(orientation).add(deck.removeFromTop());
  }
  
  public Optional<Player> winner() {
    for (Player player : players) {
      if (getCardsIn(player.getOrientation()).contains(player.getCard())) {
        return Optional.of(player);
      }
    }
    return Optional.empty();
  }
  
  public List<Player> getPlayers() {
    return Collections.unmodifiableList(players);
  }
  
  public void reset() {
    this.players = new ArrayList<>();
    deck.reset();
  }
  
  public List<Card> getIn() {
    return Collections.unmodifiableList(in);
  }
  
  public List<Card> getOut() {
    return Collections.unmodifiableList(out);
  }

}
