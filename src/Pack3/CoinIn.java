package Pack3;

public class CoinIn {

  private int Coin, jandon;

  public String calc(int cupCount) {
    String msg = " ";
    if (Coin < 200) {
      msg = "동전이 부족합니다.(한잔에 200원)";
    } else if(cupCount * 200 > Coin) {
      msg = "동전이 부족합니다";
    } else {
      jandon = Coin - (200 * cupCount);
      msg = "커피 " + cupCount + "잔과 잔돈은 " + jandon + " 원입니다.";
    }
    return msg;
  } // string calc ;

  // set,get = Coin, jandon
  public void setCoin(int coin) {
    this.Coin = coin;
  }
//  public int getJandon() {
//    return jandon;
//  }


}
