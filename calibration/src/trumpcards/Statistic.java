package trumpcards;

public class Statistic {

  private static final double EPSILON = 0.00001;

  private final Category category;
  private final double value;

  public Statistic(Category category, double value) {
    this.category = category;
    this.value = value;
  }

  public String getName() {
    return category.getName();
  }

  public double getValue() {
    return value;
  }

  public static int compareDoubles(double d1, double d2) {
    int absoluteCompareValue = Double.compare(d1, d2);
    if (absoluteCompareValue == 0)
      return 0;
    else if (Math.abs(d1 - d2) < EPSILON)
      return 0;
    else return absoluteCompareValue;
  }


  public int beats(Statistic another) throws IncomparableCategoriesException{
    if (another.getName().equals(this.getName())) {
      int greaterThan = compareDoubles(this.value, another.value);
      return this.category.isHigherValueWins() ? greaterThan : -greaterThan;
    } else {
      throw new IncomparableCategoriesException(String.format("Cannot compare %s and %s", this.category, another.category));
    }
  }



}
