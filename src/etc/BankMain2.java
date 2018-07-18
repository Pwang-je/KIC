package etc;

//import Pack2.Bank;
//import Pack2.Animal;
import Pack2.*;

public class BankMain2 {

  public static void main(String[] args) {

//    Pack2.Bank tom2 = new Pack2.Bank();
    Bank tom2 = new Bank();
    Animal ani = new Animal();


    // public 의 경우 어디서든 참조가 가능하지만,
    // private 나 default 는 다른 패키지 안에서는
    // private 로 전환됨.

    System.out.println("public member 는 project 내에서 참조 가능하다.");
    System.out.println("default (생략) 은 같은 package 안에서만 참조 가능.");



  }

}
