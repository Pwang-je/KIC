package pack1;

import java.util.Scanner;

public class QQ3 {

	public static void main(String[] args) {
		// 삼각형의 세 꼭지점의 좌표를 입력받아 
		// 그 삼각형이 직각삼각형이면 'Yes'를, 그렇지 않으면 'No'를 
		// 출력하는 프로그램을 만드세요. 

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 좌표: ");
		int Coord1 = sc.nextInt();
		
		System.out.println("두번째 좌표: ");
		int Coord2 = sc.nextInt();
		
		System.out.println("세번째 좌표: ");
		int Coord3 = sc.nextInt();
		sc.close();
		
		if ( Coord1 == 90 ) {
			System.out.println("yes");
		} else if ( Coord2 == 90 ) {
			System.out.println("yes");
		} else if ( Coord3 == 90 ) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		
	}

}
