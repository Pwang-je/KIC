package Pack2;

public class Production {

  public String name;
  private int price = 0;
  private int size = 0;

  public Production() {
    // constructor
    size = 2;
  }

  // constructor overloading.
  public Production(String name, int size, int price) {
    System.out.println("상품명: " + name + ", 가격: " + price + ", 갯수: "
        + size + "개 입니다.");
  }
  public Production(int price) {
    this.price = price;
  }

  public void setSize(int size) { // setter
    this.size = size;
  }
  public int getSize() {  // getter
    return size;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getPrice() {
    return price;
  }

  public void display() {
    System.out.println("상품명: " + name + ", 가격: " + price + ", 갯수: "
        + size + "개 입니다.");
  }
  public void display(String name) {
    System.out.println("상품명: " + name + ", 가격: " + price + ", 갯수: "
        + size + "개 입니다.");
  }
  public void display(int price) {
    System.out.println("상품명: " + name + ", 가격: " + price + ", 갯수: "
        + size + "개 입니다.");
  }
  public void display(String name, int size) {
    System.out.println("상품명: " + name + ", 가격: " + price + ", 갯수: "
        + size + "개 입니다.");
  }
  public void display(String name, int size, int price) {
    System.out.println("상품명: " + name + ", 가격: " + price + ", 갯수: "
        + size + "개 입니다.");
  }

  public void myNormal() {
    System.out.println("상품명 : " + name );
    System.out.println("가격 : " + price);
    System.out.println("갯수 : " + size);
  }


}
