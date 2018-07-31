package Pack8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;

public class nana extends JFrame implements ActionListener {

  private Connection conn;
  private Statement stmt;
  private ResultSet rs;



  public nana() {
    // const.

    accessDb();


  }

  private void accessDb() {

    try {
      Class.forName("oracle.jbdc.driver.OracleDriver");
    } catch (Exception e) {
      System.out.println("Driver Loading Fail" + e);
    }

  }


  @Override
  public void actionPerformed(ActionEvent e) {

    try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott" , "tiger");
      stmt = conn.createStatement();
      String deSql = " ";

      deSql = "SELECT JIKWON_NAME FROM JIKWON";

    } catch (Exception e1) {
      System.out.println("error: " + e1);
    } finally {
      try {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
      } catch (Exception e2) {

      }
    }


  }

  public static void main(String[] args) {
    new nana();
  }

}

