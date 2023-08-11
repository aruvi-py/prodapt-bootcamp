package trumpcards;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrumpCardPersistence {
  
  public static final String SPACE = " ";
  public static final String COMMA = ",";
  
  public TrumpCard load(String filePath) throws IOException{
    Path path = Paths.get(filePath);
    List<String> lines = Files.readAllLines(path);
    String trumpCardName = lines.remove(0);
    List<Statistic> statistics = new ArrayList<>();
    for (String statStr : lines) {
      String[] components = statStr.replace(SPACE, "").split(COMMA);
      String categoryName = components[0];
      double categoryValue = Double.valueOf(components[1]);
      boolean higherWins = Boolean.valueOf(components[2]);
      Category category = new Category(categoryName, higherWins);
      Statistic currentStat = new Statistic(category, categoryValue);
      statistics.add(currentStat);
    }
    return new TrumpCard(trumpCardName, statistics);
  }

}
