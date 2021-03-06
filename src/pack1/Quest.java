package pack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Quest {

	public static void main(String[] args) throws Exception {
		
		
		// 문제 ) 키보드로 부터 상품명, 수량, 단가를 각각 입력받아 금액(수량*단가) 구하기.
		// 조건 : 금액이 5만원 이상이면 금액의 10%, 아니면 금액의 5%를 세금으로 출력한다.
		// 출력   상품명:***  금액:***  세금:***
		
		// 키보드로 값 얻기.
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("상품명 입력: ");
		String pName = buf.readLine();
		
		System.out.print("수량 입력: ");
		String pQty = buf.readLine();
		
		System.out.print("단가 입력: ");
		String uPrice = buf.readLine();		
						
		int pPrice = Integer.parseInt(uPrice);
		int pDan = Integer.parseInt(pQty);
		int ppTax = pPrice*pDan;
		
		int ppQty = Integer.parseInt(pQty);
		int uuPrice = Integer.parseInt(uPrice);
		int pppQty = ppQty*uuPrice;
	
		// 조건문.		
		Double pTax = 0.0;
		
		if ( ppTax >= 50000 ) {
			pTax = ppTax*0.1;
		} else {
			pTax = ppTax*0.05;
		}		
		int pppTax = (int)(Math.ceil(pTax));
		System.out.println("상품명은: " + pName );
		System.out.println("금액은: " + pppQty );
		System.out.println("세금은: " + pppTax + "원" );

	
		
		// 문)두 개의 실수와 연산자(a,s,m,d)를 각각 입력받아 사칙연산 수행. 
		//					    (+ - * /)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 실수 입력: ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 실수 입력: ");
		int num2 = sc.nextInt();
		
		System.out.print("연산자 입력 (a,s,m,d) : ");
		String yeon = sc.next();
		sc.close();
				
		switch (yeon) {
		case "a":
			System.out.println("result (+): " + (num1+num2));
			break;
		case "s":
			System.out.println("result (-): " + (num1-num2));
		case "m":
			System.out.println("result (*): " + (num1*num2));
			break;
		case "d":
			System.out.println("result (/): " + (num1/num2));
			break;
		}
		
				
		
		
		
	}

}
