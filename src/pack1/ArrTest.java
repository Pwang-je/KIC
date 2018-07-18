package pack1;

public class ArrTest {

  public static void main ( String[] args) {

  // 배열 : 성격과 크기가 일치하는 복수 기억장소를
  // 대표명 하나를 주고 첨자(index)로 각 기억장소를 구분.
  // 반복처리가 효과적이다.

  /*  int ar[];
    ar = new int[5];*/  // 기억장소 확보.
    int ar[] = new int[5];
    System.out.println("ar 배열 크기 : " + ar.length);

    ar[0] = 10;
    ar[1] = 20;
    ar[4] = ar[0] + ar[1];
    int k = 4, kbs = 2;
    System.out.println(ar[4]);
    System.out.println(ar[k]);
    System.out.println(ar[kbs + 2]);

//    ar[-2] = 30;  error!
//    ar[5] = 30;   error!

    // 선언과 함께 값을 부여.
    int[] ar1 = {1,2,3,4,5};
    System.out.println(ar1[0]);
    for ( int i = 0; i < ar1.length; i++ ) {
      System.out.print(ar1[i] + " ");
    }

    System.out.println("\n 향상된 for : 배열, 컬렉션에서 사용함");
    for ( int i:ar ) {
      System.out.print(i + " ");
    }

    System.out.println();
    String city[] = {"서울", "대전", "대구", "부산", "광주"};
    System.out.print(city);
    for ( String c:city ) {
      System.out.println("도시명은 : " + c );
    }

    System.out.println("-----------");

    int[] ar2 = new int[5]; // 초기치로 0.
    for ( int i = 0; i < ar2.length; i++ ) {
      ar2[i] = i + 1;
    }

    for ( int i = 0; i < ar2.length; i++ ) {
      System.out.println( ar2[i] + " ");
    }

    int hap = 0;
    for ( int j = 0; j < ar2.length; j++ ) {
      hap += ar2[j];
    }
    System.out.println("\n합은 " + Integer.toString(hap));

    System.out.println("-----------");

    System.out.println("\n 배열자료로 분산 구하기");
    int arr[] = {1,3,-2,4};   // 1차원 배열.

    double sum = 0;
    for ( int i = 0; i < arr.length; i++ ) {
      System.out.println(arr[i] + " ");
      sum += arr[i];
    }
    System.out.println("\n합은 : " + sum );
    double avg = sum / arr.length;
    System.out.println( "평균은 : " + avg);

    double tot = 0.0;
    for ( int su = 0; su < arr.length; su++ ) {
      tot += Math.pow ( arr[su] - avg, 2 );
    }
    double veri = tot / arr.length;
    System.out.println("분산은 : " + veri );

    double sd = Math.sqrt( veri );  // sqrt = 루트
    System.out.println("표준편차는 : " + sd );










    }

}
