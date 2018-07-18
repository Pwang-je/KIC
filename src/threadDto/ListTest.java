package java_basic3.src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListTest {

  public static void main(String[] args) {
    // arraylist;
    // List type 의 ArrayList : 순서가 있고 중복 허용.
    ArrayList<String> list = new ArrayList<>();
    list.add("kim");
    list.clear();
    list.add("kim");
    list.add("lee");
    list.add("kim");
    list.add("park");
    list.add("choi");
    System.out.println(list.size());
    System.out.println(list.get(1));
//    list.remove(1);
//    list.remove("lee");   // 둘다 같음.
    System.out.println(list.contains("kim"));
    System.out.println(list.indexOf("park"));

    System.out.println();
    pr1(list);
    System.out.println();
    pr2(list);


  }

  public static void pr1(List<String> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
  public static void pr2(ArrayList<String> list) {
    for (String b : list) {
      System.out.println(b);
    }
  }

}
