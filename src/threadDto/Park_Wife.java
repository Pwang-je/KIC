package threadDto;

public class Park_Wife extends Thread {

  @Override
  public void run() {
    Bank_Main.myBank.withdrawMoney(2000);

    System.out.println("아내 출금 후 잔고: " +
        Bank_Main.myBank.getMoney());
  }


}
