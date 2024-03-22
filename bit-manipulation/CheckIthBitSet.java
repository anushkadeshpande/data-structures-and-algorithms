public class CheckIthBitSet {
  public static void main(String[] args) {
    // Using left shift operator

    int num = 4;
    int i = 2;

    if((num & (1 << i)) != 0) {
      System.out.println("Bit is set");
    } else {
      System.out.println("Bit is not set");
    }
  }  
}
