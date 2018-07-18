package Pack4;

public class PolyMain {

  public static void main(String[] args) {

    PolyCar car1 = new PolyCar();
    PolyBus bus1 = new PolyBus();
    PolyTaxi taxi1 = new PolyTaxi();

    car1.dispData();
    System.out.println(car1.getSpeed());

    System.out.println();
    bus1.dispData();
    bus1.show();
    System.out.println(bus1.getSpeed());

    System.out.println();
    taxi1.dispData();
    taxi1.show();
    System.out.println(taxi1.getSpeed());

    System.out.println("---- car2 ----");
    PolyCar car2 = new PolyBus(); // possible.
    car2.dispData();  // overriding only.
    System.out.println(car2.getSpeed());
    // car2.show();   // 자식 고유 메소드 값이라서 안됨.

    System.out.println("---- car3 ----");
    PolyCar car3 = new PolyTaxi();
    car3.dispData();
    System.out.println(car2.getSpeed());

    System.out.println("---- inheritance relation ----");
//    PolyBus bus2 = new PolyCar(); // 안됨.
//    PolyBus bus2 = new car1;  // 안됨.
    PolyBus bus2 = (PolyBus)car2;
    bus2.dispData();
    bus2.show();
    System.out.println(bus2.getSpeed());

    /*PolyTaxi taxi2 = new PolyCar(); // 안됨.
    PolyTaxi taxi2 = new PolyBus(); // 안됨.*/
    PolyTaxi taxi2 = (PolyTaxi)car3;
    taxi2.dispData();

    System.out.println();
    car1 = bus1;
    car1.dispData();
    System.out.println();
    car1 = taxi1;
    car1.dispData();

    car1 = new PolyCar();

    System.out.println();
    PolyCar p[] = new PolyCar[3]; // create array obj.
    p[0] = car1;
    p[1] = bus1;
    p[2] = taxi1;
    for (int a = 0; a < p.length; a++) {
      p[a].dispData();
    }
    System.out.println();

    for (PolyCar my:p) {
      my.dispData();
    }










  } // PSVM ;

}
