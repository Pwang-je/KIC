package java_basic3.src;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class DtoTest2 {
  ArrayList<HaksengDto> list;
  public DtoTest2() {
    list = new ArrayList<HaksengDto>();
  }
  public void inputData(String[] datas) {

    HaksengDto dto;

    for (int i = 0; i < datas.length; i++) {
      System.out.println(datas[i]);
      StringTokenizer tokenizer = new StringTokenizer(datas[i], "");
      String irum = tokenizer.nextToken();
      int ko = Integer.parseInt(tokenizer.nextToken());
      int en = Integer.parseInt(tokenizer.nextToken());
      int ma = Integer.parseInt(tokenizer.nextToken());
      HaksengDto dto_tt = new HaksengDto();
      dto_tt.setName(irum);
      dto_tt.setKo(ko);
      dto_tt.setEn(en);
      dto_tt.setMa(ma);
      list.add(dto_tt);
    }
  }
  public void printData() {
    // 각 학생의 이름, 총점, 평균 출력.
    System.out.println("이름\t총점\t평균");
    for (HaksengDto hak:list) {
      int ma = hak.getEn() + hak.getEn() + hak.getMa();
      int avg = ma / 3;
      System.out.println(hak.getName() + "\t" + ma + "\t" + avg);
    }
  }



  public static void main(String[] args) {

    /*
    String ss = "kbs,mbc,sbs";
    StringTokenizer tokenizer = new StringTokenizer(ss,"," );
    System.out.println(tokenizer.nextToken());
    String s = tokenizer.nextToken();
    System.out.println(s);
    */
    String[] datas = new String[3];
    datas[0] = "신선해, 100, 100, 100";
    datas[1] = "신기루, 80, 70,60";
    datas[2] = "신기한, 80, 88, 77";

    DtoTest2 test2 = new DtoTest2();
    test2.inputData(datas);
    test2.printData();
  }

}
