package pack1;

public class Test11Exam {

	public static void main(String[] args) {
		
		// while.
		
		// public Var.
		int sum = 0, getsu = 0, so = 0;
		
		// q1) 1~100 사이의 정수 중 3의 배수이지만, 2의 배수가 아닌 수를 출력하고, 그 합과 갯수를 출력.
		
				
		while ( true ) {
			for ( int i = 1; i <= 100; i++ ) {
				if ( i % 3 == 0 && i % 2 != 0 ) {
					System.out.println( i + ",");
					sum += i;
					getsu++;
				}	
			} break;				
		}
		System.out.println("합: " + sum);
		System.out.println("갯수: " + getsu);
		
		System.out.println("----------------");		
		
		
		// q2) -1, 3, -5, 7, -9, 11 ~ 99 까지의 합 출력.
		
		int su = 0;
		while ( su < 99 ) {
			su++;
			
		}
		System.out.println("합은: " + su);
		
		System.out.println("----------------");
		
		
		// q3) 1 ~ 1000 사이의 소수와 그 갯수를 출력.
		// 	   소수 : 1보다 크고, 자신 이외의 다른 수로는 나뉘어 떨어지지 않는 수.
		// 		자신으로 나눴을때 떨어지면 그게 소수.
		
		int num = 0;
		while ( true ) {					
			for ( so = 1; so < 1000; so++) {				
				int count = 0;				
				for ( int i = 1; i <= so; i++  ) {								
					if ( so % i == 0 ) {
						count+=1;
					}
				}
				if ( count == 2 ) {
					System.out.println("소수는 : " + so);
					num+=1;
				}
			} break;			
		} 
		System.out.println("소수의 갯수: " + num);		
		
		System.out.println("종료");

	}

}