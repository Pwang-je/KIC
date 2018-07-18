package Pack4;

public class Wolfdog extends Dog {

  private String where = "산";

  public Wolfdog(String name) {
    super(name);
  }

  public void show() {
    System.out.println("어디사니?: " + where);
  }

  @Override
  public void print() {
    System.out.println(getName() + ":어디? " + where + "에 산다");
  }

  public void display() {
    print();
    super.print();
  }

}
