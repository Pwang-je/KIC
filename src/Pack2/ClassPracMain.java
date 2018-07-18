package Pack2;

public class ClassPracMain {

  public static void main(String[] args) {

    ClassPrac prac = new ClassPrac();

    // 톰의 별명은?
    System.out.println("톰의 별명은: " + prac.nickName);
    prac.nickName = "바보";
    System.out.println("톰의 설정된 별명은: " + prac.nickName);


    // 톰의 나이는? (private)
    prac.setAge(50);
    System.out.println("톰의 나이는: " + prac.getAge());

    // 톰의 스킬은?
    System.out.println("톰의 " + prac.reSkd() + " 입니다");



  } // public static void main ;




}
