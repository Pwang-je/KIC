package Pack4;

public class DogMain {

  public static void main(String[] args) {

    Dog dog = new Dog();
    dog.print();
    System.out.println(dog.callName());

    System.out.println("HouseDog -----");
    HouseDog hd = new HouseDog("집 강아지");
    hd.print();
    hd.show();
    System.out.println(hd.callName());

    System.out.println("WolfDog -----");
    Wolfdog wd = new Wolfdog("야생 늑대");
    wd.print();
    wd.show();
    System.out.println(wd.callName());
    wd.display();

    System.out.println("**********");
    Wolfdog bushdog = wd;
    bushdog.print();

    System.out.println();
    Dog dog2 = wd;
    dog2.print(); // overriding 된 method 만 가능함.
    /*dog2.show();  // 안됨.
    dog2.display(); // 안됨.*/

    /*bushdog = dog2; // 불가.*/
    /*bushdog = dog2; // 불가.
    wd = dog2;  // 불가.*/
    wd = (Wolfdog)dog2; // 가능.
    bushdog = (Wolfdog)dog2;  // 가능.

    Dog coyote = new Dog("코요테");
    coyote.print();
    System.out.println(coyote.callName());
    coyote = bushdog; // 가능.
    coyote.print();


  } // PSVM;


}
