package Pack6;

// public class InterRadio implements InterVol, InterAdvanceVol {
  public class InterRadio implements InterAdvanceVol {

    private int v = 0;

  @Override
  public void VolOff() {

  }

  @Override
  public void VolResume() {

  }

  @Override
  public void volUp(int v) {
    this.v += v;
  }

  @Override
  public void volDown(int v) {
    this.v -= v;
  }

  public void show() {
    System.out.println("현재 볼륨은? " + v);
  }

}
