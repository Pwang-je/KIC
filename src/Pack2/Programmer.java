package Pack2;

public class Programmer {

  public String nickName;   // 초기값 안줘서 null
  private int age = 0;
  String spec = "Java 개발자";

  public static String motto = "미치자";
    // final 은 손을 댈 수 없음.
    //  public final double PI = 3.14;
  public static final double PI = 3.14;

  public Programmer() {
    System.out.println("난 생성자, 초기화 담당");
    System.out.println("초기화 없으면 소스 코딩 생략");
    age = 20;
  } // Programmer;

  public void displayData() {
    String sp = reSpec();
    System.out.println("별명이 " + nickName + "은(는) " + age + "살 " + sp);
  } // displayData;

  private String reSpec() {
    return "보유 기술은" + spec;
  } // reSpec;

  public void setAge(int age) {    // setter
    this.age = age;
  }

  public int getAge() {     // getter
    return age;
  }

}
