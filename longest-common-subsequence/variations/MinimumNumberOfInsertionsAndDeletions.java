// Problem: https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

public class MinimumNumberOfInsertionsAndDeletions {
  static int dp[][];

  public static int minOperations(String str1, String str2) {
    // find longest common subsequence
    int m = str1.length();
    int n = str2.length();

    dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (str1.charAt(i - 1) == str2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    // compare it with str2 and find diff
    return m - dp[m][n] + n - dp[m][n];

  }

  public static void main(String[] args) {
    System.out.println(minOperations("heap", "pea"));
  }
}
