package noticeboard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class JsonFilePersistence implements NoticeBoardPersistence{
  
  private String fileLocation;
  private Logger logger;
  public JsonFilePersistence(String fileLocation) {
    this.fileLocation = fileLocation;
    logger = LoggerLoggingUtility.getLogger();
  }
  
  @Override
  public void save(NoticeBoard noticeBoard) throws NoticeBoardPersistenceException {
    Gson gson = new GsonBuilder()
        .setDateFormat(DateFormat.FULL, DateFormat.FULL)
        .setPrettyPrinting()
        .create();
    String json = gson.toJson(noticeBoard, NoticeBoard.class);
    Path path = Paths.get(fileLocation);
    try {
      Files.writeString(path, json, StandardOpenOption.CREATE);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Problems writing to file", e);
      throw new NoticeBoardPersistenceException("Problems writing to file", e);
    }
  }

  @Override
  public NoticeBoard load() throws NoticeBoardPersistenceException {
    Path path = Paths.get(fileLocation);
    try {
    String json = Files.lines(path).collect(Collectors.joining());
    Gson gson = new GsonBuilder()
        .setDateFormat(DateFormat.FULL, DateFormat.FULL)
        .setPrettyPrinting()
        .create();
    NoticeBoard loaded = gson.fromJson(json, NoticeBoard.class);
    return loaded;
    } catch(IOException e1) {
      logger.log(Level.WARNING, "Problems reading from file", e1);
      throw new NoticeBoardPersistenceException("Problems reading from file", e1);
    } catch (JsonSyntaxException e2) {
      logger.log(Level.SEVERE, "Problems reading from file", e2);
      throw new NoticeBoardPersistenceException("Problems reading from file", e2);
    }
  }

}
