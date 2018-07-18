package Pack5;

public class AnimalMain {

  public static void main(String[] args) {

    Animal animal = null;

    AniCow cow = new AniCow();
    System.out.println(cow.name() + " " + cow.action() + "에 " + cow.eat() + "먹음");

    AniLion lion = new AniLion();
    System.out.println(lion.name() + " " + lion.action() + "에 " + lion.eat() + "먹음");
    lion.eatOther();

    System.out.println("-----------------");

    animal = cow;
    System.out.println(animal.name());
    animal = lion;
    System.out.println(animal.name());

    AnimalUtill.find(cow);
    System.out.println();
    AnimalUtill.find(lion);

    System.out.println("^^^^^^^^^^^^^^^^^");
//    AniDog dog = new aniDog() {}
    AniDog dog = new AniDogWolf();
    System.out.println(dog.name());
    System.out.println(dog.eat());
    System.out.println(dog.action());
  }

}
