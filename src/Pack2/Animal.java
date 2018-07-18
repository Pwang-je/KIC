package Pack2;

public class Animal {

  private int leg = 4;    // 기본형 변수.
  private int age;
  private String name;  // 참조형 변수.
  private static int mouse = 1;

  public Animal() {
    // 생성자는 내용이 없을 시 생략 가능. (컴파일러가 생성)
  }

  // private 변수를 변경할 수 있는 방법 중 하나.
  public Animal(int leg) {   // Constructor overloading
    this.leg = leg;
  }
  public Animal(String leg) {
    this.name = leg;
  }

  public Animal(String irum, int nai) {
    this.name = irum;
    age = nai;
  }


  public void display() {
    System.out.println("leg : " + leg + ", age : " + age + ", name : " + name);
  }
  public void display(int age) {  // method overload(ing)
    this.age = age;  // 위에 private int age; 에게 보냄.
    System.out.println("leg : " + leg + ", age : " + age + ", name : " + name);
  }
  public void display(String name) {  // method overload(ing)
    this.name = name;  // 위에 private int age; 에게 보냄.
    System.out.println("leg : " + leg + ", age : " + age + ", name : " + name);
  }
  public void display(int age, String str) {  // method overload(ing)
    this.age = age;  // 위에 private int age; 에게 보냄.
    name = str;
    System.out.println("leg : " + leg + ", age : " + age + ", name : " + name);
  }
  public void display(String str, int age) {  // method overload(ing)
    this.age = age;  // 위에 private int age; 에게 보냄.
    name = str;
    System.out.println("leg : " + leg + ", age : " + age + ", name : " + name);
  }

  // public void 의 void 는 반환이 없음. ( return x )
  // public int 는 반환이 있음. ( return )
  // method 에서 return 을 만나면 그자리에서 바로 탈출함.

  // ----- x ------
   /*  public void display(int leg) {  // method overload(ing)
    this.age = age;  // 위에 private int age; 에게 보냄.
    System.out.println("leg : " + leg + ", age : " + age + ", name : " + name);
  }*/

  public static void myStaticMethod() {
    System.out.println("Im static method.");
    System.out.println("마우스 " + mouse + "개");

  } // public static void myStaticMethod ;

  public void normalMethod() {
    System.out.println("난 일반 메소드");
    System.out.println("다리 수 : " + leg);
    System.out.println("마우스 : " + mouse);

  } // public static normalMethod ;


}
