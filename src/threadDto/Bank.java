package threadDto;

public class Bank {

  private int money = 10000;  // 공유자원

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public synchronized void depositMoney(int deposit) {   // 입금.
    int m = this.getMoney();
    try {
      Thread.sleep(2000); // 2초 비활성
    } catch (Exception e) {

    }
    this.setMoney(m + deposit);
  }

  public synchronized void withdrawMoney(int withdraw) {   // 출금.
    int m = this.getMoney();
    try {
      Thread.sleep(3000); // 3초 비활성
    } catch (Exception e) {

    }
    this.setMoney(m - withdraw);
  }

// synchronized 는 thread 의 공유를 하게함.


}
