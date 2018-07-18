package Pack2;

class OutProjectMain {

  public static void main(String[] args) {
    System.out.println("뭔가 하다가...");

    Animal animal = new Animal("사자", 5);
    animal.display();

    System.out.println();
    MyCalc calc = new MyCalc();
    System.out.println(calc.goMinus(3,10 ));
    System.out.println(calc.goTri(14,2 ));

    System.out.println(Math.PI);

  }

}
