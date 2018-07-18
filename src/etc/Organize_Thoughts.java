package etc;

public class Organize_Thoughts {

  // 기본 용어들.

  /*
   1. method.
   public static void main(String[] args) 에서 main(여기 안에도 포함해서) 부분에 메소드.
   메소드를 만드는 것을 "정의"라고 하고, 만들어진 메소드를 실행하는 것을 "호출"이라고 함.
   코드의 뒤에 return 이 있을 때, method 의 결과로 반환함.

   public static void num(int a) {
    int i = 0;
   }
   public static void main(String[] args) {
    int(5);
   }
    int(5) 에서 5의 값이 num 메소드의 (int a)로 강제로 할당됨.
   */





  // 기본형과 참조형.

  /*
  기본형은 8가지가 있음.
  boolean, char, byte, short, int, long, float, double.

  참조형은 이 8가지를 제외한 모든 것들.
   */




  // 생성자, 객체, 변수에 대하여.

  /*
    1. 생성자- 어떤 일을 시작하기 전에는 준비를 하는데  이것을 "초기화"라고 함.
    자바에서도 이 초기화 부분을 담당하는 기능이 생성자(constructor)임.
    객체를 생성할 때 항상 실행되며, 맨 처음 실행되는 메소드.
    - 생성자의 이름은 클래스의 이름과 항상 동일함.
    - default 값으로 안써도 됨. 하나 써주면 좋음.
    - 여러개를 만들수도 있음.

    Organize_Thoughts people = new Organize_Thoughts();
      // 생성자의 예시. <<< people 인스턴스 생성 >>>
    다음부터는
    people.설정한클래스();
    people.설정한클래스();  식으로 불러서 사용할 수 있음.
   */




  // getter(), setter().

      // private 로 선언된 값을 바꾸기 위해 사용함.
      // 헷갈리지 않기 위해 setter 부터 사용.
  // private 로써 현재 클래스에서만 사용 가능함.
  private int age = 10;
  private String name;

  public void setAge(int age) {    // setter 의 쓰임.
    this.age = age;
  }
  public int getAge() {   // getter  의 쓰임.
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }



  // overriding 과 overloading 의 차이.

  /*
  overriding 은 부모클래스의 메소드들을 대부분 그대로 사용하지만
  조금만 수정하고 싶을 경우 사용.
  ( 부모클래스와 다음에 만들 클래스의 교집합 부분을 찾아내야됨.
   예를 들어 멈춘다거나, 경적을 울린다거나 하는 경우. )
   super(); 의 경우, 부모클래스의 메소드도 같이 이용하고 싶을 경우 사용.!!!!!

   */









  // 추상 클래스 (abstract class) 를 할때의 주의점.

  /*
  1. 클래스를 '상속' 받을것. extends 를 꼭 써야함.
  2. override 를 사용함.
  3. 부모 클래스 및 상위 클래스로 이동을 위해서는 super(); 를 사용할 것.
      super(); 의 () 안에는
      3-1. super(string); 일때는 abstract public string Ex(); 같이 같은것만 가져올 수도 있음.
      3-2. 마찬가지로 super(int); 일대는 abstract public int Ax(); 같이 숫자를 가져올 수 있음.
   4. super(); 의 경우, 부모클래스의 메소드도 같이 이용하고 싶을 경우 사용.!!!!!
   */

  public class Car {
    String name;
    int number;
    public Car(String name, int number) {
      this.name = name;
      this.number = number;
    }   // this.를 써줌으로써 값을 전역변수로 올림.
  }

  public class Bus extends Car {
    int fee;

    public Bus(String name, int number, int fee) {
      // super 를 이용해서 Car 클래스의 생성자를 이용.
      super(name,number); // 이부분이 중요!!!!!!!!!
      this.fee = fee;
    }
  } // super(); 를 사용했기에 부모클래스인 Car 의 name 과 number 로 값을 올릴 수 있음!!!!


  // 클래스끼리의 ""형변환""에 대하여.
  /*
  형변환이 필요한 가장 근본적인 이유는, extends 로 자식 클래스가 부모 클래스를 참조했을 때,
  부모클래스가 더 큰 그릇이라고 보고 자식클래스가 작은 그릇이라고 봄.
  하지만 ""자식 클래스에만 있는"" method 를 실행하고 싶을 때, 부모클래스밖에 실행이 되지 않는 상황이 발생함.
  따라서, 부모 클래스를 생성자로 만들고 난 후, 그 부모 클래스를 자식 클래스로 형변환을 실행하여
  자식 클래스만 따로 실행할 수 있게함.
   */
  public class Car1 {
    public void run() {
      System.out.println("Car의 run메소드");
    }
  }
//  public static class Bus1 extends Car1 {
//    public void Crack() {
//      System.out.println("빵빵");
//    }
//  }




}
