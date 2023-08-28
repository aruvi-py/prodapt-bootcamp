package biggerproblems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Processor {
  
  public static String process(List<String> instructions, String out) throws Exception {
    
    Stack<Command> commands = new Stack<>();
    
    for (String instruction : instructions) {
      if (!instruction.equals("<undo>")) {
        if (instruction.equals("<bksp>")) {
          Delete del = new Delete();
          out = del.perform(out);
          commands.push(del);
        }
        else {
          Insert ins = new Insert(instruction);
          out = ins.perform(out);
          commands.push(ins);
        }
      }
      else {
        Command toUndo = commands.pop();
        if (toUndo == null)
          throw new Exception();
        out = toUndo.undo(out);
      }
    }
    return out;
  }
  
  public static void main(String[] args) throws Exception {
    String str = "Mary had a little lamb ";
    String[] insArray = {"l", "i", "t", "t", "t", "<bksp>", "t", "<undo>", "<undo>", "<bksp>", "l", "e"};
    List<String> instructions = Arrays.asList(insArray);
    System.out.println(process(instructions, str));
  }

}
