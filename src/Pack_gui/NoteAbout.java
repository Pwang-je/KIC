package Pack_gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NoteAbout extends JDialog implements ActionListener {

  public NoteAbout(JFrame frame) {
//    super(frame, "메모장이란?", true);   // true : modal, false : modeless

    super(frame);
    setTitle("메모장이란?");
    setModal(true); // false;

    JLabel lblMsg = new JLabel("내 메모장 ver 0.9 alpha");
    JButton btnOk = new JButton("확인");
    btnOk.addActionListener(this);
    add("Center", lblMsg);
    add("South", btnOk);

    setBackground(Color.pink);
    setBounds(300,300,150,150);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    dispose();  // dialog close;
  }

  public static void main(String[] args) {

  }
}
