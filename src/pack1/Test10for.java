package pack1;

public class Test10for {

	public static void main(String[] args) {
		
		int a, hap = 0;	// 누적 기억장소 초기화
		for ( a=1; a<=5; a++ ) {
			System.out.print(a + " ");
//			hap = hap + a;
			hap += a;
		// ! for 문 내에서 a 변수에 변화를 주지 말 것.
		}
		System.out.println("\na:" + a);
		System.out.println("합은 " + hap);

		for(int i=65; i<=90; i++) {
			System.out.print((char)i + "\t");
		}
		
		System.out.println();
		
		for (int i='A'; i<= 'Z'; i++) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		for ( int j = 10; j > 1; j -= 2) {
			System.out.print(j + " ");
		}
		
		System.out.println();
		
//		for ( int ytn = 0, tv = 5; ytn <= 5; tv++ ) {
//			System.out.print(ytn + " " + tv + ",");
//		}
		
		System.out.println();
		int aa = 1;
		for (; aa<=5; aa++) { 
			System.out.print(aa + " ");
		}
		
		System.out.println();
		
		// 구구단 3단.
		for (int count = 1; count < 10; count++) {
			if (count == 5) {
				System.out.println("5 만세");
			}
			System.out.println("3 * " + count + "=" + ( 3 * count) );
		}
		
		System.out.println("\n다중 for -------------");
		for (int m = 1; m <= 3 ; m++) {
			System.out.println("m= " + m);
			for (int n = 1; n <= 4 ; n++) {
				System.out.print("n= " + n + " ");
			}
			System.out.println();
		}
		
		for (char i = 65; i <= 90; i++ ) {
			System.out.print(i + " ");
			for ( char j = i; j <= 'Z'; j++ ) {		// j=i , 위에 i 이후 j.
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 1; i <= 10; i++) {
			if (i == 3) continue; // 아랫문장을 수행하지 않고 바로 for 문으로.
			System.out.println(i);
			if (i == 5) break;	// 여기서 끝남.
			// if ( i == 5 ) System.exit(1);	// break; 와 같이 반복문 탈출.
			// if ( 1 == 5 ) return;	// 메소드(method) 탈출.
		}
		
		System.out.println();
		
		int kk = 0;
		for(;;) {
			kk++;
			System.out.println("출력");
			if(kk==5) {
				break;
			}
		}
		
		System.out.println();
		
		for (int i = 1; i <= 3; i++) {
			aa:for (int j = 1; j <= 5; j++) {
				bb:System.out.println(i + " " + j + " ");
//				if (j == 3) {
//					continue aa; 
//				}
				if (j == 3) {
					break aa; 
				}
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	}	// static void main;

}	// class Test10for;
