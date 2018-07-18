package Pack5;

public class AnimalUtill {

  public static void find(Animal animal) {
    animal.print();

    // instanceof 객체타입 비교 연산자. 맞으면 true, 틀리면 false.
    if (animal instanceof AniCow) {
      Animal a = animal;  // Animal a = (AniCow)animal;
      System.out.println("이름 " + a.name());
    } else if (animal instanceof AniLion) {
      Animal b = animal;
      System.out.println("이름 " + b.eat());
    } else {
      System.out.println("기타 동물");
    }
  }

}
