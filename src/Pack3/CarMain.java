package Pack3;

public class CarMain {

  public static void main(String[] args) {

    Car tom = new Car("얍얍이");
    tom.play(-1);
    System.out.println(tom.Name + "의 회전량은 " +
        tom.turnshow + " " + tom.handle.trn);
    tom.now();

    tom.play(0);
    System.out.println(tom.Name + "의 회전량은 " +
        tom.turnshow + " " + tom.handle.trn);
    tom.now();

    Car cs = new Car("춘스");
    cs.play(20);
    System.out.println(cs.Name + "의 회전량은 " +
        cs.turnshow + " " + cs.handle.trn);
    cs.now();
  }
}
