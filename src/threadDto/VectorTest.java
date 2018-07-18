package java_basic3.src;

import java.util.Vector;

public class VectorTest {

  public static void main(String[] args) {

//    Vector<Object> vector = new Vector<>(처음에 줄 갯수, 더 들어올때 늘어날 갯수);
    Vector<Object> vector = new Vector<>();
    vector.add('a');  // auto boxing : 기본형을 객체로 변환해서 저장을 한다.
    vector.addElement("hong");
    vector.add(100);
    vector.add(12.323232);
    Vector vector1 = new Vector<>();
    vector.add(vector1);
    System.out.println("백터 크기는 : " + vector.size());

    for (Object object:vector) {
      System.out.println(object);
    }

  }

}
