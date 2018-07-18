package Pack3;

public class Father extends GrandFa {   // 상속관계
//  GrandFa fa = new GrandFa();  // 포함관계

  private int nai = 55;
  public String gabo = "꽃병";  // 자식에서 같은 멤버를 생성하면 부모껀 사라짐.
  public String data = "Father data";

  public Father() {
    super();
    System.out.println("아버지1 생성자");
  }

  public Father(int n) {
    super(n);
    System.out.println("아버지2 생성자");
  }

  // method overriding. 재정의.
/*  @Override
  public String say() {
    return "할아버지 말씀:그날 그날 정리해라";
  }*/

  @Override
  public String say() {
    return "아버지 말씀: 주말에는 총정리";
  }






}
