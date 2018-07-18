package Pack5;

public class Regular extends Employee {

  private int salary = 0;

  public Regular(String irum, int nai, int salary) {
    super(irum, nai);
    this.salary = salary;
  }

  @Override
  public double pay() {
    return (double)salary;
  }
  @Override
  public void print() {
    super.display();
    System.out.println("급여: " + pay() );
  }

}
