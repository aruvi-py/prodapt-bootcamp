package trumpcards;

import java.util.Collections;
import java.util.List;

public class TrumpCard {
  
  private final String name;
  private final List<Statistic> statistics;
  
  public TrumpCard(String name, List<Statistic> categories) {
    this.name = name;
    this.statistics = categories;
  }
  
  public String getName() {
    return name;
  }
  
  public List<Statistic> getCategories() {
    return Collections.unmodifiableList(statistics);
  }
  
  private Statistic extract(Category category) {
    Statistic categoryStatistic = null;
    for (Statistic statistic : statistics)
      if (statistic.getName().equals(category.getName()))
        categoryStatistic = statistic;
    return categoryStatistic;
  }
  
  public int compare(TrumpCard other, Category category) throws IncomparableCategoriesException {
    Statistic thisStatistic = this.extract(category);
    Statistic otherStatistic = other.extract(category);
    
    if (thisStatistic == null || otherStatistic == null) {
      throw new IncomparableCategoriesException("This category not found in this card");
    }
    return thisStatistic.beats(otherStatistic);
  }

}
