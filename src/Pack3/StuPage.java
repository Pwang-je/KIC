package Pack3;

public class StuPage extends Student {

  String name = "페이지";
  int grade = 2;
  String gender = "f";

  public StuPage() {
    System.out.println("StuPage const");
  }

  @Override
  protected void study() {
    System.out.println("학생은 Python 도 해야함.");
  }

  public void mySpec() {
    System.out.println("보유기술:프로그래밍 전문");
  }

  public void print() {
    System.out.println("~~~~~~~~~~");
    System.out.println(name);
    System.out.println(this.name);
    System.out.println(super.name);
    System.out.println();
    study();
    this.study();
    super.study();
    System.out.println("~~~~~~~~~~");

  }



}
