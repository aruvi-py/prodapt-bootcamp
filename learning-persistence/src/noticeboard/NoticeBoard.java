package noticeboard;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.ToString;

@ToString
public class NoticeBoard implements Serializable{
  
  private static final long serialVersionUID = -8112456891554575366L;
  private List<Notice> notices;
  
  
  
  public NoticeBoard() {
    this.notices = new ArrayList<>();
  }
  
  public List<Notice> getNotices() {
    return Collections.unmodifiableList(notices);
  }
  
  /**
   * 
   * @param notice
   * @return true if notice was added and nothing was replaced
   * @return false if notice was added and something was replaced.
   */
  public boolean add(Notice notice) {
    if (notices.size() < 6) {
      notices.add(notice);
      return true;
    } else {
      String message = String.format("%s: %s was added.\n", LocalDateTime.now(), notice.toString());
      LoggerLoggingUtility.getLogger().fine(message);
      Notice oldest = notices.stream()
          .min(
              (n1, n2) -> n1.getCreationTime().compareTo(n2.getCreationTime())
              ).get();
      notices.remove(oldest);
      notices.add(notice);
      return false;
    }
  }

}
