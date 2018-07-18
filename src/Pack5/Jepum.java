package Pack5;

public abstract class Jepum {   // 추상 클래스 : new 안됨.

  public int volume = 0;

  public Jepum() {
    System.out.println("추상 클래스 생성자");
  }

  public void setVolume(int i) {
    this.volume = volume;
  }
  public int getVolume() {
    return volume;
  }

  public void volumeShow() {
    System.out.println("소리 크기는 : " + volume);
  }

  // 추상 메소드. override 를 강요함.
  abstract public void volumeControl();  // body { } 가 없는 method.




}
