package Pack5;

public class SawonMain {

  public static void main(String[] args) {

    //임시직 : 이름, 나이, 일수, 일당
    Temporary tem = new Temporary("박치기", 21, 20, 90000);
    tem.print();

    //정규직 : 이름, 나이, 고정급
    Regular reg = new Regular("홍길동", 23, 1234000);
    reg.print();

    //영업직 : 이름, 나이, 고정급, 실적, 수수료율
    SalesMan sal = new SalesMan("한송이", 25, 2345000, 3000, 0.25);
    sal.print();

    //관리직 : 이름, 나이, 고정급
    Manager man = new Manager("한국인", 27, 2555000);
    man.print();
    // manager 클래스의 변수명 man, 생성자 manager 호출.

  }

}
