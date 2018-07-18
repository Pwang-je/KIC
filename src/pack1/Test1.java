package pack1;

public class Test1 {

	public static void main(String[] args) {
		System.out.print("환영합니다");
		System.out.println("안녕");
		System.out.println("반가워");	// ln은 한칸을 내림.
		
		
		System.out.println(); // 라인스킵용.
		// 단순 변수 : 기억장소의 이름.
		// 기본형 기억장소 : 상수 자체를 기억장소가 기억.
		byte var1;
		var1 = 10;
		var1 = 3;
		System.out.println(var1);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE + "\n");
		
		long var4 = 2147483648L;		// 8byte , 뒤에 L 을 붙여서 long형이라고 인식시킴.
		System.out.println("var4 : " + var4);
		
		System.out.println("----------------");
		// promotion : 자동 형변환, casting : 강제 형변환.
		// byte b1 = 127;	// 자동 형변환.
		byte b1 = (byte)128;	// (byte)로 강제 형변환 = casting.
		System.out.println(b1);
		byte b2 = 10;
		byte b3 = (byte)(b2 + 1);
		System.out.println(b3);
		
		System.out.println();
		// short s1 = (short)10;
		int i1 = 10;	// 위에와 같음. (short)생략.
		System.out.println(i1);
		short s2 = (short)i1;
		System.out.println(s2);
		
		System.out.println("\n---- 실수");
		double d1 = 1.2;
		d1 = 3;		// promotion.
		System.out.println("d1 : " + d1);
		d1 = 56.7;
		
		float f1 = 3.5F;		// 4byte 실수형 기억장소. 소수점 있는건 8바이트로 인식해서 float 는 애러가 남. 그럴때 뒤에 F 붙여주면 됨.
		// float #f1 = 3.5;		// 위에와 마찬가지.
		// float f1 = (float)3.5;	// 마찬가지.
		System.out.println("f1 : " + f1);
		
		int i2 = (int)3.5;
		System.out.println("i2 : " + i2);
		
		System.out.println();
		// double result = 4.5 + 10;	// 연산시 큰 타입으로 자동 형변환.
		// double result = 4.5 + (double)10;
		double result = (int)4.5 + 10;	// int 로 인해서 소수점 뒷자리가 짤림.
		System.out.println("result : " + result);
		
		double dd = 5.5;
		int result2 = (int)4.5 + (int)dd;
		System.out.println("result2 : " + result2 );
		
		System.out.println();
		boolean bu1 = true;
		bu1 = false;
		System.out.println("bu1 : " + bu1);
		
		System.out.println();
		char ch1 = 'a';		// 문자는 ' ' 씀.
		// ch1 = 'asd';	// error.
		// ch1 = "a";	// String을 char에 넣어서 애러남.
		System.out.println("ch1 : " + ch1 + " " + (int)ch1 + " " + (char)97 + " " + (int)'A' + " " + (int)'0');
		
		System.out.println("\n문자열 : String 객체 = 참조형");
		String ss = "acb";
		System.out.println("ss : " + ss);
		String msg = "자바는 문자열을 기본형 처럼 표시 가능";
		System.out.println("msg : " + msg);
		
		// bsilfdbc - 기본형
		
	}

}
