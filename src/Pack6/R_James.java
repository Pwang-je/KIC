package Pack6;

public class R_James implements Resume {

  private String name, phone, address, skill;

  @Override
  public void setName(String name) {
    if (name.equals(null)) {
      this.name = "무명";
    } else {
      this.name = name;
    }
  }

  @Override
  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void print() {
    System.out.println("이력서 규격은 " + Resume.SIZE + " \n이름은 " + name +
        " \n전화번호는 " + phone + " \n주소: " + address + "\n보유기술: " + skill);
    playJava(true);
  }




}
