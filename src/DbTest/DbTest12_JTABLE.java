package DbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class DbTest12_JTABLE extends JFrame {

  String[][] datas = new String[0][5];
  String [] title = {"코드","품명","수량", "단가", "금액"};
  DefaultTableModel model;
  JTable table;
  JLabel lblCount;

  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;


  public DbTest12_JTABLE() {
    setTitle("테이블 연습");
    layInit();
    accDB();

    setBounds(200, 100, 300,250);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  private void accDB() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");

      pstmt = conn.prepareStatement("select * from sangdata order by code asc");
      rs = pstmt.executeQuery();

      int cou = 0;
      while (rs.next()) {
        String code = rs.getString("code");
        String sang = rs.getString("sang");
        String su = rs.getString("su");
        String dann = rs.getString("dan");
        int kum = rs.getInt("su") * rs.getInt("dan");

        String []imsi = {code,sang,su,dann, Integer.toString(kum)};
        model.addRow(imsi);
        cou++;

      }
      lblCount.setText("건수: " + cou);
    } catch (Exception e) {

    } finally {

    }
  }

  private void layInit() {
    model = new DefaultTableModel(datas, title);
    table = new JTable(model);
    JScrollPane pane = new JScrollPane(table);

    add("Center", pane);

    lblCount = new JLabel("건수: 0");
    add("South", lblCount);
  }

  public static void main(String[] args) {
    new DbTest12_JTABLE();
  }
}
