package Pack5;

public class AniLion extends Animal {

  @Override
  public String name() {
    return "사자";
  }
  @Override
  public String eat() {
    return "소";
  }
  @Override
  public String action() {
    return "밤";
  }

  public void eatOther() {
    System.out.println("물도 마셔야 하죠.");
  }

}
