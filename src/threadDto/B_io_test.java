package threadDto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_io_test {

  String s2; // DTO 데이터 그릇
  ArrayList<B_io_test> list = new ArrayList<>();
  B_io_test b1;
  String library;

  public B_io_test() {

  }
  public void aa() throws Exception {
    File file = new File("c:/aa.txt");
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    while (true) {
      String s1 = br.readLine();
      if (s1 == null) break;


      StringTokenizer tok = new StringTokenizer(s1, ",");
      library = tok.nextToken();
//      System.out.println(library);
      System.out.println(br.readLine());
    }
    br.close(); fr.close();
  }

  public static void main(String[] args) {
    B_io_test ab = new B_io_test();
    try {
      ab.aa();
    } catch (Exception e) {

    }
  }


}
