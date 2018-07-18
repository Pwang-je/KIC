package Pack6;

public class VolTv implements Volume {

  private int vol;

  public VolTv() {
    vol = 0;
  }

  @Override
  public void volUp(int level) {
    System.out.println("TV 소리 키워" + level);
  }

  @Override
  public void volDown(int level) {
    System.out.println("TV 소리 줄여" + level);
  }

  public void kbs() {
    System.out.println("국영방송: 9");
  }

}
