package Pack7;

public class SaramMain {


  public static void main(String[] args) {

    Saram saram = new Saram();
    System.out.println(saram.getIr());

    System.out.println();

    SaramSunsin sunsin = new SaramSunsin();
    Saram saram2 = sunsin.getSaram();
    System.out.println(saram2.getIr());

  }

}
