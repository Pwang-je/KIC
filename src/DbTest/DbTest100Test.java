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
  PreparedStatement pstmt, pstmt_2;
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

      // sangdata 출력하는 sql.

      String sql = "SELECT * FROM SANGDATA ORDER BY CODE";
      pstmt = conn.prepareStatement(sql);
      rs_1 = pstmt.executeQuery();

      // sangdata 출력.
      int cou = 0;
      txt_area.append("코드" + "\t" + "상품명" + "\t" + "수량" + "\t" + "단가" + "\n"); // txt_Area 에 이런걸 갖다 붙일꺼다. 단순 보여지는 부분.
      while (rs_1.next()) {
        String str = (rs_1.getString(1) + "\t" +
            rs_1.getString(2) + "\t" +
            rs_1.getString(3) + "\t" +
            rs_1.getString(4) + "\n");
        txt_area.append(str);
        cou++;
      }
      txt_area.append("건수: " + cou);

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


  private void update() {

    // sql 데이터 업로드 부분.
    try {
      String usql = "INSERT INTO SANGDATA VALUES (?,?,?,?)";
      pstmt_2 = conn.prepareStatement(usql);

      // values 로 받은 저 코드,상품명,수량,단가 자체가 private void layInit 에서 txt_c 로 정했기 때문에,
      // 값을 받을 때도 txt_c로 받아야 하는거임. 근데, txt 이기 때문에 (=string) 거기엔 숫자가 들어갈테고,
      // 숫자로 바꾸기 위해서 parseInt 를 써서 변환시키는거임.
      pstmt_2.setInt(1, Integer.parseInt(txt_c.getText()));
      pstmt_2.setString(2,txt_g.getText());
      pstmt_2.setInt(3, Integer.parseInt(txt_q.getText()));
      pstmt_2.setInt(4, Integer.parseInt(txt_u.getText()));
      pstmt_2.executeUpdate();
      txt_area.setText(null);   // 업로드 한 후~ txt_area 초기화한다음 결과값 나오게 함. 이부분!!!! 먼이ㅏ러밍하ㅓㅁㄴㅇ
      accDB();


    } catch (Exception e1) {
      System.out.println("update 실패" + e1.getMessage());
    }


  }



  @Override
  public void actionPerformed(ActionEvent e) {

    update();

    txt_c.setText("");
    txt_g.setText("");
    txt_u.setText("");
    txt_q.setText("");


  }


  public static void main(String[] args) {
    new DbTest100Test();
  }

}
