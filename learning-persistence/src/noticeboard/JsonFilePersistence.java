package noticeboard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class JsonFilePersistence implements NoticeBoardPersistence{
  
  private String fileLocation;
  
  public JsonFilePersistence(String fileLocation) {
    this.fileLocation = fileLocation;
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
    } catch(IOException|JsonSyntaxException e) {
      throw new NoticeBoardPersistenceException("Problems reading from file", e);
    }
  }

}
