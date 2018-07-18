package Pack3;

public class Student {

  protected String name = "기본 이름부분";
  protected int grade = 1;
  protected String gender = "m";

  public Student() {
    System.out.println("Student const");
  }

  protected void study() {
    System.out.println("학생이 Java 를 함.");
  }




}
