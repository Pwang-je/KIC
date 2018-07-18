package java_basic3.src;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class ThreadTest_3 extends Frame implements ActionListener, Runnable {

  Label lbl;
  Thread thread;  // thread 선언
  boolean b = false;

  public ThreadTest_3() {

    // Label
    lbl = new Label("Display Time with Center", Label.CENTER);  // 글씨 가운데 정렬.
    add("Center", lbl);

    // Button
    Button btnClick = new Button("Click");
    add("South", btnClick);
    btnClick.addActionListener(this);

    setTitle("Thread clock");
    setBounds(200, 200, 300,300 );    // setLocation + setSize
    setVisible(true);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        b = true; // x 누를 시 thread 종료.
        System.exit(0);
      }
    });   // windows listener ;

    thread = new Thread(this);

  } // public threadtest_3 ;

  @Override
  public void actionPerformed(ActionEvent e) {
    if (thread.isAlive()) return;   // 쓰레드가 살아있을 때를 확인하여 return 으로 빠져나감. 밑에 thread.start() 실행 안함.

    thread.start(); // 버튼액션 실행
  }

  @Override
  public void run() {
    while (true) {

      if (b == true) break;

      try {
        calendarShow();
        Thread.sleep(1000);
      } catch(Exception e) {
        // catch
      }
    }
  }

  private void calendarShow() {
    Calendar myCal = Calendar.getInstance();
    int y = myCal.get(Calendar.YEAR);
    int m = myCal.get(Calendar.MONTH);
    int d = myCal.get(Calendar.DATE);
    int h = myCal.get(Calendar.HOUR);
    int mi = myCal.get(Calendar.MINUTE);
    int s = myCal.get(Calendar.SECOND);

    lbl.setText(y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s);
    lbl.setFont(new Font("궁서", Font.BOLD, 20));
  }   // private calendar ;

  public static void main(String[] args) {
    new ThreadTest_3();
  }


}
