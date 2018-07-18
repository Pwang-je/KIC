package pack1;

public class Test7if {

	public static void main(String[] args) {
		// 조건 판단문 IF.
		int num = 5;
		
		if (num >= 3) { 
			System.out.println("크군용");
			System.out.println("배고파 - 조건이 참일 때 수행");
			}
		
			num = 1;
			if (num < 3) {
				System.out.println("참일때.");
			} else {
				System.out.println("실패일때.");
			}
			System.out.println("다음작업 계속 2");
			
			
			int jumsu = 40;
			if ( jumsu >= 70 ) {
				if ( jumsu >= 90 ) {
					System.out.println("우수");
				} else {
					System.out.println("보통");
				}
			} else {
				if ( jumsu >= 50 ) {
					System.out.println("저조");
				} else {
					System.out.println("나가리");
				}
			}
			System.out.println();
			
			
			int score = 75;
			String re = "";
			if ( score >= 90 ) {
				re = "수";
			} else if ( score >= 80 ) {
				re = "우";
			} else if ( score >= 70 ) {
				re = "미";
			} else if ( score >= 60 ) {
				re = "양";
			} else {
				re = "가";
			}
			System.out.println("점수 결과 : " + re);
			
			
			
			
			
			
			
			System.out.println("작업 종료");
		

	}

}
