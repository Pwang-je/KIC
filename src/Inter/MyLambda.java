package Inter;

import Inter.lamdatest.MyInter;

public class MyLambda {

  static class Inner implements MyInter {

    @Override
    public int addData(int a, int b) {
      return a+b;
    }

  }

  public static void main(String[] args) {
    Inner inner = new Inner();  // 원래 하던 방식.
    System.out.println(inner.addData(3, 4));

    System.out.println("--------------------------");

    MyInter myInter = (a, b) -> a + b;  // lambda 식
    System.out.println(myInter.addData(3, 4));
  }

}
