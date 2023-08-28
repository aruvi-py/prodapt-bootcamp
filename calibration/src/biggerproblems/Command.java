package biggerproblems;

public interface Command {
  
  public String perform(String inp);
  public String undo(String inp);
}
