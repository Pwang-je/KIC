package Pack3;

import java.util.Scanner;

public class Machine {

  private int cupCount = 0;
  private int coffee = 20, sugar = 10;

  CoinIn co = new CoinIn();  // class CoinIn 호출

  public Machine() {
    // const
  }

  public void showData() {
    Scanner scan = new Scanner(System.in);

    System.out.print("동전을 넣으세요 : ");
    co.setCoin(scan.nextInt());
    System.out.print("몇잔을 원하세요? : ");
    cupCount = scan.nextInt();
    System.out.println(co.calc(cupCount));
    System.out.println("성분은 커피 " + coffee + ", 설탕 " +
        sugar + ", 나머지는 물입니다.");
    scan.close();
  }

}

/*
입력자료는 키보드를 사용(Scanner class)
커피는 한 잔에 200원.
100원 넣고 커피를 요구하면 요금 부족 메시지 출력.
400원 넣고 2잔 요구하면 두 잔 출력
500원 넣고 1잔 요구하면 300원 반납
생성자로 커피와 설탕의 양을 설정 가능

출력 형태 --------------------------
동전을 입력하세요 : 400
몇 잔을 원하세요 : 2
커피 2잔과 잔돈 0원

- private, + public.

 */