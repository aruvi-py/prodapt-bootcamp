package cards;

import java.util.Optional;

public abstract class AbstractHand {
  
  public abstract void add(Card c);
  
  public abstract Optional<Card> remove(Card c);

}
