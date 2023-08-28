package biggerproblems;

public class Insert implements Command{
  
  private String letter;
  
  public Insert(String letter) {
    this.letter = letter;
  }

  @Override
  public String perform(String inp) {
    return inp + letter;
  }

  @Override
  public String undo(String inp) {
    return inp.substring(0, inp.length() - 1); 
  }
}
