package Pack_gui;

import java.awt.CardLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Teest extends JFrame implements ActionListener {

  CardLayout cd_1 = new CardLayout();
  JPanel pn_1 = new JPanel();
  JPanel pn_2 = new JPanel();

  TextField txtNum, txtName;


  public Teest() {
    // const
    super("testtest");
    setTitle("layout");
    setBounds(200,200,300,300);


    Label lb1 = new Label("ddd");
    txtNum = new TextField("10",20);

    Label lb2 = new Label("aaa");
    txtName = new TextField("10", 10);

    pn_1.setLayout(cd_1);
    pn_1.add(lb1);
    add(pn_1);


   /* pn_2.setLayout(cd_1);
    pn_2.add(lb2);
    add(pn_2);*/


    // 무한루프 종료.
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setVisible(true);

  }



  @Override
  public void actionPerformed(ActionEvent e) {

  }

  public static void main(String[] args) {

  }

}
