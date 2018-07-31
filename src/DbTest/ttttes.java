/*
package db.pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class DbtestExam2 extends JFrame implements ActionListener{
  JButton btnF, btnP, btnN, btnL;
  JTextField txtNo, txtName, txtJik, txtBuName, txtBuTel;
  JTextArea txtGogek = new JTextArea();

  Connection conn;
  Statement stmtJik, stmtGogek;
  ResultSet rsJik, rsGogek;
  String sqlJik;

  public DbtestExam2() {
    setTitle("고객 정보 열람");

    layInit();
    accDb();

    setBounds(200, 200, 700, 450);
    setVisible(true);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          if(rsJik != null) rsJik.close();
          if(stmtJik != null) stmtJik.close();
          if(rsGogek != null) rsJik.close();
          if(stmtGogek != null) stmtJik.close();
          if(conn != null) conn.close();
        } catch (Exception e2) {
        }
        System.exit(0);
      }
    });
  }




  private void layInit() {
    txtNo = new JTextField("", 5);
    txtName = new JTextField("", 8);
    txtJik = new JTextField("", 5);
    txtBuName = new JTextField("", 5);
    txtBuTel = new JTextField("", 10);

    JPanel panel1 = new JPanel();
    panel1.add(new JLabel("사번 : "));
    panel1.add(txtNo);
    panel1.add(new JLabel("직원명 : "));
    panel1.add(txtName);
    panel1.add(new JLabel("직급 : "));
    panel1.add(txtJik);
    panel1.add(new JLabel("부서명 : "));
    panel1.add(txtBuName);
    panel1.add(new JLabel("부서전화 : "));
    panel1.add(txtBuTel);

    add("North",panel1);

    btnF = new JButton("|<<");
    btnP = new JButton("<");
    btnN = new JButton(">");
    btnL = new JButton(">>|");

    JPanel panel3 = new JPanel();
    panel3.add(btnF);
    panel3.add(btnP);
    panel3.add(btnN);
    panel3.add(btnL);
    add("South",panel3);

    btnF.addActionListener(this);
    btnP.addActionListener(this);
    btnN.addActionListener(this);
    btnL.addActionListener(this);

    txtGogek.setEditable(false);
    JScrollPane pane = new JScrollPane(txtGogek);
    add("Center", pane);
  }






  private void accDb() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
      stmtJik = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      sqlJik = "select jikwon_no, jikwon_name, jikwon_jik, buser_name, buser_tel "
          + "from jikwon left outer join buser on buser_no = buser_num order by jikwon_no";

      rsJik = stmtJik.executeQuery(sqlJik);
      rsJik.next();

      display();
    } catch (Exception e) {
      System.out.println("accDb err : " + e);
    }
  }




  private void display() {
    try {
      txtNo.setText(rsJik.getString("jikwon_no"));
      txtName.setText(rsJik.getString("jikwon_name"));
      txtJik.setText(rsJik.getString("jikwon_jik"));
      txtBuName.setText(rsJik.getString("buser_name"));
      txtBuTel.setText(rsJik.getString("buser_tel"));

      stmtGogek = conn.createStatement();

      displayGogek();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "자료의 처음 또는 마지막 입니다.");
    }
  }






  private void displayGogek() {
    try {
      String sqlGogek = "select gogek_no, gogek_name, " +
          "case " +
          "when substr(gogek_jumin,8,1)=1 then '남' " +
          "else '여' end as gogek_gen, " +
          "to_char(sysdate, 'yy')+101 - substr(gogek_jumin,1,2) as gogek_nai from gogek";

      sqlGogek += " where gogek_damsano = " +  rsJik.getString("jikwon_no");
      rsGogek = stmtGogek.executeQuery(sqlGogek);

      txtGogek.setText(null);

      txtGogek.append("고객번호\t고객명\t성별\t나이\n");

      int cou = 0;
      while(rsGogek.next()) {
        String str = rsGogek.getString("gogek_no") + "\t" +
            rsGogek.getString("gogek_name") + "\t" +
            rsGogek.getString("gogek_gen") + "\t" +
            rsGogek.getString("gogek_nai") + "\n";
        txtGogek.append(str);
        cou++;
      }

      txtGogek.append("인원 수 : " + cou + "명");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      if(e.getSource() == btnF) rsJik.first();
      else if(e.getSource() == btnP) rsJik.previous();
      else if(e.getSource() == btnN) rsJik.next();
      else if(e.getSource() == btnL) rsJik.last();

      display();
    } catch (Exception e2) {
    }
  }

  public static void main(String[] args) {
    new DbtestExam2();
  }
}
*/
