package Pack6;

public class VolMain {

  public static void main(String[] args) {

//    Volume volume = new voulme();
    Volume volume = null;

    VolRadio radio = new VolRadio();
    radio.volUp(10);
    radio.volDown(5);
    System.out.println();
    VolTv tv = new VolTv();
    tv.volUp(7);
    tv.volDown(3);
    tv.kbs();

    System.out.println();

    volume = radio;
    volume.volUp(10);
    volume.volDown(1);
    System.out.println();

    volume = tv;
    tv.volDown(50);
    tv.volDown( 10);

  }

}
