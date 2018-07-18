package Pack2;    // 성격이 비슷한 클래스들을 모아둠.

// 클래스 선언방법 - 2개의 member를 가짐.
public class Car {    // [접근지정자][기타제안자] class 클래스명.

  // 접근지정자 : public, private, protected, 생략

  // member field ( 멤버변수, 전역변수 )
  int wheel;    // [접근지정자] [기타제안자] type 멤버명.
  private int airBag = 1;   //
  private int speed;    // private는 캡슐화. (현재 클래스에서만 참조됨)
  public String name;

  public Car() {
    // 객체 생성 시 초기화 작업을 함
    // 객체 생성 시 가장 먼저 시스템에 의해 호출
    // 인위적으로 호출 불가
    System.out.println("Car 클래스 생성자");
    wheel = 4;
  }

  // 멤버 메소드
  // [접근지정자][기타제안자] 반환명 메소드명 ( 인수, 인자, ... )
  public void abc() {
    System.out.println("abc 메소드(method) 수행");
    System.out.println("에어백 수 : " + airBag);  // private 멤버 호출
    System.out.println("바퀴 수 : " + wheel);  // default.
    def();  // 자신이 속해 있는 클래스 내의 메소드 호출.
    int result = corea(68);
    System.out.println("스피커 볼륨은: " + result);
    System.out.println("속도는 " + speed);
    int year = 2018;   // 지역변수(Local Var.)는 초기값 필수!!
    System.out.println("생산년도 : " + year);
  }

  private void def() {
    System.out.println("def 메소드 처리");
  }

  int corea (int speaker_vol) {
    int pro = speaker_vol + 10;
    return pro;
  }

/*  private int Speed;
  public int getSpeed() {  // private 멤버에 대한 외부 접근 가능 메소드!!!
    // getter
    return speed;
  }

  public void setSpeed(int speed) {
    // setter
    this.speed = speed;
    // speed = speed 일때는 지역변수 speed 가 speed 에게 넘기지만,
    // this.speed = speed 일때는 지역변수 speed 가 멤버변수 speed 에게 넘김.
  }*/

  public int getSpeed() {   // getter
    return speed;
  }

  public void setSpeed(int speed, int password) {   // setter
    if (password == 1234) {
      this.speed = speed;
    } else {
      System.out.println("비밀번호 불일치!");
    }
  }








}
