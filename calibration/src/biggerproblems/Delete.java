package biggerproblems;

public class Delete implements Command{
  
  private String letter;
  
  public Delete() {
    
  }

  @Override
  public String perform(String inp) {
    letter = inp.substring(inp.length() - 1);
    return inp.substring(0, inp.length() - 1);
  }

  @Override
  public String undo(String inp) {
    return inp + letter;
  }

}
