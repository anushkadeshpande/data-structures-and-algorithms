import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceCombinations {

  public static long getDiceCombinations(int n) {
    long[] dp = new long[n+1];
    dp[0] = 1;
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=6; j++) {
        if(j <= i)
          dp[i] = (dp[i] + dp[i-j]) % 1000000007;
      }
    }
    return dp[n];
  }
  public static void main(String[] args) {
    // long start = System.currentTimeMillis();
    Scanner sc = new Scanner(System.in);
    System.out.println(getDiceCombinations(sc.nextInt()));
    sc.close();
    // System.out.println(getDiceCombinations(100));
    // long end = System.currentTimeMillis();

    // System.out.println(getDiceCombinations(4));
    // System.out.println(end-start);
  }
}
