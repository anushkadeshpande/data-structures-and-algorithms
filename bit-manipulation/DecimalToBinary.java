public class DecimalToBinary {
  public static void main(String[] args) {
    int n = 13;
    // int n = 8;

    StringBuilder sb=new StringBuilder();  

    while(n > 0) {
      sb.append(n % 2);
      n = n/2;
    }
    sb.reverse();

    System.out.println(sb.toString());
  }
}


// Time Complexity: O(log n) (base 2)
// Space Complexity: O(log n) (base 2)