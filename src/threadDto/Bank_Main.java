package threadDto;

public class Bank_Main {

  public static Bank myBank = new Bank();



  public static void main(String[] args) {
    System.out.println("잔고 : " +
        myBank.getMoney());

    Park park = new Park();
    Park_Wife wife = new Park_Wife();

    park.start();
    wife.start();

  }

}
