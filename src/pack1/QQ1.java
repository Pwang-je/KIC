package pack1;

import java.util.Scanner;

public class QQ1 {

	public static void main(String[] args) {
		
		// 문)두 개의 실수와 연산자(a,s,m,d)를 각각 입력받아 사칙연산 수행. 
		//					    (+ - * /)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("실수 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("실수 2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		String yeon = sc.next();
		sc.close();
		
		switch (yeon) {
		case ("a"):
			System.out.println("결과 (+) : " + (num1+num2));
			break;
		case ("s"):
			System.out.println("결과 (-) : " + (num1-num2));
			break;
		case ("m"):
			System.out.println("결과 (*) : " + (num1*num2));
			break;
		case ("d"):
			System.out.println("결과 (/) : " + (num1/num2));
			break;
		}

	}

}
