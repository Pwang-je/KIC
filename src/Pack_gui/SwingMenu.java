package Pack_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SwingMenu extends JPanel implements ActionListener {

  JButton btnR, btnG, btnB;
  JTextArea txtArea = new JTextArea(10,50);
  JMenuBar mBar;
  JMenuItem mnuMes, mnuOk, mnuInput;

  public SwingMenu() {

    setLayout(new BorderLayout());   // Flow layout 을 border layout 으로.
    btnR = new JButton("빨");
    btnG = new JButton("녹");
    btnB = new JButton("파");
    btnR.addActionListener(this);
    btnG.addActionListener(this);
    btnB.addActionListener(this);

    JPanel jPanel = new JPanel();
    jPanel.add(btnR);
    jPanel.add(btnG);
    jPanel.add(btnB);
    add("South", jPanel);
    add("Center", txtArea);

    menuShow();
  }

  private void menuShow() {
    mBar = new JMenuBar();
    JMenu menu = new JMenu("메뉴");
    mnuMes = new JMenuItem("메세지");
    mnuOk = new JMenuItem("확인대화상자");
    mnuInput = new JMenuItem("입력");
    menu.add(mnuMes);
    menu.add(mnuOk);
    menu.add(mnuInput);

    mBar.add(menu);

    // 메뉴에 리스너 장착
    mnuMes.addActionListener(this);
    mnuOk.addActionListener(this);
    mnuInput.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnR) {
      txtArea.setBackground(Color.red);
    } else if (e.getSource() == btnG) {
      txtArea.setBackground(Color.green);
    } else if (e.getSource() == btnB){
      txtArea.setBackground(Color.blue);
    } else if (e.getSource() == mnuMes) {
      JOptionPane.showMessageDialog(this, "message","알림" ,JOptionPane.INFORMATION_MESSAGE);
      System.out.println("창이 닫히기 전까지 수행 안됨.");
    } else if (e.getSource() == mnuOk) {
      JOptionPane.showConfirmDialog(this, "버튼 선택", "선택",JOptionPane.YES_NO_CANCEL_OPTION);
    }

    int re = JOptionPane.showConfirmDialog(this, "버튼 선택", "선택해", JOptionPane.YES_NO_CANCEL_OPTION);
    switch (re) {
      case JOptionPane.YES_OPTION:
        txtArea.append(("예 선택\n"));
        break;
      case JOptionPane.NO_OPTION :
        txtArea.append("아니오 선택\n");
        break;
      case JOptionPane.CANCEL_OPTION:
        txtArea.append("취소 선택\n");
        break;
    }

  }


  public static void main(String[] args) {
    JFrame frame = new JFrame("메뉴 & 대화상자");
    SwingMenu menu = new SwingMenu(); // Panel 임. 프레임은 new SwingMenu();

//    frame.getContentPane().add(menu);
    frame.setJMenuBar(menu.mBar);  // Frame 에 메뉴 배치.
    frame.add(menu);  // Panel 을 JFrame 에 배치함.
    frame.setBounds(200,200,300,200);
    frame.setVisible(true);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
