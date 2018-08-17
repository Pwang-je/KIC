package Inter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class ButtonEvent extends JFrame {

  public ButtonEvent() {
    super("이벤트 람다 사용");

    setLayout(null);
    JButton btn1 = new JButton("click!");
    btn1.setBounds(10, 50, 100, 50);
    add(btn1);

    setBounds(200, 200, 300, 500);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    btn1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setTitle("첫번째 버튼");
      }
    });

    // 람다 연습용
    JButton btn2 = new JButton("click_2");
    btn2.setBounds(10,150,100,50);
    add(btn2);
    btn2.addActionListener(e -> setTitle("두번째 버튼"));

    // Debug 연습용
    JButton btn3 = new JButton("click!!!!!!");
    btn3.setBounds(10, 250, 100, 50);
    add(btn3);

    btn3.addActionListener(new ActionListener() {
      int cou = 0;
      int tot = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 5; i++) {
          cou += 1;
//          System.out.println("cou: " + cou); // 변수값 콘솔로 알아보기.
          JOptionPane.showMessageDialog(btn3, "cou" + cou);
          tot += cou;

        }
        setTitle("합은 " + tot);
      }
    });



  }

  public static void main(String[] args) {
    new ButtonEvent();
  }
}
