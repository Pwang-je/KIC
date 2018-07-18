package Pack5;

public class JepumCellphone extends Jepum {

  @Override
  public void volumeControl() {
    // override 강요.
    System.out.println("핸드폰 사운드 조정");
  }

  @Override
  public void volumeShow() {
    // override 선택
    setVolume(10);
    System.out.println("소리 크기: " + getVolume());
  }
}
