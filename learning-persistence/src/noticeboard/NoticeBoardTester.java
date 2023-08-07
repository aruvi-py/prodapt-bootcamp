package noticeboard;

import java.io.IOException;

public class NoticeBoardTester {

  public static void main(String[] args) {
    Contact aruvi = new Contact("Bruvi", "9xxxxxxxxx");
    Notice notice = new Notice("Monday 15 Aug is a holiday!", "It is Independence day", aruvi);
    JsonFilePersistence persistence = new JsonFilePersistence("/home/aruvi/prodapt/learning-persistence/noticeBoardJson");
    
    try {
      NoticeBoard noticeBoard = persistence.load();
      noticeBoard.add(notice);
      
      persistence.save(noticeBoard);
    } catch (NoticeBoardPersistenceException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}