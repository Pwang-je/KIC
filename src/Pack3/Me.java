package Pack3;

public final class Me extends Father {

  private int nai = 50;
  public final String IRUM = "유일해"; // 값 수정 불가
  public String data = "Me data";

  public Me() {
    System.out.println("내 생성자");
  }

  public void play() {
    System.out.println("하고 싶은 거 하기");
  }

  @Override
  public int getNai() {
    return nai;
  }

  // override 불가.
/*  public final void eat() {
    System.out.println("밥은 맛있게.");
  }*/

  public void displayData() {
    String data = "displayData method의 data";
    System.out.println(data); // Local (최우선)
    System.out.println(this.data);  // 멤버변수 data.
    System.out.println(super.data); // 부모의 data.
  }


}
