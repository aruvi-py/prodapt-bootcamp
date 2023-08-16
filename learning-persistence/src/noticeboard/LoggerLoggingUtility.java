package noticeboard;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerLoggingUtility {
  
  public static Logger getLogger() {
    Logger logger = null;
    try {
      Handler fh = new FileHandler("/home/aruvi/prodapt/learning-persistence/notice-board-logger-log.log", true);
      fh.setFormatter(new SimpleFormatter());
      Logger.getLogger("").addHandler(fh);
      logger = Logger.getLogger("noticeboard");
      logger.setLevel(Level.FINEST);  
    } catch (SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return logger;
  }
}
