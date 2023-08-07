package noticeboard;

public interface NoticeBoardPersistence {
  
  public void save(NoticeBoard noticeBoard) throws NoticeBoardPersistenceException;
  
  public NoticeBoard load() throws NoticeBoardPersistenceException;

}
