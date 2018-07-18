package pack1;

import java.util.Scanner;

public class Test11While {

	public static void main(String[] args) {
		
		// 반복문 while.
		
		int w = 1;	// for ( 변수 = 초기값; 조건문; 증감식) { }
		
		// while 은 꼭 변수를 지정해줘야함.
		while (w <= 5) {	// 조건이 참인 동안 반복.
			System.out.println("W: " + w);
			w += 1;	// 반복문을 빠져나올 수 있는 명령문이 필요함. (필수!)
		}
		System.out.println("\n반복문 탈출 후 W: " + w);
		
		System.out.println();
		w = 0;
		while(true) {
			w++;
			if (w == 3) {
				continue;
			}
			if (w == 5) {
				break;
			}
			System.out.println("w: " + w);
		}
		
		System.out.println();
		
		// 최소 1번은 반드시 수행함.
		w = 1;
		
		do {
			System.out.println("do while의 w: " + w);
			w++;
		} while ( w <= 5 );
		
		System.out.println("반복 처리의 예");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("숫자 입력 : ");
			int num = sc.nextInt();
			int n = 1, total = 0;
			while ( n <= num ) {
				total += n;
				n++;
			}
			System.out.println("total : " + total);
			System.out.print("continue? (1/0)");
			int c = sc.nextInt();
			if ( c != 1) {
				System.out.println("반복작업 종료");
				break;
			}
		}
		
			
		
		
		
		System.out.println("종료");

	}

}
