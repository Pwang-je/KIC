package DbTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DbTest4RecMove extends JFrame implements ActionListener {

  JButton btnF, btnP, btnN, btnL;
  JTextField txtNo_sa, txtName_sa, txtNo_name, txtName_name, txtNo_rank, txtName_rank,
              txtNo_def, txtName_def, txtNo_bunum, txtName_bunum;
  Connection conn;
  Statement stmt;
  ResultSet rs;

  public DbTest4RecMove() {
    setTitle("레코드 이동 연습");

    layInit();
    accDB();

    setBounds(200,200,600,600);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }   // DbTest4RecMove();

  private void layInit() {  // 모양 만들기

    // 사번
    txtNo_sa = new JTextField("",5);
    JPanel panel_1 = new JPanel();
    panel_1.add(new JLabel("사번: "));
    panel_1.add(txtNo_sa);
    add("North", panel_1);

    // 직원명
    txtNo_name = new JTextField("",5);
    JPanel panel_3 = new JPanel();
    panel_3.add(new JLabel("직원명"));
    panel_3.add(txtNo_name);
    add("South", panel_3);

    // 직급
    txtNo_rank = new JTextField("",5);
    JPanel panel_4 = new JPanel();
    panel_4.add(new JLabel("직급"));
    panel_4.add(txtNo_rank);
    add("South", panel_4);

    // 부서명
    txtNo_def = new JTextField("",5);
    txtName_def = new JTextField("", 5);
    JPanel panel_5 = new JPanel();
    panel_5.add(new JLabel("부서명"));
    panel_5.add(txtNo_def);
    panel_5.add(txtName_def);
    add("North", panel_5);

    // 부서번호
    txtNo_bunum = new JTextField("",5);
    txtName_bunum = new JTextField("", 5);
    JPanel panel_6 = new JPanel();
    panel_6.add(new JLabel("부서번호"));
    panel_6.add(txtNo_bunum);
    panel_6.add(txtName_bunum);
    add("North", panel_6);

    // 패널부분
    btnF = new JButton("|<<");
    btnN = new JButton("<");
    btnP = new JButton(">");
    btnL = new JButton(">>|");

    JPanel panel_2 = new JPanel();
    panel_2.add(btnF);
    panel_2.add(btnN);
    panel_2.add(btnP);
    panel_2.add(btnL);
    add("Center", panel_2);

    btnF.addActionListener(this);
    btnN.addActionListener(this);
    btnP.addActionListener(this);
    btnL.addActionListener(this);





  }   // layInit();

  private void accDB() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
      // stmt = conn.createStatement();  // rs.next() 만 가능함.
      stmt = conn.createStatement(    // 이렇게 쓰면 역방향도 가능함.
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY
      );

      /*String sql = " ";
      rs = stmt.executeQuery(sql);*/
      rs = stmt.executeQuery("SELECT JIKWON_NO, JIKWON_NAME FROM JIKWON ORDER BY JIKWON_NO");
      rs.next();

      display();
    } catch (Exception e) {
      System.out.println("accDB err: ");
    }

  } // accDB();

  private void display() {
    try {
      txtNo_sa.setText(rs.getString("JIKWON_NO"));
      txtName_sa.setText(rs.getString("JIKWON_NAME"));
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "자료의 처음 또는 마지막 입니다.");
    }
  } // display();


  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      if (e.getSource() == btnF) rs.first();  // 위에 stmt 역방향써줘서 이렇게 됨.
      else if (e.getSource() == btnP) rs.previous();
      else if (e.getSource() == btnN) rs.next();
      else if (e.getSource() == btnL) rs.last();

      display();
    } catch (Exception e1) {

    }

  }

  public static void main(String[] args) {
    new DbTest4RecMove();
  }


}
