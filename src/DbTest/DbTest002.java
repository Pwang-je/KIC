/*
package DbTest;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DbTest002 extends JFrame implements ActionListener {

  // 2.layout 관련 멤버변수 확인
  private TextArea txt_area = new TextArea();

  // 3. table 관련 멤버변수 확인
  private String [][] datas = new String[0][4];
  private String[] title = {"부서번호","부서명","부서전화","부서위치"};
  private DefaultTableModel tmodel = new DefaultTableModel(datas, title);
  private JTable table = new JTable(tmodel);

  // 1. db 접속, sql 실행 관련 멤버 변수.
  // pstmt2 와 rs2 가 빠져있음. ??????
  Connection conn;
  PreparedStatement pstmt, pstmt2;
  ResultSet rs, rs_2;


  public DbTest002() {    // Const

    // table 의 열과 폭
    table.getColumnModel().getColumn(0).setPreferredWidth(30);
    JScrollPane tPane = new JScrollPane(table);
    add("Center", tPane);

    setTitle("부서별 직원정보");
//    setResizable(false);  리사이즈 조정 방지용.
    setBounds(200, 200, 500, 600);
    setVisible(true);

    layInit();
    accDb();


    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        table = (JTable)e.getComponent();
        tmodel = (DefaultTableModel)table.getModel();

        int rowIdx = table.getSelectedRow(); // 선택된 행 인덱스
        int colIdx = table.getSelectedColumn(); // 선택된 컬럼 인덱스
        if(table.getColumnName(colIdx).equals("부서명")) {
          //                  System.out.println(table.getValueAt(rowIdx, 0)); // 선택된 행의 0번째컬럼(부서번호) 출력
          dispData((String)table.getValueAt(rowIdx, 0)); // 선택된 행의 부서번호에 해당하는 직원+고객 데이터 출력 메서드 호출
        }
      }
    });



  }

  private void accDb() {

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
    } catch (Exception e) {
      System.out.println("DB 접속실패" + e);
      return;
    } // try,catch;

    dispData();
  }

  private void dispData() {

    try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

      // 부서출력하는 sql 부분.
      String bsql = "SELECT * FROM BUSER";
      pstmt = conn.prepareStatement(bsql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        String []bRow = {
            rs.getString("BUSER_NO"),
            rs.getString("BUSER_NAME"),
            rs.getString("BUSER_TEL"),
            rs.getString("BUSER_LOC")
        };
        tmodel.addRow(bRow);
      }

      // 1. 직원 이름만 가져오기.
      String sql_name = "select jikwon_name, jikwon_no from jikwon where buser_num = ?";
      pstmt = conn.prepareStatement(sql_name);
      rs = pstmt.executeQuery();

      int jikCnt = 0;
      while (rs.next()) {

        // 2. 해당 직원의 고객들 출력하기.
        String sql_gogeks = "select gogek_name, gogek_tel from gogek where gogek_damsano = ?";
        pstmt2 = conn.prepareStatement(sql_gogeks);
        pstmt2.setString(1, rs.getString("jikwon_no")); //  직원 번호 조건.
        rs = pstmt2.executeQuery();

        txt_area.append("직원명: " + rs.getString("jikwon_name") + "\n");


        // 3.
        int cnt = 0;  // 담당고객 수
        while (rs_2.next()) {

          if (cnt==0) {
            txt_area.append("관리고객은\n");
            txt_area.append("고객명\n고객전화\n주민번호\n");
          }

          txt_area.append(rs_2.getString("gogek_name") + "\t" +
                          rs_2.getString("gogek_tel") + "\t" +
                          rs_2.getString("gogek_jumin") + "\n"
          );
          cnt++;    // 고객 담당 수 추가.



        }



      } // while(rs.next()) 의 끝.



    } catch (Exception e1) {

    } finally {
      try {
        if(rs != null) rs.close();
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
      } catch (Exception e2) {

      }
    }
  } // dispData();

  private void Cable() {


    try {


    } catch (Exception e) {

    } finally {
      try {
        if(rs != null) rs.close();
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
      } catch (Exception e2) {

      }
    }




  }



  private void layInit() {

    // 정보가 보여질 text_Area
//    txt_area.setEditable(false);
//    txt_area.setSize(300,400);
    JScrollPane txt_pane = new JScrollPane(txt_area);
    add("South", txt_pane);

  }





  @Override
  public void actionPerformed(ActionEvent e) {

  }

  public static void main(String[] args) {
    new DbTest002();
  }

}
*/
