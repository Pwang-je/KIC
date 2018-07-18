package java_basic3.src;

public class ThreadTest_1 extends Thread {

  public ThreadTest_1() {

  }


  public void run() {
    for (int i = 0; i <= 50; i++) {
//      System.out.println(i + " ");
      System.out.println(i + " " + super.getName());
    }
  }

  public ThreadTest_1(String name) {
    try {
      /*
      // process 단위의 처리
      Process p1 = Runtime.getRuntime().exec("calc.exe");
      Process p2 = Runtime.getRuntime().exec("notepad.exe");
      p1.waitFor();   // 자신은 정상종료, 나머지 프로그램은 강제종료.
      p2.destroy();   // 자신만 정상종료, 나머진 유지.
      System.out.println("p1: " + p1.exitValue());
      System.out.println("p2: " + p2.exitValue());
      */
      /*
      ThreadTest_1 t1 = new ThreadTest_1();
      ThreadTest_1 t2 = new ThreadTest_1();
      t1.run();
      System.out.println();
      t2.run();
      */
//      ThreadTest_1 t1 = new ThreadTest_1();
//      ThreadTest_1 t2 = new ThreadTest_1();
      ThreadTest_1 t1 = new ThreadTest_1("one");
      ThreadTest_1 t2 = new ThreadTest_1("two");
      t1.start();
      t2.start();
      t2.setPriority(MAX_PRIORITY);   // 우선순위 변경 요청. 10 이 최고값.

      t1.join();  // 일반 스레드의 수행이 끝날 때까지 메인스레드를 대기시킴.
      t2.join();

      // t1.yield(); // 다른 스레드의 수행이 요청되면 현재 스레드의 수행을 일시정지.



      System.out.println("프로그램 종료");

    } catch (Exception e) {
      System.out.println("err: " + e);
    }
  }
  public static void main(String[] args) {



  }

}
