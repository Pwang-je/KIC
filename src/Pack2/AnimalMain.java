package Pack2;

public class AnimalMain {

  public static void main(String[] args) {
    System.out.println("뭔가를 하다가...");

    Animal tiger = new Animal();  // 생성자 호출
    tiger.display();
    tiger.display(5);
    tiger.display("호랭이");
    tiger.display(12, "사자");
    tiger.display("기린",42 );

    System.out.println();

    Animal bird = new Animal(2);
    bird.display();
    bird.display("참새",2 );

    System.out.println();

    Animal wolf = new Animal("늑대" );
    wolf.display();

    System.out.println();

    Animal dog = new Animal("콜", 4);
    dog.display();

    System.out.println("-- static --");
    dog.myStaticMethod(); // 이렇게 써도 되는데
    Animal.myStaticMethod();  // 이게 의도에 맞음.
    dog.normalMethod();


  } // public static void main ;

}
