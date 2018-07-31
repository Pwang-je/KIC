package DbTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;



  class I_dbtest_select {

    Connection conn;
    CallableStatement cstate;
    OracleCallableStatement ostate;
    ResultSet result;

    public I_dbtest_select() {
      try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

        cstate = conn.prepareCall("{call pro2(?)}"); //출력용 아규먼트, in은 입력용
        cstate.registerOutParameter(1, OracleTypes.CURSOR); //커서에 담겨져 넘어욤
        cstate.execute();
        ostate = (OracleCallableStatement)cstate;
        result = ostate.getCursor(1);

        while(result.next()) {
          System.out.println(result.getString(1));
        }



      } catch (Exception e) {
        // TODO: handle exception
      } finally {
        try {
          if(result != null) result.close();
          if(cstate != null) cstate.close();
          if(ostate != null) ostate.close();
          if(conn != null) conn.close();

        } catch (Exception e2) {
          // TODO: handle exception
        }
      }
    }


    public static void main(String[] args) {
      // TODO Auto-generated method stub
      new I_dbtest_select();

    }
  }

