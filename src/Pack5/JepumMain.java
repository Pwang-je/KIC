package Pack5;

public class JepumMain {

  public static void main(String[] args) {

//    Jepum jepum = new Jepum();
    Jepum jepum = null;

    JepumTv tv = new JepumTv();
    tv.volumeShow();
    tv.volumeControl();

    System.out.println();

    JepumRadio radio = new JepumRadio();
    JepumCellphone cp = new JepumCellphone();

    jepum = tv;
    jepum.volumeControl();
    jepum = radio;
    jepum.volumeControl();
    jepum = cp;
    jepum.volumeControl();

    System.out.println();

    Jepum[] je = new Jepum[3];
    je[0] = tv;
    je[0] = radio;
    je[0] = cp;

    System.out.println();
    for (Jepum k:je) {
      k.volumeControl();
    }

    /*for (int k = 0; k < je.length; k++ ) {
      je[k].volumeControl();
    }*/




  }


}
