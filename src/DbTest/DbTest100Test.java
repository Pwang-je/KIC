package DbTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest100Test extends JFrame implements ActionListener {

  JButton btnAdd;
  JTextArea txt_area = new JTextArea();
  JTextField txt_c, txt_g, txt_q, txt_u;

  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs_1;

  public DbTest100Test() {

    setTitle("상품 처리");

    layInit();
    accDB();

    // 레이아웃
    setBounds(200, 200, 500, 300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void accDB() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");

      /*stmt이름 = conn.prepareStatement(sql이름);
      sql이름 = "sql query";
      resultset이름 = stmt이름.exequery(sql이름);
      resultset이름.next();*/

      display();    // DISPLAY;
    } catch (Exception e) {
      System.out.println("accDB err: " + e);
    }
  }

  private void layInit() {
    txt_c = new JTextField("",5);
    txt_g = new JTextField("",5);
    txt_q = new JTextField("",5);
    txt_u = new JTextField("",5);

    JPanel panel_1 = new JPanel();
    panel_1.add(new JLabel("코드 "));
    panel_1.add(txt_c);
    panel_1.add(new JLabel("품명 "));
    panel_1.add(txt_g);
    panel_1.add(new JLabel("수량 "));
    panel_1.add(txt_q);
    panel_1.add(new JLabel("단가 "));
    panel_1.add(txt_u);
    add("North", panel_1);
    btnAdd = new JButton("추가");
    panel_1.add(btnAdd);

    btnAdd.addActionListener(this);

    txt_area.setEditable(false);
    txt_area.setSize(500,500);
    JScrollPane pane = new JScrollPane(txt_area);
    add("Center", pane);

  }

  private void display() {

    try {
      /*String sql = "SELECT * FROM SANGDATA WHERE CODE=?,?,?,?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(, )
      rs = pstmt.executeQuery()
      if (rs.next()) {
      sout(rs.getString("code"));
      sout(rs.getString("sang"));
      sout(rs.getString("su"));
      sout(rs.getString("dan"));
*/

      while ( rs_1.next()) {
        System.out.println(
            rs_1.getString(1) +
            rs_1.getString(2) +
            rs_1.getString(3) +
            rs_1.getString(4)
        );
      }
    } catch (Exception e) {
      System.out.println("display 안댐" + e);
    }
  }


  @Override
  public void actionPerformed(ActionEvent e) {

    try {
      // 자료 추가
      String isql = "INSERT INTO SANGDATA VALUES(?,?,?,?)";
      pstmt = conn.prepareStatement(isql);
      pstmt.setString(1,"CODE");
      pstmt.setString(2, "SANG");
      pstmt.setString(3, "SU") ;
      pstmt.setString(4, "DAN"); // 물음표 순서대로 1,2,3,4가 됨.
      int re = pstmt.executeUpdate();
      if ( re == 1 ) {
        System.out.println("추가 성공");
      } else {
        System.out.println("추가 실패");
      }
    } catch (Exception e1) {
      System.out.println("action event 안댐" + e1.getMessage());
    }
    display();


  }


  public static void main(String[] args) {
    new DbTest100Test();
  }
}
