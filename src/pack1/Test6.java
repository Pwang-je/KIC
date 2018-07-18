package pack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) throws Exception {
		
		// 프로그램 진행 중 외부에서 값 얻기.
		if (args.length == 0) {
			System.out.println("외부에서 파일을 불러올 수 없습니다.");
			System.exit(1);	// 강제 종료.
		}
		
		System.out.println(args[0]);
		
		System.out.println("\n키보드로 값 얻기");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름입력 : ");
		String name = buf.readLine();
		System.out.print("나이입력 : ");
		String age = buf.readLine();
		System.out.println("이름은 " + name + " 이고, 나이는 " + age + " 입니다");
		buf.close(); // 자원 해제
		
		
		System.out.println("\n키보드로 값 얻기2");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("상품명 : ");
		String product = sc.next();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.println("상품명은 " + product + " 이고, 가격은 " + (price * 100/100) + " 원 입니다.");
		sc.close();
		
		
		System.out.println("프로그램 정상 종료");
		
		

	}

}
