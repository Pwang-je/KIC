package Pack2;

public class BankMain {

  public static void main(String[] args) {

    Bank tom = new Bank();
    tom.deposit(5000);
    tom.withdraw(3000);
    System.out.println("tom의 예금액" + tom.getMoney());

    System.out.println();
    Bank oscar = new Bank(2000);
    System.out.println("oscar의 예금액" + oscar.getMoney());
    oscar.deposit(1000);
    oscar.withdraw(2500);
    System.out.println("oscar의 예금액" + oscar.getMoney());

    System.out.println("객체의 주소 --------");
    System.out.println("tom의 참조 주소" + tom);
    System.out.println("oscar의 참조 주소" + oscar);
    System.out.println("tom의 참조 주소" + tom.hashCode());
    System.out.println("oscar의 참조 주소" + oscar.hashCode());

    Bank james = null;
    // nullPointerException.
    //System.out.println("james의 예금액: " + james.getMoney());
    System.out.println("james의 예금액: " + james);
    james = oscar; // 주소의 치환.

    System.out.println("james의 예금액: " + james.getMoney());
    System.out.println("james의 주소: " + james);

    System.out.println();

    if (james == tom) {  // 주소의 비교 if(a == b) 값의 비교.
      System.out.println("둘은 같은 객체의 주소");
    } else {
      System.out.println("둘은 다른 주소");
    }

    if (james instanceof Bank) {  // instanceof : 클래스 타입 비교연산자.
      System.out.println("Bank type");
    } else {
      System.out.println("Bank type 아니네요");
    }

    System.out.println("\nString 클래스 ----");
    String ss1 = "kor";
    String ss2 = new String();
    ss2 = "kor";
    String ss3 = new String("kor"); // 위에 2가지 방법과 다름.

    // 문자열의 비교.
    System.out.println(ss1 + " " + ss2 + " " + ss3);
    if (ss1 == ss2) {
      System.out.println("같아1");
    } else {
      System.out.println("달라1");
    }

    if (ss1 == ss3) {
      System.out.println("같아2");
    } else {
      System.out.println("달라2");
    }

    // 문자열을 비교할때 .equals 를 쓸것.
    if (ss1.equals(ss2)) {
      System.out.println("같아1");
    } else {
      System.out.println("달라1");
    }
    if (ss1.equals(ss3)) {
      System.out.println("같아2");
    } else {
      System.out.println("달라2");
    }

    System.out.println("\n---- Array ----");
    int ar1[] = {1,2,3};
    System.out.println(ar1);
    System.out.println(ar1[0] + " " + ar1[1]);

    int ar2[][] = {{1,2,3},{4,5,6}};
    System.out.println(ar2);
    System.out.println(ar2[0]);
    System.out.println(ar2[0][0]);


    System.out.println();
    Bank john = new Bank();
    System.out.println(john.imsi);
    System.out.println(john.imsi2);






  }
}
