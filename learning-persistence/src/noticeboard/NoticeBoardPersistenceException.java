package noticeboard;

public class NoticeBoardPersistenceException extends Exception{
  
  public NoticeBoardPersistenceException(String message) {
    super(message);
  }
  
  public NoticeBoardPersistenceException(String message, Throwable cause) {
    super(message, cause);
  }

}
