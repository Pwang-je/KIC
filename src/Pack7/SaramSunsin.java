package Pack7;

public class SaramSunsin {

  public Saram getSaram() {
//    return new Saram();
    return new Saram()    // anonymous inner class.
    {
      public String getIr() {
        return "순신";
      }
      /*
      public void aa() {
        // 오버라이딩이 안되어있어서 의미가 없음.
      }
      */
    };

  }


}
