package Pack_gui;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventEx extends Frame implements ActionListener {

  private Button btn1 = new Button("btn1");
  private Button btn2 = new Button("btn2");
  private Button btn3 = new Button("btn3");
  private Button btn4 = new Button("btn4");
  private Button btn5 = new Button("btn5 exit");

  public EventEx() {

    super("EVENT PRAC");

    makeLayout();

    setBounds(200, 200, 300, 300);
    setVisible(true);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

  }

  private void makeLayout() {
    add("East", btn1);
    add("West", btn2);
    add("Center", btn3);
    add("South", btn4);
    add("North", btn5);

    btn1.addActionListener(this);
    btn2.addActionListener(this);   // this 일때만 actionPerformed 로 넘어감.
    btn3.addActionListener(new myEvent());  // 내부 클래스 사용법.
    btn4.addMouseListener(new ourEvent());  // 내부 클래스. mouse 사용.

    // 내부 무명 (익명) 클래스 사용법.
    btn5.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        System.exit(0);
      }
    });
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    System.out.println(e.getActionCommand());
    System.out.println(e.getSource());

    /*if (e.getActionCommand().equals(("btn1"))) {    }*/
    if (e.getSource() == btn1) {    // 이벤트 여러개를 actionPerformed 에서 처리하는 첫번째 방법.
      setTitle("button 1 click.");
    } else if (e.getSource() == btn2){
      setTitle("button 2 select.");
    } // if btn1, btn2;

  } // action Performed;


  // 내부 클래스 1. - btn3.
  class myEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      EventEx.this.setTitle("세번째 버튼입니다.");    // eventex 가 갖고 있는 frame(this) 의 settitle.
    }
  }

  // 내부 클래스 2. - btn4.
  class ourEvent extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
      setTitle("만세만세4번째만세");
    }
  }


  public static void main(String[] args) {
    new EventEx();
  }


}
