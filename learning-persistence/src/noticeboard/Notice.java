package noticeboard;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Notice implements Serializable{
  private static final long serialVersionUID = -659169327700894126L;
  @Getter
  private final String title;
  @Getter
  private final String content;
  @Getter
  private final Contact contact;
  @Getter
  private final LocalDateTime creationTime;
  
  public LocalDateTime getCreationTime() {
    return creationTime;
  }
  
  public Notice(String title, String content, Contact contact) {
    this.title = title;
    this.content = content;
    this.contact = contact;
    this.creationTime = LocalDateTime.now();
  }  
}
