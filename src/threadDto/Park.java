package threadDto;

public class Park extends Thread {

  @Override
  public void run() {
    Bank_Main.myBank.depositMoney(5000);

    System.out.println("남편 예금 후 잔고: " +
        Bank_Main.myBank.getMoney());
  }


}
