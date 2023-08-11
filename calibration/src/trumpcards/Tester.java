package trumpcards;

import java.io.IOException;

public class Tester {
  public static void main(String[] args) throws IOException, IncomparableCategoriesException{
    TrumpCardPersistence persistence = new TrumpCardPersistence();
    TrumpCard sachin = persistence.load("sachin.txt");
    TrumpCard sourav = persistence.load("sourav.txt");
    Category category2 = new Category("Category2", false);
    System.out.println(sachin.compare(sourav, category2));
  }
}
