package pack1;

public class Test8switch {

	public static void main(String[] args) {
				
		// Switch 조건 판단문.
		
		int age = 35;
		age = age/10*10;
//		System.out.println(age);
		
//		if (age==20) {
//			System.out.println("젊구나.");
//		} else if (age==30) {
//			System.out.println("아죠씨");
//		}
		
		switch(age) {
		case 20:
			System.out.println("젊구나");
			System.out.println("20대");
			break;
		case 30:
			System.out.println("아죠씨");
			System.out.println("30대");
			break;
		case 40:
			System.out.println("준비하셔야죠");
			break;
		case 50:
			System.out.println("...");
			break;
		default:
			System.out.println("기타");
		}
		
		
		System.out.println("다음");
//		double time = Math.random();
		int time = (int)((Math.random()*4)+8);
		System.out.println(time);
		
		switch (time) {
		case 8:
			System.out.println("출근~");
			break;
		case 9:
			System.out.println("한강가자~");
			break;
		default:
			System.out.println("RIP");
			break;
		}
		
		
		
		
		
		

	}

}
