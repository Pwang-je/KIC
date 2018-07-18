package pack1;

import java.math.BigDecimal;

public class Test5 {
	public static void main(String[] args) {
		
//		double a = 1.5;
//		double b = 1.2;
		double a = 2.0;
		double b = 1.1;
		System.out.println(a+b);
		System.out.println(a-b);
		
		System.out.println();
		// BigDecimal 은 소수점 둘째자리 이하를 올림.
		BigDecimal d1 = new BigDecimal("2.0");
		BigDecimal d2 = new BigDecimal("1.1");
		System.out.println(d1.subtract(d2));
		
		System.out.println();
		// 아주 큰 정수는 BigDecimal 로 처리할 수 있음.
		BigDecimal no1 = new BigDecimal("123456789123456789123456789");
		BigDecimal no2 = new BigDecimal("19487398275938793487985237582985285");
		System.out.println(no1.add(no2));
		System.out.println(no1.multiply(no2));
		System.out.println(no1.divide(no2, 2, BigDecimal.ROUND_UP));
		
		
		
		
		System.out.println("종료");

	}

}
