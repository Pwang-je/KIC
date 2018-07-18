package Pack4;

public class PolyTaxi extends PolyCar {

  private int passenger = 2;

  public void show() {
    System.out.println("택시");
  }

  @Override
  public void dispData() {
    System.out.println("택시 승객은 " + passenger);
  }




}
