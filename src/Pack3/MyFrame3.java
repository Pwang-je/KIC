package Pack3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame3 extends Frame implements WindowListener, MouseListener {

  public MyFrame3() {
//    super("windows listener 연습");   // 제목은 Frame 클래스의 private 멤버.
    addWindowListener(this);
    addMouseListener(this);
  }

  private void abc() {
    setTitle("윈도우 이벤트 연습");
    setLocation(500,300 );
    setSize(500,300 );
    setVisible(true);
  }

  public static void main(String[] args) {
    // new MyFrame2();
    MyFrame3 frame2 = new MyFrame3();
    frame2.abc();
  }
  @Override
  public void windowOpened(WindowEvent e) {
  }
  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }
  @Override
  public void windowClosed(WindowEvent e) {
  }
  @Override
  public void windowIconified(WindowEvent e) {
    System.out.println("화면 아이콘화");
  }
  @Override
  public void windowDeiconified(WindowEvent e) {
    System.out.println("화면 복귀");
  }
  @Override
  public void windowActivated(WindowEvent e) {
  }
  @Override
  public void windowDeactivated(WindowEvent e) {
  }


  int count = 0;
  //  MouseListener
  @Override
  public void mouseClicked(MouseEvent e) {
    // int count = 0;
//    System.out.println("폼바닥 클릭 수 : " + (count += 1));
//    setBackground(Color.red);
//    System.out.println((int)Math.random() * 255);
    int r = (int)(Math.random() * 255);
    int g = (int)(Math.random() * 255);
    int b = (int)(Math.random() * 255);
    setBackground(new Color(r, g, b));
    setTitle(r + " " + g + " " + b + " ");
  }
  @Override
  public void mousePressed(MouseEvent e) {
  }
  @Override
  public void mouseReleased(MouseEvent e) {
  }
  @Override
  public void mouseEntered(MouseEvent e) {
  }
  @Override
  public void mouseExited(MouseEvent e) {
  }

}
