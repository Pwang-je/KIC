package Pack6;

public class Resume_Main {

  public static void main(String[] args) {

    R_Tom tom = new R_Tom();
    tom.setName("톰");
    tom.setPhone("111-1111");
    tom.setAddress("강남구 테헤란로 111");
    tom.print();

    System.out.println();

    tom.playJava(false);
//    tom.changeData(); // 안됨.
    Resume.changeData(); // static 이라서.

    R_James james = new R_James();
    james.setName("제임쓰");
    james.setPhone("222-2222");
    james.setSkill("자바후로그래머");
    james.print();

    System.out.println("\n인사담당자가 이력서 보기 ----");

    Resume[] resBox = new Resume[2];
    resBox[0] = tom;
    resBox[1] = james;
    for (Resume kbs:resBox) {
      kbs.print();
      System.out.println("\n*****다음 지원자 정보*****");
    }


  }

}
