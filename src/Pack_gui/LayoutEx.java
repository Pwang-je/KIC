package Pack_gui;

import com.sun.org.apache.xpath.internal.Arg;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LayoutEx extends Frame implements ActionListener {

  Panel pn1 = new Panel();
  Panel pn2 = new Panel();
  Panel pn3 = new Panel();
  Panel pn4 = new Panel();
  Panel pn5 = new Panel();
  Button btnOk;
  CardLayout cd1 = new CardLayout();
  TextField txtNumber, txtName;


  public LayoutEx() {

    // Frame 은 기본이 Border layout.

    setLayout(new GridLayout(2, 1));    // layout 을 border 에서 grid 로 변경함. 2행 1열.

    CardLayout myLay = new CardLayout();
    pn4.setLayout(cd1);


    // 1번째 행
    Label lb1 = new Label("number");
    txtNumber = new TextField("10", 20);

    // Panel 은 기본이 Flow Layout 이다. ( 좌에서 우로, 위에서 아래로 )
    pn1.add(lb1);   // Label 을 Panel 에 배치.
    pn1.add(txtNumber);
    pn1.setBackground(Color.pink);
    add(pn1);   // Panel 을 프레임에 배치.

    Label lb2 = new Label("name");
    txtName = new TextField("홍길동", 20);
    pn2.add(lb2);
    pn2.add(txtName);
    pn2.setBackground(Color.ORANGE);
    add(pn2);

    pn3.setLayout(cd1);  // Flow layout 을 Card layout 으로 바꿈.
    pn3.add("kbs", pn1);    // kbs 라는 이름으로 pn1 에 집어넣음.
    pn3.add("mbc", pn2);
//    add(pn3);

    btnOk = new Button("OK");
    btnOk.addActionListener(this);    // action Listener 를 layout ex 가 가지고 있기 때문에 this. -> override 로 이동.
    pn4.add(pn3);
    pn4.add(btnOk);
    add(pn4);


    // 2번째 행 ( border layout )
    pn5.setBackground(Color.cyan);
    pn5.setLayout(new BorderLayout());
    pn5.add("Center", new Label("My name is JAVA", Label.CENTER));
    /*pn5.add("East", new Label("East", new Label("East")));
    pn5.add("West", new Label("Ease", new Label("West")));
    pn5.add("North", new Label("Ease", new Label("North")));
    pn5.add("West", new Label("West", new Label("West")));*/
    add(pn5);

    setTitle("Layout");
    setBounds(200,200,400,300);
    setVisible(true);

    // 무한루프 종료.
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    setTitle("Click");

//    System.out.println(e.getActionCommand());
    if (e.getActionCommand().equalsIgnoreCase("ok")) {
      btnOk.setLabel("CLICK");
      cd1.show(pn3, "mbc");
    } else {
      btnOk.setLabel("OKOK");
      cd1.show(pn3,"kbs" );
    }

  }

  public static void main(String[] args) {
    new LayoutEx();
  }


}
