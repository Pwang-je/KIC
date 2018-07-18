package Pack5;

public class Manager extends Regular {

  private double incentive = 0;

  public Manager(String irum, int nai, int salary) {
    super(irum, nai, salary);
  }

  @Override
  public double pay() {

    double f = 0.0;
    if ( super.pay() >= 2500000 ) {
      f = 0.6;
    } else if ( super.pay() < 2000000 ) {
      f = 0.5;
    } else {
      f = 0.4;
    }
    this.incentive = super.pay()*f;
    return incentive;

  }
  @Override
  public void print() {
    super.display();
    System.out.println("수령액: " + super.pay()+pay());
  }

  }




