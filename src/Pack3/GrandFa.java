package Pack3;

public class GrandFa {

  private int nai = 90;
  public String gabo = "상감청자";
  protected String gahun = "잘살자";
  public String data = "GrandFa data";

  public GrandFa() {
    System.out.println("할아버지 생성자");
  }

  public String say() {
    return "할아버지 말씀:그날 그날 정리해라";
  }
  public String say(String ss) {
   return "할아버지 말씀:그날 그날 정리해라";
  }
  public String say(String ss, int aa) {
    return "할아버지 말씀:그날 그날 정리해라";
  }
  public GrandFa(int nai) {
    this(); // 생성자를 부르는 this. 이 this 는 항상 먼저 적어야함.
    this.nai = nai; // 현재 class 의 member 를 지정하기 위한 키워드 this.
  }

  // method 에 final 붙이면 override 불가.
  public final void eat() {
    System.out.println("밥은 맛있게.");
  }

  public int getNai() {
    return nai;
  }


}
