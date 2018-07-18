package Pack7;

public class Outer {

  private int a;
  private Inner inner;

  public Outer() {
    a = 10;
    inner = new Inner();
  }

  public void aa() {
    System.out.println("외부에 있는 aa method");
    bb();
    inner.cc();
  }
  private void bb() {
    System.out.println("외부에 있는 bb method");
  }

  public class Inner {    // 내부 클래스.
    int b;

    public Inner() {
      b = 20;
    }
    void cc() {
      System.out.println("외부에 있는 cc method.");
      System.out.println("a: " + a + " , b: " + b);
      bb();
    }

    class InnerInner {
      // 또됨.
    }

  }

  public static void main(String[] args) {

    Outer outer = new Outer();
    outer.aa();

  }

}
