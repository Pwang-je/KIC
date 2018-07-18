package threadDto;

public class BreadMain {


  public static void main(String[] args) {
    BreadPlate breadPlate = new BreadPlate();

    BreadMaker maker = new BreadMaker(breadPlate);
    BreadEater eater = new BreadEater(breadPlate);

    maker.setPriority(8); // 스레드 스케쥴러에게 요청.

    maker.start();
    eater.start();
  }


}
