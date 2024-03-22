public class CountSetBits {
  public static void main(String[] args) {
    int count = 0;

    int num = 9;

    while(num != 0) {
      count += num & 1;

      num = num >> 1;
    }

    System.out.println(count);


    // Another approach: keep taking & of number with number - 1 while number does not become 0

    // TC: O(numOfOnes)
  }  
}
