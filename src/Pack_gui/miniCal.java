package Pack_gui;


import java.awt.GridLayout;
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

public class miniCal extends JFrame implements ActionListener {

  JTextField txtNum_1, txtNum_2; // string. -> int. integer.parseInt.
  JLabel lbl_Result;
  ButtonGroup btngroup = new ButtonGroup();
  JRadioButton rdoPlus, rdoMinus, rdoMulti, rdoDiv;
  JButton btn_Calc, btn_Clear, btn_Exit;


  public miniCal() {

    super("미니 계산기");
    layoutInit();

    setBounds(400,400,600,600);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
  // public miniCal();

  private void layoutInit() {

    setLayout(new GridLayout(5,1));

    // 1 rows 숫자 1
    JLabel lbl_1 = new JLabel("숫자 1: ");
    txtNum_1 = new JTextField(" ",18);
    JPanel panel_1 = new JPanel();
    panel_1.add(lbl_1);
    panel_1.add(txtNum_1);
    add(panel_1);

    // 2 rows 숫자 2
    JLabel lbl_2 = new JLabel("숫자 2: ");
    txtNum_2 = new JTextField(" ", 18);
    JPanel panel_2 = new JPanel();
    panel_2.add(lbl_2);
    panel_2.add(txtNum_2);
    add(panel_2);

    // 3 rows 연산선택
    rdoPlus = new JRadioButton("+", true);
    rdoMinus = new JRadioButton("-",false);
    rdoMulti = new JRadioButton("*",false);
    rdoDiv = new JRadioButton("/",false);
    btngroup.add(rdoPlus);
    btngroup.add(rdoMinus);
    btngroup.add(rdoMulti);
    btngroup.add(rdoDiv);
    JPanel panel_3 = new JPanel();
    panel_3.add(new JLabel("연산 선택"));
    panel_3.add(rdoPlus);
    panel_3.add(rdoMinus);
    panel_3.add(rdoMulti);
    panel_3.add(rdoDiv);
    add(panel_3);   // executable.

    // 4 rows 결과
    lbl_Result = new JLabel("결과 : " + JLabel.CENTER);
    JPanel panel_4 = new JPanel();
    panel_4.add(lbl_Result);
    add(lbl_Result);

   // 5 rows 계산, 초기화, 종료.

    JButton btn_Calc = new JButton("계산");
    btn_Calc.addActionListener(this); // 내부 클래스로 돌려야댐.
    JPanel panel_5 = new JPanel();
    panel_5.add(btn_Calc);
    add(panel_5);

    JButton btn_Clear = new JButton("초기화");
    btn_Clear.addActionListener(this); // 내부 클래스로 돌려야댐.
    panel_5.add(btn_Clear);
    add(panel_5);

    JButton btn_Exit = new JButton("종료");
    btn_Exit.addActionListener(this); // 내부 클래스로 돌려야댐.
    panel_5.add(btn_Exit);
    add(panel_5);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 계산식
    double reSult = 0.0;

//   txtNum_1 = new Double.parseDouble(String.valueOf(txtNum_1));
    if (rdoPlus.isSelected()) {
      reSult = ((double)Integer.parseInt(txtNum_1.getText())) +
          ((double)Integer.parseInt(txtNum_2.getText()));
    } else if(rdoMinus.isSelected()) {
      reSult = ((double)Integer.parseInt(txtNum_1.getText())) -
          ((double)Integer.parseInt(txtNum_2.getText()));
    } else if (rdoMulti.isSelected()) {
      reSult = ((double)Integer.parseInt(txtNum_1.getText())) *
          ((double)Integer.parseInt(txtNum_2.getText()));
    } else if (rdoDiv.isSelected()) {
        if (Integer.parseInt(txtNum_2.getText()) == 0) {
          System.out.println("0으로 나눌수 없어요.");
        }  reSult = ((double)Integer.parseInt(txtNum_1.getText())) /
            ((double)Integer.parseInt(txtNum_2.getText()));
    } // ends if;


    /*try {
      switch () {

      }
    } catch (Exception e1) {

    }*/


    // 유효성 검사
    int Num = 0;
    try {
      Num = (Integer.parseInt(txtNum_1.getText()));
    } catch (Exception e1) {
      JOptionPane.showMessageDialog(this, "숫자만 됩니다.");
      txtNum_1.requestFocus();
      return;
    }


    String ss_result = "결과 : " + reSult;
    // reSult 계산한걸 = ss_result 에 넣고,

    lbl_Result.setText(ss_result);  // 결과값

  }


  public static void main(String[] args) {
    new miniCal();
  }

}
