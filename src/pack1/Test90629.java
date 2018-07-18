package pack1;

import java.util.Scanner;

public class Test90629 {

	public static void main(String[] args) {
		
		// Switch 2
		String jik = "과장";
		String msg = "기타";
		
		switch (jik) {
		case "사원":
			msg = "열심히";
			break;
		case "대리":			
		case "과장":
			msg = "우수해";
			break;
		default:
			System.out.println("그외 지급");
		}
		System.out.println(msg);

		
		// 키보드로부터 년과 월을 입력받아 해당년월의 날수를 출력.
		// 4 && 100 :: 400
		
		String str = "평년";
		int year, month, days = 28;
		
		Scanner input = new Scanner(System.in);
		System.out.print("년도");
		year = input.nextInt();
		System.out.print("월");
		month = input.nextInt();
//		System.out.print("날수");
//		days = input.nextInt();
		input.close();
		
		if (month < 1 || month > 12) {
			System.out.println("월은 1~12 사이만 가능합니다.");
			System.exit(0);
		}
		
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			days = 29;
			str = "윤년";
		}
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			break;
		}
		
		
		
		
		System.out.println(year+"년"+month+"월"+days+" "+str);
		
		
		
		
	}

}
