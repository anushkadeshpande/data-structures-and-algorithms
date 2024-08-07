public class LongestCommonSubstringTabulated {

  static int[][] dp;

  public static int longestCommonSubstr(String S1, String S2, int n, int m) {
    dp = new int[n + 1][m + 1];
    int maxLength = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          maxLength = Math.max(maxLength, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(longestCommonSubstr("ABCDGH", "ACDGHR", 6, 6));
  }
}
