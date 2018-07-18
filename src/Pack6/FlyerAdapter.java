package Pack6;

abstract public class FlyerAdapter implements Flyer {

  @Override
  public void fly() {}

  @Override
  public boolean isAnimal() {
    return false;
  }

}
