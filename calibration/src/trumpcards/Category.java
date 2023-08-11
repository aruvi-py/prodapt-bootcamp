package trumpcards;

public class Category {
  
  private final String name;
  private final boolean higherValueWins;
  
  public Category(String name, boolean higherValueWins) {
    this.name = name;
    this.higherValueWins = higherValueWins;
  }
  
  public String getName() {
    return name;
  }
  
  public boolean isHigherValueWins() {
    return higherValueWins;
  }
  
  @Override
  public String toString() {
    return name;
  }

}
