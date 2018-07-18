package Pack7;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import pack1.Test1;

public class A {

  int field1;

  public A() {
    System.out.println("A 객체 생성");
  }
  void method1() {    // 바깥쪽 클래스 멤버 method.
    System.out.println("Method 1 수행");
  }

  class B {   // instance member class
    int field2;
    public B() {
      System.out.println("B 객체 생성");
    }
    void method2() {    // 안쪽 클래스 멤버 method.
      System.out.println("Method 2 수행");
    }
  }

  static class C {
    int field3;

    public C() {
      System.out.println("C Object 생성");
    }
    void method3() {    // 안쪽 클래스 멤버 method.
      System.out.println("Method 3 처리");
    }
  }

  void method5() {  // 바깥쪽 클래스 멤버 method.
    System.out.println("method5 가 처리됨.");
    class D {
      int field4;
      int field5;

      public D() {
        System.out.println("D instance");
      }
      void method6() {
        System.out.println("method6 처리.");
      }
    }
    D d = new D();
    d.field4 = 7;
    d.method6();
  }

  // 허용 범위.
  B b2 = new B();
  C c2 = new C();
//  D d2 = new D();   // method 안에 들어있기 때문에 선언할 수 없음.

  void test1() {
    B b3 = new B();
    C c3 = new C();
  }




  public static void main(String[] args) {

    System.out.println("\n바깥쪽 클래스 객체 생성 ---------");
    A a = new A();
    a.field1 = 1;
    a.method1();

//    B b = new B();
    A.B b = a.new B();
    b.field2 = 2;
    b.method2();

    System.out.println("\n정적 멤버 클래스 객체 생성 ---------");
    A.C c = new A.C();
    c.field3 = 3;
    c.method3();

    C c2 = new C();   // static 일 때, 그냥 써도 됨.
    c2.field3 = 4;
    c2.method3();

    System.out.println("\n로컬 클래스 객체 생성 ---------");

    System.out.println(Test1.class);








  }

}
