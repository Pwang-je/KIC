package java_basic3.src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

  public static void main(String[] args) {

    HashSet<Object> list = new HashSet<Object>();
    list.add("lee");
    list.add(12);/*
    TryTest test = new TryTest();
    list.add(test);*/
    System.out.println(list.size());
    list.clear();
    System.out.println(list.size());
    list.add("lee");
    list.add("kml");
    list.add("han");
    list.add("k");
    System.out.println(list.size());
    list.remove("kim");
    System.out.println(list.toArray());
    print(list);
    System.out.println("-----------------");
    myprint(list.toArray());
  }

  public static void print(Set set) {

    StringBuffer sb = new StringBuffer();
    String imsi = null;

    Iterator<Object> iter = set.iterator();
    while (iter.hasNext()) {
      String ss = (String)iter.next();
      System.out.println(ss);
    // imsi += ss;
    sb.append(ss);
    }
    System.out.println(sb.toString());
  }

  public static void myprint(Object[] obj) {
    for (int i = 0; i < obj.length; i++){
      System.out.println(obj[i]);
    }
  }

}
