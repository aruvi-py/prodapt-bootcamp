package calibration;

import java.util.Optional;
import java.util.Scanner;

public class ConstrainedValue {
  
  String value;
  
  public ConstrainedValue(String value) {
    if (value.length() < 5)
      this.value = value;
  }
  
  public Optional<String> getValue() {
    return Optional.ofNullable(value);
  }
  
  //this program checks whether the submitted
  //user input is equal to the value stored in ConstrainedValue
  public static void main(String[] args) {
    ConstrainedValue c = new ConstrainedValue("hello");
    Scanner sc = new Scanner(System.in);
    String userInput = sc.nextLine();
    Optional<String> valueInC = c.getValue();
    String realValue = valueInC.isPresent() ? valueInC.get() : "";
    System.out.println(realValue.equals(userInput));
  }
}


