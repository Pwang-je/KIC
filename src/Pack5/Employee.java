package Pack5;

abstract public class Employee {

  private String irum;
  private int nai;

  public Employee(String irum, int nai) {
    this.irum = irum;
    this.nai = nai;
  }

  abstract public double pay();
  abstract public void print();

  public void display() {
    System.out.println(irum + " " + nai);
  }

}
