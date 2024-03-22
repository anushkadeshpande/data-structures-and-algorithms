public class CountSetBits {
  public static void main(String[] args) {
    int count = 0;

    int num = 9;

    while(num != 0) {
      count += num & 1;

      num = num >> 1;
    }

    System.out.println(count);
  }  
}
