package noticeboard;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Contact implements Serializable{
  
  private static final long serialVersionUID = -3514778272364967765L;

  @Getter
  private final String name;
  
  @Getter
  private final String phoneNumber;
  
  public Contact(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

}
