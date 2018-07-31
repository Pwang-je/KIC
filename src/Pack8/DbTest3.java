package Pack8;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest3 extends JFrame implements ActionListener {

  JButton btnAll = new JButton("전체");
  JButton btnM = new JButton("남");
  JButton btnF = new JButton("여");
  JTextArea txtResult = new JTextArea();

  // SQL 담당.
  Connection conn;
  Statement stmt;
  ResultSet rs;



  public DbTest3() {

    setTitle("고객 테이블 출력");

    layInit();
    accDb();

    setBounds(200,200,300,250);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void layInit() {
    JPanel panel = new JPanel();
    panel.add(btnAll);
    panel.add(btnM);
    panel.add(btnF);

    txtResult.setEditable(false);	// read only.
    JScrollPane pane = new JScrollPane(txtResult);

    add("Center", pane);
    add("North", panel);

    btnAll.addActionListener(this);
    btnM.addActionListener(this);
    btnF.addActionListener(this);

  }


  private void accDb() {

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");

    } catch (Exception e) {
      System.out.println("드라이버 로딩 실패:" + e);
    }



  }



  @Override
  public void actionPerformed(ActionEvent e) {

    try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
      stmt = conn.createStatement();
      String sql = " ";

      sql = "SELECT GOGEK_NO, GOGEK_NAME, GOGEK_JUMIN FROM GOGEK";

      if(e.getSource() == btnAll) {

      } else if (e.getSource() == btnM) {
//				sql += " WHERE GOGEK_JUMIN LIKE '%-1%'";
        sql += " WHERE SUBSTR(GOGEK_JUMIN, 8, 1)=1";
      } else if (e.getSource() == btnF) {
        sql += " WHERE SUBSTR(GOGEK_JUMIN, 8, 1)=2";
      }


      /*System.out.println(sql);	// 확인용.
       */
      txtResult.setText(null);	// ""  처음에 깨끗하게 비우기용.

      rs = stmt.executeQuery(sql);
      int cou = 0;
      while(rs.next()) {
//				System.out.println(rs.getString(2));

        String str = rs.getString("GOGEK_NO") + "\t" +
            rs.getString("GOGEK_NAME") + "\t" +
            rs.getString("GOGEK_JUMIN") + "\n";
        txtResult.append(str);
        cou++;

      }
      txtResult.append("인원수 : " + cou + " 명");
    } catch (Exception e2) {
      System.out.println("actionPerformed err:" + e2);
    } finally {
      try {
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();
      } catch (Exception e3) {

      }

    }


  }


  public static void main(String[] args) {

    new DbTest3();

  }





}
