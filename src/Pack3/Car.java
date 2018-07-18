package Pack3;

public class Car {

  int speed =0;
  String Name, turnshow;
  Handle handle;

 // 생성자 호출 방법
  // 1. Handle hd = new Handle();
  // 2. Handle handle; 적고 생성자에 handle = new Handle();
  // 2번째것은 앞뒤고 바뀜.


  public Car() {

  }

  public Car(String name) {
    Name = name;
    handle = new Handle();
    turnshow ="직진";
  }

  public void play(int q) {
    if(q>0) {
      turnshow = handle.Right(q);
    }else if(q<0) {
      turnshow = handle.Left(q);
    }else {
      turnshow = handle.Straight(q);
    }
  }


  public void now() {
    System.out.println("안녕 내 이름은 "+Name +", 지금은 "+turnshow+" 상태야");
  }





}
