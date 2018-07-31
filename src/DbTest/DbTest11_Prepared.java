package DbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbTest11_Prepared {

  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;

  public DbTest11_Prepared() {
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");

      // 전체 자료 보기
      String sql = "SELECT * FROM SANGDATA ORDER BY CODE";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        System.out.println(rs.getString(1));
        System.out.println(rs.getString(2));
        System.out.println(rs.getString(3));
        System.out.println(rs.getString(4));
      }

      System.out.println("--------------------------------");

      // 부분 자료 읽기
      String co = "1";  // 원래 외부값을 받아와야됨. 지금은 없으니 일단 만들어둠.
      /*sql = "SELECT * FROM SANGDATA WHERE CODE =" + co;   // 이렇게 쓰면 안댐.*/
      sql = "SELECT * FROM SANGDATA WHERE CODE =?"; // 이렇게 써야됨.
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,co);  // =? 가 있을 때 써줌.
      rs = pstmt.executeQuery();
      if (rs.next()) {
        System.out.println(rs.getString(1));
        System.out.println(rs.getString("sang"));
        System.out.println(rs.getString("su"));
        System.out.println(rs.getString("dan"));
      } else {
        System.out.println("그런자료 없음");
      }

      // 자료 추가
      /*String isql = "INSERT INTO SANGDATA VALUES(?,?,?,?)";
      pstmt = conn.prepareStatement(isql);
      pstmt.setString(1,"10" );
      pstmt.setString(2, "신상품");
      pstmt.setInt(3, 100);
      pstmt.setString(4, "5000"); // 물음표 순서대로 1,2,3,4가 됨.
      int re = pstmt.executeUpdate();
      if ( re == 1 ) {
        System.out.println("추가 성공");
      } else {
        System.out.println("추가 실패");
      }*/

      // 자료 수정
      /*String usql = "UPDATE SANGDATA SET SANG=?, SU=?, DAN=? WHERE CODE=?";
      pstmt = conn.prepareStatement(usql);
      pstmt.setString(1, "초코바");
      pstmt.setInt(2, 8);
      pstmt.setInt(3, 3000);
      pstmt.setInt(4, 1);
      pstmt.executeUpdate();*/


      // 자료 삭제
      String dsql = "DELETE FROM SANGDATA WHERE CODE=?";
      pstmt = conn.prepareStatement(dsql);
      pstmt.setString(1, "10");

      if (pstmt.executeUpdate() > 0) {  // 추가때처럼 변수로 해도 되고, 직접 실행문을 써도 됨.
        System.out.println("삭제 성공");
      } else {
        System.out.println("삭제 실패");
      }


    } catch (Exception e) {
      System.out.println("err : " +e.getMessage());
    } finally {
//      if (rs != null) rs.close();
//      if (conn != null) conn.close();
//      if (pstmt != null) pstmt.close();
    }
  }


  public static void main(String[] args) {
    new DbTest11_Prepared();
  }

}
