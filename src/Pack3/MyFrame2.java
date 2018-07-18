package Pack3;

import java.awt.Frame;

public class MyFrame2 extends Frame {

  public MyFrame2() {
    /*super("상속 연습");   // 제목은 Frame 클래스의 private 멤버.

    setLocation(500,300 );
    setVisible(true);
    setSize(500,300 );*/
  }

  private void abc() {
    setTitle("상속 연습");
    setLocation(500,300 );
    setSize(500,300 );
    setVisible(true);
  }



  public static void main(String[] args) {
    // new MyFrame2();
    MyFrame2 frame2 = new MyFrame2();
    frame2.abc();
  }
}
