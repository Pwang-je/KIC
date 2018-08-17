package Inter;

import java.lang.annotation.Target;

public class ThreadClass {

  public void sendEmail(String ss) {
    System.out.println(ss + " 메일을 전송");
  }

  public ThreadClass() {
    m1();
    m2();
    m3();
    m4();
  }

  void m1() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        sendEmail("m1()");
      }
    }).start();
  }

  // 람다 사용 1
  void m2() {
    Thread thread = new Thread(()->sendEmail("m2()"));
    thread.start();
  }

  // 람다 사용 2
  void m3() {
    new Thread( ()->sendEmail("m3") ).start();
  }

  // 람다 사용 3
  void m4() {
    Runnable runnable = ()->sendEmail("m4");
    runnable.run();
  }
  public static void main(String[] args) {
    new ThreadClass();
  }
}
