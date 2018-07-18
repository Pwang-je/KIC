package Pack2;

public class ClassPrac {

  public String nickName;
  private int age = 0;
  String skill = "front-end developer";

  // nickName
/*  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  public String getNickName() {
    return nickName;
  }*/

  public ClassPrac() {
    System.out.println("초기화");
  }

  // skills
  public void skillDisplay() {
    String skd = reSkd();
    System.out.println("스킬은 " + skill + "이고 이름은 " + nickName +
                        "나이는 " + age);
  }

  public String reSkd() {
    return "보유 기술은 " + skill;
  }

  // age
  public void setAge(int age) {
    this.age = age;
  }
  public int getAge() {
    return age;
  }

  // setter
/*  public void setNickName (String nickName) {
    this.nickName = nickName;
  }
  // getter
  public String getNickName() {
    return nickName;
  }*/


}

