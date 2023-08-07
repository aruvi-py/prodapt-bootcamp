package noticeboard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinarySerializedFilePersistence implements NoticeBoardPersistence{
  
  private String fileLocation;
  
  public BinarySerializedFilePersistence(String fileLocation) {
    this.fileLocation = fileLocation;
  }
  
  @Override
  public NoticeBoard load() throws NoticeBoardPersistenceException{
    try {
      FileInputStream fis = new FileInputStream(fileLocation);
      ObjectInputStream ois = new ObjectInputStream(fis);
      NoticeBoard noticeBoard = (NoticeBoard) ois.readObject();
      ois.close();
      fis.close();
      return noticeBoard;
    } catch (IOException | ClassNotFoundException e) {
      throw new NoticeBoardPersistenceException("Problem loading from file", e);
    }
  }

  @Override
  public void save(NoticeBoard noticeBoard) throws NoticeBoardPersistenceException {
    try {
    FileOutputStream fos = new FileOutputStream(fileLocation);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(noticeBoard);
    oos.close();
    fos.close();
    } catch (IOException e) {
      throw new NoticeBoardPersistenceException("Problem saving to file", e);
    }
  }

}
