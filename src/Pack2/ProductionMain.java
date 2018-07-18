package Pack2;

import java.util.Scanner;

public class ProductionMain {

  public static void main(String[] args) {
    System.out.println("테스트");

    Production pro = new Production();
    pro.display();
    pro.display("사과");
    pro.display("수박",10 );
    pro.display("배",23 ,150 );

    pro.setSize(32);
    pro.setName("새우깡");

    System.out.println("----------------");

    Production pro2ConOver = new Production("참외",4, 200 );

    pro2ConOver.setName("홈런볼");
    System.out.println("상품명: " + pro2ConOver.getName());
    pro2ConOver.setSize(10);
    System.out.println("갯수는: " + pro2ConOver.getSize());
    pro2ConOver.setPrice(1000);
    System.out.println("가격은: " + pro2ConOver.getPrice());

    // normal method
    pro2ConOver.myNormal();


    /*Scanner sc = new Scanner(System.in);
    System.out.print("상품명을 입력하세요");
    String name = sc.next();
    System.out.println("상품명: " + name + ", 가격: " + price + ", 갯수: "
        + size + "개 입니다.");
    sc.close();
*/

  }

}
