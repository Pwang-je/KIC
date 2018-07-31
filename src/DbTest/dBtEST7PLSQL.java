package DbTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class dBtEST7PLSQL {

  Connection conn;
  CallableStatement cstmt;  // 프로시저 처리용.

  public dBtEST7PLSQL() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");

    } catch (Exception e) {
      System.out.println("Dbtest7 err: " + e.getMessage());
    }
  }

  private void process() {
    try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
      cstmt = conn.prepareCall("{call pro_del(?)}");   // exec ~
      cstmt.setInt(1, 10);
      int re = cstmt.executeUpdate();
      if (re >= 1) {
        System.out.println("삭제 성공");
      } else {
        System.out.println("삭제 실패");
      }

    } catch (Exception e) {
      System.out.println("process err");
    } finally {
      try {
        if (cstmt != null) cstmt.close();
        if (conn != null) conn.close();
      } catch (Exception e) {

      }
    }
  }

  public static void main(String[] args) {
    new dBtEST7PLSQL();
  }
}
