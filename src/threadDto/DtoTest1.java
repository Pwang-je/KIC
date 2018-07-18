package java_basic3.src;

import java.util.ArrayList;

public class DtoTest1 {

  ArrayList<StudentDto> list = new ArrayList<>();

  public void aa() {
    String persons[] = new String[3];
    persons[0] = "홍길동";
    persons[1] = "신길동";
    persons[2] = "나길동";

    for (String s:persons) {
      System.out.println(s);
    }
  }

  public void insertData() {    // 여러명의 학생 정보를 기억.
    StudentDto dto = null;

    dto = new StudentDto();
    dto.setHakbun("ks100");
    dto.setIrum("손오공");
    dto.setJumsu(90);
    list.add(dto);

//    StudentDto dto1 = new StudentDto();
    dto = new StudentDto();
    dto.setHakbun("ks110");
    dto.setIrum("사오정");
    dto.setJumsu(88);
    list.add(dto);

    dto = new StudentDto();
    dto.setHakbun("ks120");
    dto.setIrum("저팔계");
    dto.setJumsu(74);
    list.add(dto);
  }

  public void displayData() {
    System.out.println("저장된 학생 수는 : " + list.size() + " 명 입니다.");

    for (int i = 0; i < list.size(); i++) {
      StudentDto dto = list.get(i);

      /*
      ArrayList<StudentDto> list = new ArrayList<>();
      ArrayList list = new ArrayList(); 와 같지만 <StudentDto> 를 지웠을 때,
      for 문에서 StudentDto dto = (StudentDto)list.get(i) 로 해야 err 이 안남.
      */
      System.out.println(dto.getHakbun() + " " +
                  dto.getIrum() + " " + dto.getJumsu() + " ");
    }
  }

  public static void main(String[] args) {
    DtoTest1 test1 = new DtoTest1();
    test1.aa();
    test1.insertData();
    test1.displayData();
  }

}
