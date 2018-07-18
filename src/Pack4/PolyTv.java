package Pack4;

public class PolyTv extends PolyProduct {

  @Override
  public void volumeControl() {
    System.out.println("TV 소리 조절: " + getVolume());
  }

  public void tvShow() {
    System.out.println("TV 만의 고유 메소드");
  }

}
