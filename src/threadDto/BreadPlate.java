package threadDto;

public class BreadPlate {

  private int breadCount = 0;   // 공유 대상.

  public BreadPlate() {
    // Const
  }

  public synchronized void makeBread() {
    if (breadCount >= 10) {
      try {
        System.out.println("빵 생산 초과");
        wait();   // thread 시작을 비활성화.
        // 조건을 만족하면 wait 하고 있는거임.
      } catch (Exception e) {

      }
    }
    breadCount++;
    System.out.println("빵을 생산 " + breadCount + " 개");
    notify();   // waiting 된 작업을 다시 시작.
  }

  public synchronized void eatBread() {
    if (breadCount < 1) {
      try {
        System.out.println("빵 소비 불가");
        wait();
      } catch (Exception e) {

      }
    }
    breadCount--;
    System.out.println("빵을 소비 " + breadCount + " 개");
  }




}
