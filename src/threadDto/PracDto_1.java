/*
package threadDto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class PracDto_1 {

  ArrayList<Sawon_Dto> list_2 = new ArrayList<>();

  public PracDto_1() {
//    list_2 = new ArrayList<>();
  }

  public void inputData(String[] args) {

    Sawon_Dto dto;

    for (int i = 0; i < args.length; i++) {
      System.out.println(args[i]);
      StringTokenizer tok = new StringTokenizer(args[i], ",");

      int sabun = Integer.parseInt(tok.nextToken());  // 사번
      String name = tok.nextToken();                  // 이름
      int kibon = Integer.parseInt(tok.nextToken());  // 기본급
      int ipsa = Integer.parseInt(tok.nextToken());   // 입사년도

      Sawon_Dto sawon_dto = new Sawon_Dto();
      sawon_dto.setSabun(sabun);
      sawon_dto.setName(name);
      sawon_dto.setKibon(kibon);
      sawon_dto.setIpsa(ipsa);
      list_2.add(sawon_dto);

      // 입사년도.
      Calendar cal = Calendar.getInstance();
      int year = cal.get(Calendar.YEAR);
      int gunmu = year - ipsa;

      // 급여액 ( 기본급 + 근속수당 )
      int kub = kibon +

      // 공제액.
      if (gunmu < 3) {
        int gong = (int) ((kibon + 150) * 0.5);
      } else if (gunmu >= 4 && gunmu <= 8) {
        int gong = (int) ((kibon + 450) * 0.5);
      } else if (gunmu <= 9) {
        int gong = (int) ((kibon + 10000) * 0.5);
      }

      // 수령액.
      if ()



    }

근무년수 : 현재년도 - 입력된년도
근속수당 : 아래 표 참조
공 제 액  : (기본급 + 근속수당) * 0.5%
수 령 액  : 기본급 + 근속수당 - 공제액


    Sawon_Dto sala = new Sawon_Dto(); // 기본급

    // 공제액 부분.




  }

  public void printData(String[] args) {

    System.out.println("사번\t이름\t기본급\t입사년도\t근속수당\t공제액\t수령액");
    for (Sawon_Dto sawon:list_2) {
//      int 공제액 = (기본급 + 근속수당) * 0.05;
      int gong = (sawon.getKibon() + gunsok) * 0.05;
//      int 수령액 = 기본급 + 근속수당 - 공제액;
      int suryung = sawon.getKibon() + gunsok - gong;
    }
    System.out.println();

  }

  public static void main(String[] args) {

    if (args.length == 0) {
      System.out.println("입력자료 없음, 잘가~");
      System.exit(0);
    }
    PracDto_1 test2 = new PracDto_1();
    test2.inputData(args);
    test2.printData(args);

  }

}
*/
