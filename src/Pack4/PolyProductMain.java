package Pack4;

public class PolyProductMain {

  public static void main(String[] args) {

    PolyProduct product = null; // 부모로써만 씀.

    PolyRadio radio = new PolyRadio();
    radio.setVolume(10);
    System.out.println(radio.getVolume());
    radio.volumeControl();

    System.out.println();

    PolyTv tv = new PolyTv();
    tv.setVolume(7);
    tv.volumeControl();
    tv.tvShow();

    System.out.println("\n 다형성");
    product = radio;  // promotion.
    product.volumeControl();
    System.out.println();
    product = tv;
    product.volumeControl();

    System.out.println();
    PolyProduct poly[] = new PolyProduct[2];
    poly[0] = radio;
    poly[1] = tv;
    for (PolyProduct my:poly) {
      my.volumeControl();
    }
    tv.tvShow();


  } // psvm ;

}
