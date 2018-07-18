/*
package java_basic3.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection {

  ArrayList<StudDto> stuList = new ArrayList<>();

  public void inData() {
    Scanner scan = new Scanner(System.in);

    System.out.print("이름을 입력하세요. : ");
    String name = scan.next();
    System.out.print("국어점수를 입력하세요. : ");
    int lang = scan.nextInt();
    System.out.print("영어점수를 입력하세요. : ");
    int eng = scan.nextInt();

    StudDto sDto = null;  // arrayList 에 넣는 부분.
    sDto = new StudDto();
    sDto.setName(name);
    sDto.setLang(lang);
    sDto.setEng(eng);
    stuList.add(sDto);
  }   // inData();

  public void check_yesno() {
    System.out.print("계속??");
    System.out.println("  y/n");
    Scanner scan_check = new Scanner(System.in);

    while (true) {
      String yesno_check = scan_check.next();
      if (yesno_check.equals("y") || yesno_check.equals("Y")) {
        System.out.println("진행함");
        inData();
      } else if (yesno_check.equals("n") || yesno_check.equals("N")) {
        System.out.println("종료함");
        System.exit(0);
      } else {
        System.out.println("입력 똑바로좀;");
      }
    }
  }   // check_yes or no();

  public void displayData() {
    StudDto sDto_2 = new StudDto();
    System.out.println("이름: " + sDto_2.getName() +
        " 국어 점수: " + sDto_2.getLang() + " 영어 점수: " + sDto_2.getEng());
  }   // displayData();


  public static void main(String[] args) {
    Collection col = new Collection();
    col.inData();
    col.check_yesno();
    col.displayData();


    // display();

//    Scanner scan = new Scanner(System.in);
//
//    System.out.print("이름을 입력하세요. : ");
//    String name = scan.next();
//    StudDto dto = new StudDto();
//
//    dto.setName(name);
//
//    System.out.print("국어점수를 입력하세요. : ");
//    int lang = scan.nextInt();
//
//    System.out.print("영어점수를 입력하세요. : ");
//    int eng = scan.nextInt();
//    scan.close();
//
//    Collection test1 = new Collection();
//    test1.displayData();
  }   // psvm;

}
*/
