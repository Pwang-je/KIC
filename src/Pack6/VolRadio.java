package Pack6;

public class VolRadio implements Volume {

  private int volLevel;
  VolRadio() {
    volLevel = 0;
  }

  @Override
  public void volUp(int level) {
    volLevel += level;
    System.out.println("라디오 볼륨 올리면 " + volLevel);
  }

  @Override
  public void volDown(int level) {
    volLevel -= level;
    System.out.println("라디오 볼륨 내리면 " + volLevel);
  }

}
