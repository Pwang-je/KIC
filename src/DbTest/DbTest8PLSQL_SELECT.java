package DbTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DbTest8PLSQL_SELECT {

  Connection conn;
  CallableStatement cstmt;
  OracleCallableStatement ocstmt;
  ResultSet rs;

  public DbTest8PLSQL_SELECT() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");

      cstmt = conn.prepareCall("{CALL PRO_SEL(?)}");
      cstmt.registerOutParameter(1, OracleTypes.CURSOR);
      cstmt.execute();

      ocstmt = (OracleCallableStatement)cstmt;
      rs = ocstmt.getCursor(1); // ? 로 들어감.
      while (rs.next()) {
        System.out.println(rs.getString(1) + " " +
            rs.getString(2) + " " +
            rs.getString(3));
      }
    } catch (Exception e) {
      System.out.println("err: " + e.getMessage());
    } finally {
      try {
        if (rs != null) rs.close();
        if (conn != null) conn.close();
        if (cstmt != null) cstmt.close();
        if (ocstmt != null) ocstmt.close();
      } catch (Exception e) {

      }
    }

  }

  public static void main(String[] args) {
    new DbTest8PLSQL_SELECT();
  }

}
