package Pack6;

public class R_Tom implements Resume {

  private String name, phone, address;

  public R_Tom() {
    // const
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setAddress(String address) {
    this.address = address;
  } // tom only.

  @Override
  public void print() {
//    Resume.SIZE = "B5";    // err : final 이라서.
    System.out.println("용지 규격은 " + Resume.SIZE + " \n이름은 " + name +
        " \n전화번호는 " + phone + " \n주소: " + address);
    playJava(true);
    Resume.changeData();  // 스테틱 처리도 부를 수 있음.
  }




}
