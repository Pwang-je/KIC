package Pack4;

public class PolyBus extends PolyCar {

  private int passenger = 10;

  public void show() {
    System.out.println("버스");
  }

  @Override
  public void dispData() {
    System.out.println("버스 승객은 " + passenger);
    System.out.println("버스 속도는 " + getSpeed());
  }







}
