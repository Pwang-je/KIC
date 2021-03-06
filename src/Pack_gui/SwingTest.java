package Pack_gui;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SwingTest extends JFrame implements ActionListener {

  JTextField txtName,txtAge;
  JLabel lblResult;
  ButtonGroup buttonGroup = new ButtonGroup();    // 버튼은 그룹으로 만듬.
  JRadioButton rdoM, rdoF;


  public SwingTest() {
    super("이벤트 연습");
    layInit();

    setBounds(200,200,300,300);
    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
  private void layInit() {

    setLayout(new GridLayout(5,1));

    // 1행
    JLabel lbl1 = new JLabel("이름 : ");
    txtName = new JTextField(" ", 20);
    JPanel pn1 = new JPanel();
    pn1.add(lbl1);
    pn1.add(txtName);
    add(pn1);

    // 2행
    JLabel lbl2 = new JLabel("나이 : ");
    txtAge = new JTextField(" ", 20);
    JPanel pn2 = new JPanel();
    pn2.add(lbl2);
    pn2.add(txtAge);
    add(pn2);

    // 3행
    rdoM = new JRadioButton("남자", true);
    rdoF = new JRadioButton("여자", false);
    buttonGroup.add(rdoM);
    buttonGroup.add(rdoF);
    JPanel pn3 = new JPanel();
    pn3.add(new JLabel("성별 선택"));
    pn3.add(rdoM);
    pn3.add(rdoF);
    add(pn3);

    // 4행
    JButton btnOk = new JButton("확인");
    btnOk.addActionListener(this);
    JPanel pn4 = new JPanel();
    pn4.add(btnOk);
    add(pn4);

    // 5행
    lblResult = new JLabel("결과 : " + JLabel.CENTER);
    add(lblResult);



  }

  @Override
  public void actionPerformed(ActionEvent e) {

    // 입력자료 유효성 검사
    if (txtName.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "이름을 입력하라구여");
      txtName.requestFocus();   // 마우스 focus
      return;
    }

    if (txtAge.getText().equals("")) {
      JOptionPane.showMessageDialog(this, "나이를 입력하라구여");
      txtAge.requestFocus();   // 마우스 focus
      return;
    }

    // 나이 숫자 여부 판단.
    int nai = 0;
    try {
      nai = (Integer.parseInt(txtAge.getText()));
    } catch (Exception e1) {
      JOptionPane.showMessageDialog(this, "나이는 숫자만 입력된다구여");
      txtAge.requestFocus();   // 마우스 focus
      return; // actionPerformed 빠져나가는 return;
    }

//    System.out.println(rdoM.isSelected() + " " + rdoF.isSelected());

    String gender = " ";
    if (rdoM.isSelected()) {
      gender = "남";
    } else{
      gender = "여";
    }

    String ss = "결과 : " + txtName.getText() + "님의 나이는 " +
        txtAge.getText() + " " + gender;


    lblResult.setText(ss);
  }

  public static void main(String[] args) {
    new SwingTest();
  }

}
