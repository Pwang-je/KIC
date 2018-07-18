package Pack3;

public class Handle {

  int trn;

  public Handle() {
    trn=0;
  }

  String Left(int q) {
    trn =q;
    return "좌회전";
  }
  String Right(int q) {
    trn =q;
    return "우회전";
  }
  String Straight(int q) {
    trn =q;
    return "직진";
  }

}
