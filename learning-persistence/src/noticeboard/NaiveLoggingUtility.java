package noticeboard;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NaiveLoggingUtility {
  
  private String logFilePath;
  
  public NaiveLoggingUtility(String logFilePath) {
    this.logFilePath = logFilePath;
  }
  
  public NaiveLoggingUtility() {
    this.logFilePath = "notice-board-log.log";
  }
  
  public void log(String message) {
    log(message, logFilePath);
  }
  
  public void logException(String preamble, Throwable ex) {
    FileWriter fw = null;
    PrintWriter pw = null;
    try {
      fw = new FileWriter(logFilePath, true);
      pw = new PrintWriter(fw);
      pw.append(preamble);
      ex.printStackTrace(pw);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (pw != null)
        pw.close();
      if (fw != null)
        try {
          fw.close();
        } catch (IOException e) {
        }
    }
  }
  
  public static void log(String message, String filePath) {
    Path p = Paths.get(filePath);
    try {
      Files.writeString(p, message, StandardOpenOption.APPEND);
    } catch (IOException e) {
      System.err.println("Can't access the log file. Exception below:");
      e.printStackTrace();
    }
  }
}
