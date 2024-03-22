public class CheckIfNumPowerOfTwo {
  public static void main(String[] args) {
    // if a number is power of 2, it'll have one bit as 1
    // eg 4 -> 100
    // 8-> 1000

    // int n = 8;
    int n = 7;

    if((n & (n - 1)) == 0) {
      System.out.println("Power of two");
    } else {
      System.out.println("Not power of two");
    }
  }
}