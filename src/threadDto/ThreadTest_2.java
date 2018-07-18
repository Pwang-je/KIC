package java_basic3.src;

public class ThreadTest_2 implements Runnable {

  public ThreadTest_2() {

  }
  public ThreadTest_2(String name) {
    Thread tt = new Thread(this);
    tt.start();
  }

  @Override
  public void run() {
    for (int i = 0; i <= 50; i++) {
      System.out.println(i + " " + Thread.currentThread().getName());
      try {
        Thread.sleep(300);
      } catch (Exception e) {

      }
    }
  }


  public static void main(String[] args) {
    new ThreadTest_2("하나");
    new ThreadTest_2("둘");

    System.out.println();
    System.out.println("종료");


  }


}
