package java_basic3.src;

import java.util.ArrayList;
import java.util.Iterator;

public class ItoratorTest {

  public static void main(String[] args) {

    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("KIM_0");
    arrayList.add("KIM_1");
    arrayList.add("KIM_2");
    arrayList.add("KIM_3");

    arrayList.add(3,"Park");    // 3번째 자리에 Park 을 집어 넣겠다 이거임.

    arrayList.remove("KIM_3");  // KIM_3 의 index 를 직접 없앨 수도 있음.
    arrayList.remove(3);     // 3 번째 배열에 있는 index 를 삭제할 수 있음.

    System.out.println(arrayList.size());   // arrayList 에 들어있는 데이터가 모두 몇개인지?
    System.out.println(arrayList.get(1));   // arrayList 의 1번째 배열안에 들어가 있는 값이 뭐인지?

    System.out.println(arrayList);

    // Iterator 는 ArrayList 를 탐색하기 위한 방법.
    Iterator itr = arrayList.iterator();
    // arrayList 는 이미 만들어져서 itr 에 값을 return.
    // Iterator 라는 interface 를 구현하고 있는 어떠한 객체를 return 해서, itr 이라는 변수에 담아주고 있다.

    while (itr.hasNext()) {
      String arValue = (String) itr.next();    // .next() 는 int 인건가???
    }
    /* 기본적으로 hasNext() 는 boolean 값임. false 아니면 true.
        현재 arrayList 라고 하는 ArrayList 가 다음에 가져올 수 있는 Elements 가 있느냐는 뜻.
        다음에 next() 를 호출하는데, arrayList 가 가지고 있는 데이터를 하나씩 arValue 로 할당시킴.
        그렇게 반복 작업을 하다가 마지막 element 를 가지고 온 이후에는 다음값이 없기에 hasNext() 는
        false 가 되면서 자동으로 종료함.
    */
    for (String arValue:arrayList) {
      System.out.println(arValue);
    }






  }
}


/*

  ** Array 와 List 는 비슷함.
  * Array 는 어떤 데이터가 저장 되어 있는 위치(index)가 제일 중요함.
  * List 의 경우에는 내부적으로 index 를 가지고 있지만, 더 중요한 것이 Elements 들의 순서가 훨씬 더 중요함.
  * Array = 아파트의 주소를 찾아서 바로 들어감,
  * List = 사람들이 서있을때, 이 사람 다음엔 어떤사람이 오고 그 후에 어떤사람이 오고 그 후에 ...

  public static void main(String[] args) {

   1. create Const.
   2. arraList.add(String);
      생성자.add(); 로 갯수와 상관없이 바로 생성할 수 있음.
   3. 출력은 항상 System.out.println 으로.

  }
*/