package Pack2;

public class Bank {

  private int money = 1000;
  int imsi = 1;
  public int imsi2 = 2;

  public Bank() {

  }
  public Bank (int money) {
    this.money += money;
  }
  public void deposit (int amount) {
    if(amount>0) money += amount;
  }
  public void withdraw(int amount) {
    if((amount>0)&&(money-amount>=0)) {
      money -= amount;
    } else {
      System.out.println("출금액이 너무 많아요");
    }
  }

  public int getMoney() {
    return money;
  }









}
