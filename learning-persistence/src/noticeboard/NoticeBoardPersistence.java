package noticeboard;

public interface NoticeBoardPersistence {
  
  public abstract void save(NoticeBoard noticeBoard) throws NoticeBoardPersistenceException;
  
  public abstract NoticeBoard load() throws NoticeBoardPersistenceException;

}
