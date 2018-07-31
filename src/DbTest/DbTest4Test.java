package DbTest;


import java.awt.TextArea;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest4Test extends JFrame implements ActionListener {

  JButton btnF, btnP, btnN, btnL;
  JTextField txt_sa, txt_name, txt_rank, txt_def, txt_dnum;
  TextArea txt_area = new TextArea();

  Connection conn;
  Statement stmt_jik, stmt_gogek;
  ResultSet rs_jik, rs_gogek;

  public DbTest4Test() {
    setTitle("레코드 이동 연습");

    layInit();
    accDB();

    setBounds(200,200,500,300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } // DbTest4Test();

  private void accDB() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
      stmt_jik = conn.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY
      );

      // SQL QUERY JIKWON;
      String sql_jik = "select jikwon_no, jikwon_name, jikwon_jik, buser_name, buser_tel "
          + "from jikwon left outer join buser on buser_no = buser_num order by jikwon_no";

          /*"SELECT JIKWON_NO, JIKWON_NAME, JIKWON_JIK, BUSER_NAME, BUSER_TEL" +
              "FROM JIKWON LEFT OUTER JOIN BUSER ON BUSER_NO = BUSER_NUM ORDER BY JIKWON_NO";*/
      rs_jik = stmt_jik.executeQuery(sql_jik);
      rs_jik.next();

      display();
    } catch (Exception e) {
      System.out.println("accDB err: " + e.getMessage());
    }
  } // accDB();

  private void layInit() {

    txt_sa = new JTextField("test",5);
    txt_def = new JTextField("def",5);
    txt_name = new JTextField("name",8);
    txt_rank = new JTextField("rank", 5);
    txt_dnum = new JTextField("dnum", 5);

    JPanel panel_top = new JPanel();

    panel_top.add(new JLabel("사번: "));
    panel_top.add(txt_sa);

    panel_top.add(new JLabel("부서: "));
    panel_top.add(txt_def);

    panel_top.add(new JLabel("이름: "));
    panel_top.add(txt_name);

    panel_top.add(new JLabel("직급: "));
    panel_top.add(txt_rank);

    panel_top.add(new JLabel("부서번호: "));
    panel_top.add(txt_dnum);
    add("North", panel_top);


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
    add("South",panel_2);

    btnF.addActionListener(this);
    btnN.addActionListener(this);
    btnP.addActionListener(this);
    btnL.addActionListener(this);

    // 텍스트 출력 부분
    panel_top.add(txt_area);
    add("Center", panel_top);

    /*txt_area.setEditable(false);
    JScrollPane pane = new JScrollPane(txt_area);
    add("CENTER", pane);*/

  } // layInit();

  private void display() {
    try {
      txt_sa.setText(rs_jik.getString("JIKWON_NO"));
      txt_name.setText(rs_jik.getString("JIKWON_NAME"));
      txt_rank.setText(rs_jik.getString("JIKWON_JIK"));
      txt_def.setText(rs_jik.getString("BUSER_NAME"));
      txt_dnum.setText(rs_jik.getString("BUSER_NO"));

      stmt_gogek = conn.createStatement();
      disp_gogek();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "자료의 처음 또는 마지막 입니다.");
    }
  } // display();

  private void disp_gogek() {

    try {
      String sql_gogek = "select gogek_no, gogek_name, " +
          "case " +
          "when substr(gogek_jumin,8,1)=1 then '남' " +
          "else '여' end as gogek_gen, " +
          "to_char(sysdate, 'yy')+101 - substr(gogek_jumin,1,2) as gogek_nai from gogek";


         /* "SELECT GOGEK_NO, GOGEK_NAME, " +
          "CASE " + "WHEN SUBSTR(GOGEK_JUMIN, 8, 1)=1 THEN '남'" +
          "ELSE '여' END AS GOGEK_GEN, " +
          "TO_CHAR(SYSDATE, 'YY')+101 - SUBSTR(GOGEK_JUMIN, 1, 2) AS GOGEK_NAI FROM GOGEK";*/

      sql_gogek += " WHERE GOGEK_DAMSANO = " + rs_jik.getString("JIKWON_NO");

      rs_gogek = stmt_gogek.executeQuery(sql_gogek);

      txt_area.setText(null); // 텍스트창 일단 초기화.
      txt_area.append("고객번호/t고객명/t성별/t나이");

      int cou = 0;
      while (rs_gogek.next()) {
        String str = rs_gogek.getString("GOGEK_NO") +
            rs_gogek.getString("GOGEK_NAME") +
            rs_gogek.getString("GOGEK_GEN") +
            rs_gogek.getString("GOGEK_NAI");
        txt_area.append(str);
        cou++;
      }
      txt_area.append("인원 수 : " + cou + "명");
    } catch (Exception e) {

    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      if (e.getSource() == btnF) rs_jik.first();  // 위에 stmt 역방향써줘서 이렇게 됨.
      else if (e.getSource() == btnP) rs_jik.previous();
      else if (e.getSource() == btnN) rs_jik.next();
      else if (e.getSource() == btnL) rs_jik.last();

      display();
    } catch (Exception e1) {

    }
  } // actionPerformed();

  public static void main(String[] args) {
    new DbTest4Test();
  }

}
