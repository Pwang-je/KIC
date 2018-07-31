package DbTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest5Pooling {

  Connection connection;
  Statement statement;
  ResultSet resultSet;
  DBConnectionMgr pool;

  public DbTest5Pooling() {
    try {
      pool = DBConnectionMgr.getInstance();
      accDB();
    } catch (Exception e) {
      System.out.println("연결실패: " + e.getMessage());
    }

  }

  private void accDB() {
    try {
      connection = pool.getConnection();
      String sql = "SELECT * FROM SANGDATA";
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);

      while (resultSet.next()) {
        System.out.println(resultSet.getString(1) + " " +
            resultSet.getString(2) + " " +
            resultSet.getString(3) + " " +
            resultSet.getString(4));
      }

    } catch (Exception e) {
      System.out.println("accDB err: " + e.getMessage());
    } finally {
      pool.freeConnection(connection, statement, resultSet);
    }

  }

  public static void main(String[] args) {
    new DbTest5Pooling();
  }

}
