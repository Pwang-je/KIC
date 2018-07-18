package Pack2;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class MySingleton {

  int kor = 90;

  private static MySingleton singleton = new MySingleton();
  public static MySingleton getInstance() {
    return singleton;
  }



}
