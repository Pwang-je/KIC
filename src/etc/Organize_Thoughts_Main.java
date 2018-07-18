package etc;

//import etc.Organize_Thoughts.Bus;
//import etc.Organize_Thoughts.Bus1;
//import etc.Organize_Thoughts.Car1;

public class Organize_Thoughts_Main {

  public static void main(String[] args) {


// getter(), setter()

    Organize_Thoughts people = new Organize_Thoughts();

    people.setAge(20);  // setAge() 로 나이를 직접 설정.
    System.out.println("나이는 " + people.getAge());
    people.setName("홍길동");
    System.out.println("이름은 " + people.getName());

/*  people.setAge(20) 으로 설정하면 20의 값이 organize_Thoughts 의
    public void setAge(int age) { this.age=age; } 로 들어감.
    << setAge(int age) = setAge(20). >>
    setAge(20) 의 값이 밑의 this.age = age; 의 age 로 들어가고,
    << this.age = 20; >> 20의 값이 this.age 로 들어가면서 값이
    private int age = 10; 으로 넘어감. << this 사용의 이유. >>
    private int age = 10; 이 20 으로 바뀌며, println 할때 getAge() 를
    이용하여 20의 값을 뿌림.
    public void 로 아무때나 가져올 수 있으며 getAge() 안에는
    return age; 가 있어서 << return 20; 과 같고, getAge(20) 과 같음 >>
    private 를 public 으로 20 을 println 으로 뿌려줄 수 있음.
 */

  // 형변환 예제-----------------------
//    Car1 car1 = new Bus1();
//    car1.run(); // 부모꺼 실행됨.
////    car1.crack(); // 자식메소드인 Crack 이 실행되지 않음.
//    // 자식 메소드의 Crack 을 호출하고 싶다면,
//    Bus1 bus1 = (Bus1)car1; // car1 에 상속된 bus1 을 가져다 쓰겠다! 이런 느낌으로 하면됨.
//    bus1.Crack(); // 꼭 이렇게 실행해 줘야함.






  } // public static void main ;
}
