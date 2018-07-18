package Pack5;

public class Temporary extends Employee {

  private int ilsu = 0;
  private int ildang = 0;

  public Temporary(String irum, int nai, int ilsu, int ildang) {
    super(irum, nai);
    this.ilsu = ilsu;
    this.ildang = ildang;
  }

  @Override
  public double pay() {
    return (double)ilsu*ildang;
  }
  @Override
  public void print() {
    super.display();
    System.out.println( "월급: " + pay() );
  }
  @Override
  public void display() {

  }

}
