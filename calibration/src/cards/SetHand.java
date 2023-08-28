package cards;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SetHand extends AbstractHand{
  
  private Set<Card> cards;
  
  public SetHand() {
    this.cards = new HashSet<Card>();
  }

  @Override
  public void add(Card c) {
    cards.add(c);
  }

  @Override
  public Optional<Card> remove(Card c) {
    if (cards.remove(c))
      return Optional.of(c);
    return Optional.empty();
  }

}
