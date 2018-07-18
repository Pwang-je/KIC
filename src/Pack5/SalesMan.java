package Pack5;

public class SalesMan extends Regular {

  private int sales;
  private double commission;

  public SalesMan(String irum, int nai, int salary, int sales, double commission) {
    super(irum, nai, salary);
    this.sales = sales;
    this.commission = commission;
  }

  @Override
  public double pay() {
    return ((double)(sales*commission));
  }
  @Override
  public void print() {
    display();
    System.out.println("수령액: " + (super.pay() + pay()) );
  }

}
