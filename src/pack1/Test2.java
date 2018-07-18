package pack1;

public class Test2 {

	public static void main(String[] args) {
		// 산술 연산자.
		int a = 5;	// 치환 연산자 (=)
		int b = 3;
		int c = a+b;
		System.out.println("c: " + c);
		
		System.out.println();
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);	// 몫
		System.out.println(a%b);	// 나머지
		System.out.println(a/ (double)b);	// 몫과 나머지
		
		// System.out.println(a/0);
		System.out.println(1/0.0);
		System.out.println(a%0.0);
		
		System.out.println(3+4*5);	// *./ > +,-  연산자 우선순위.
		System.out.println((3+4)*5); // 강제로 () 우서순위 부여.
		
		String ss1 = "자바";
		String ss2 = "만세";
		String ss3 = ss1+ss2;	// 문자열 더하기.
		System.out.println("ss3 : " + ss3);
		System.out.println(ss3 + " " + 2018);	// 숫자는 문자열화가 됨.
		System.out.println(ss3 + " " + 2018 + 6);
		System.out.println(ss3 + " " + (2018 + 6));
		
		String ss4 = "5" + 6;
		System.out.println(ss4);
		
		int ia = Integer.parseInt("5")+6;		// 숫자화.
		System.out.println("ia : " + ia);
		
		String ss5 = Integer.toString(5) + 6;	// 문자화.
		System.out.println("ss5 : " + ss5);
		
		// 누적.
		System.out.println();
		int no = 1;
		System.out.println("no는 " + Integer.toString(no));
		no = no + 1;
		no += 1;
		no++;	// 후위증가연산자.
		++no;	// 전위증가연산자.
		System.out.println("no는 " + no);
		
		// 증강 연산자에 대해
		System.out.println();
		int imsi = 5;
		int result = ++imsi + 1;
		System.out.println(imsi);
		System.out.println(result);
		
		System.out.println();
		int imsi2 = 5;
		int result2 = imsi2++ + 1;
		System.out.println(imsi2);
		System.out.println(result2);		
		
		// 부호에 관해
		System.out.println();
		int imsi3 = 3;
		System.out.println(imsi3);
		System.out.println(imsi3 * -1);
		System.out.println(-imsi3);
		
		
		System.out.println("프로그램 종료");		
	}

}
