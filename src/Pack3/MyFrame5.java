package Pack3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame5 extends Frame {

  String str[] = {"백용","대환","동훈","다희","주현"};
  int x, y;

  public MyFrame5() {
    // super ("내부 클래스 연습")
    setTitle("내부 클래스 연습");
    setSize(300, 200);
    setLocation(200, 200);
    setVisible(true);

    Wevent wevent = new Wevent();

    addWindowListener(wevent);
    addMouseListener(new Mevent());   // 방법 2가지임. 위에2개, 밑에 하나.
  }

  // inner class!!
  class Wevent extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }
  }

  class Mevent extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
//      setBackground(Color.yellow);
//      int x = e.getX();
//      int y = e.getY();
        x = e.getX();
        y = e.getY();
//      System.out.println(x + " " + y);
      setTitle(x + " " + y);
//      paint(getGraphics());
      repaint();    // paint() 를 호출. 클릭할때마다 화면을 clear 시키고 새로 string 을 찍음.
    }
  }

  @Override
  public void paint(Graphics g) {
//    g.drawString("졸지말자", x, y);
    g.setColor(new Color(
        (int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
    g.drawString(str[1],x ,y );
    g.setFont(new Font("궁서", Font.BOLD, (int)(Math.random() * 50)));
  }

  public static void main(String[] args) {

    new MyFrame5();

  }

}
