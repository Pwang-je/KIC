package Pack2;

public class ProgrammerMain {

  public static void main(String[] args) {

    Programmer tom = new Programmer();  // 생성자 호출

    /*tom.Programmer(); // 생성자 호출 불가*/
    System.out.println("tom 별명은 " + tom.nickName);
    tom.nickName = "자바 귀신";
    System.out.println("tom 별명은 " + tom.nickName);

    //    System.out.println("tom 나이는 " + tom.age);
    tom.setAge(24);
    System.out.println("tom 나이는 " + tom.getAge());

    System.out.println("tom 기술은 " + tom.spec);
    tom.displayData();
    tom.spec += ",Python 개발자";
    tom.displayData();
    System.out.println();

    // static 으로 정해진건 tom.motto 가 아니라
    // class 의 이름으로 직접 쓸 수 있음.
    // 그럼 굳이 class 의 이름으로 직접 쓰는 이유가?
    System.out.println(Programmer.motto);
    // tom.PI = 12.3;  // Cannot assign a value to final variable 'PI'
    System.out.println("파이는 " + tom.PI);         // NOT Recommended.
    System.out.println("파이는 " + Programmer.PI);  // Recommended.

    System.out.println(Math.PI);

  }

}
