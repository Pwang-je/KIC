package DbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest6Execute {

  Connection conn;
  Statement stmt;
  ResultSet rs;

  DbTest6Execute() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");

      process();

    } catch (Exception e) {
      System.out.println("Dbtest6 err: " +e.getMessage());
    }
  }

  private void process() {
    try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
      stmt = conn.createStatement();
      boolean b = false;

      // execute(SQL) : select 는 true, 나머지는 false 를 반환.

      b = stmt.execute("UPDATE SANGDATA SET SANG = '소화기' WHERE CODE = 1");  // EXECUTE 에서 UPDATE 하는 법.
      System.out.println("Update 후: " + b);   // false;

      int re = stmt.getUpdateCount();   // update 가 이루어 진걸 확인하기 위함.
      System.out.println("update 수정 : " + re);
      if (re >= 1) {
        System.out.println("성공");
      } else {
        System.out.println("실패");
      }

      b = stmt.execute("SELECT * FROM SANGDATA"); // EXECUTE QUERY = EXECUTE (SQL)
      System.out.println("SELECT 후 : " + b);   // true;
      rs = stmt.getResultSet();
      while (rs.next()) {
        System.out.println(rs.getString(1) + " " +
                            rs.getString(2));
      }
    } catch (Exception e) {
      System.out.println("Process err: " + e.getMessage());
    } finally {
      try {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
      } catch (Exception e) {

      }
    }
  }

  public static void main(String[] args) {
    new DbTest6Execute();
  }
}
