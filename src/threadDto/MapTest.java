package java_basic3.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

  public static void main(String[] args) {

    HashMap<String, String> list = new HashMap<>();
    list.put("0", "lee");
    list.clear();

    list.put("0", "park0");
    list.put("1", "park1");
    list.put("2", "park2");
    list.put("3", "park3");
    list.put("4", "park4");
    list.put("5", "park5");
    list.put("2", "kim");
    System.out.println(list.size());
    System.out.println(list.containsKey("11"));
    System.out.println(list.containsValue("kim"));
    list.remove("kim");

    display(list);

  }

  public static void display(Map map) {
    Set set = map.keySet();
    Iterator iter = set.iterator();
    while (iter.hasNext()) {
      String key = (String)iter.next();
      System.out.println(key + " " + map.get(key));
    }
  }


}
