package Pack_gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingEx extends JFrame implements ActionListener {

  JLabel lblShow;
  int count = 0;


  public SwingEx() {
    setTitle("Swing Test");
    setBounds(200,200,400,400);
    setVisible(true);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2,1));
//    panel.setBackground(Color.orange);
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

    // panel 의 첫 행에 버튼 집어넣기.
    JButton button = new JButton("클릭(C)");
    button.setMnemonic(KeyEvent.VK_C);  // 단축키 설정.
    panel.add(button);
    button.addActionListener(this);

    // panel 의 두번째 행
    lblShow = new JLabel("버튼 클릭 수" + count);
    panel.add(lblShow);


//    getContentPane().add(panel);  // 같은거.
     add(panel);
    // add("Center", panel);
    // add(panel, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // System.exit(0);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    count++;
    lblShow.setText("버튼 클릭 수 : " + count);
  }

  public static void main(String[] args) {
    new SwingEx();
  }

}
