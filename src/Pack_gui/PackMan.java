package Pack_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class PackMan extends JFrame implements KeyListener {

  Image image;
  int x, y;
  int sel = 1;

  public PackMan() {
    super("상하좌우 화살표를 사용하세요.");

    setLayout(null);
    setResizable(false);
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack1.jpg"));   // JFrame FAVICON change.
    setBounds(200,200,300,300);
    setBackground(Color.white);
    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    x = getWidth() / 2;
    y = getHeight() / 2;
    addKeyListener(this); // frame 에 keyListener 를 장착함. 이러면 키보드값을 인식함.

  }

  public void paint(Graphics g) {

    switch (sel) {
      case 1:
        image = Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack1.jpg");
        break;
      case 2:
        image = Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack2.jpg");
        break;
      case 3:
        image = Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack3.jpg");
        break;
      case 4:
        image = Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack4.jpg");
        break;
      case 5:
        image = Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack5.jpg");
        break;
      case 6:
        image = Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack6.jpg");
        break;
      case 7:
        image = Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack7.jpg");
        break;
      case 8:
        image = Toolkit.getDefaultToolkit().getImage("C:/work/packman/pack8.jpg");
        break;
    }
    g.clearRect(0, 0, getWidth(), getHeight());
    g.drawImage(image, x - image.getWidth(this) / 2  ,y - image.getHeight(this) / 2 ,this );
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode(); // 자판값 인식
//    System.out.println(key);
    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {
//      System.out.println("오른쪽");
//      if(sel == 1) sel = 2; else sel = 1;   // 입 벌렸다가 다시 오므리기.
        sel = (sel == 1)?2:1; // 삼항연산자!!
        x = (x < getWidth())? x += 10 : - image.getWidth(this);  // -image.getwidth(this) 너비값 마이너스.
    } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) {
      sel = (sel == 1)?2:1;
      y = (y < getHeight())? y += 10 : - image.getHeight(this);
    } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {
      sel = (sel == 1) ? 2 : 1;
      y = (y < getHeight()) ? y -= 10 : - image.getHeight(this);
    } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {
      sel = (sel == 1) ? 2 : 1;
      x = (x < getWidth()) ? x -= 10 : - image.getWidth(this);
    }

    repaint();  // 그림 다시 부르기.
  }

  @Override
  public void keyReleased(KeyEvent e) {    }

  @Override
  public void keyTyped(KeyEvent e) {     }

  public static void main(String[] args) {
    new PackMan();
  }

}
