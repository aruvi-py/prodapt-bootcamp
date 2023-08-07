package noticeboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DBConnectionTester {

  public static void main(String[] args) {
    PreparedStatement insert = null;
    PreparedStatement update = null;
    Statement stmt = null;
    Connection cnx = null;
    ResultSet rs = null;
    
    String insertNotice = "INSERT INTO notices (id, title, content, contact_id, date_created) values (?, ?, ?, ?, ?)";
    String updateDate = "UPDATE notices SET date_created=? where id=?";
    try {
      cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt",
          "prodapt",
          "prodapt");
      System.out.println(cnx.getClass());
      insert = cnx.prepareStatement(insertNotice);
      System.out.println(insert.getClass());
//      update = cnx.prepareStatement(updateDate);
//      Scanner sc = new Scanner(System.in);
//      System.out.println("Enter notice title");
//      String inpTitle = sc.nextLine();
//      System.out.println("Enter notice text (no newlines allowed)");
//      String inpContent = sc.nextLine();
//      System.out.println("Assuming this is Aruvi");
//      int contactId = 1;
//      LocalDateTime now = LocalDateTime.now();
//      
//      insert.setInt(1, 6);
//      insert.setString(2, inpTitle);
//      insert.setString(3, inpContent);
//      insert.setInt(4, contactId);
//      insert.setString(5, now.toString());
//      
//      int rowsAffected = insert.executeUpdate();
//      
//      update.setString(1, now.toString());
//      update.setInt(2, 4);
//      
//      rowsAffected = update.executeUpdate();
//      
//      stmt = cnx.createStatement();
//      rs = stmt.executeQuery("SELECT * FROM notices n, contacts c where n.contact_id = c.id ORDER BY date_created DESC LIMIT 6");
//      System.out.println("Notice_ID, Title, Content, Contact Name, Contact Number");
//      while(rs.next()) {
//        int noticeId = rs.getInt("n.id");
//        String title = rs.getString("title");
//        String content = rs.getString("content");
//        String contactName = rs.getString("name");
//        String contactNumber = rs.getString("phone");
//        System.out.println(noticeId + ", " + title + ", " + content + ", " + contactName + ", " + contactNumber);
//      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException sqlEx) { } // ignore

        rs = null;
      }

      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException sqlEx) { } // ignore

        stmt = null;
      }
      
      if (cnx != null) {
        try {
          cnx.close();
        } catch (SQLException sqlEx) { } //ignore
      }

    }

  }

}
