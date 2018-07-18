package Pack6;

public interface Resume {

  String SIZE = "A4"; // public static final 과 같은 의미임.

  void setName(String name);
  void setPhone(String phone);
  void print();

  default void playJava(boolean b) {  // default 가 중요!
      if (b) {
        System.out.println("자바 프로그래밍 가능");
      } else {
        System.out.println("자바 못해");
      }
  } // default void playJAva ;

  static void changeData() {
    System.out.println("스테틱 처리 가능함");
  }


}
