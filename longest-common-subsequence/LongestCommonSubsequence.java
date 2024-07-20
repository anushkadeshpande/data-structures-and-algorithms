public class LongestCommonSubsequence {

  public static int longestCommonSubsequence(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();

    int[][] dp = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        }
        else
          dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i-1][j] : dp[i][j-1];
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    // System.out.println(longestCommonSubsequence("abcde", "ace"));
    // System.out.println(longestCommonSubsequence("abaaa", "baabaca"));
    // System.out.println(longestCommonSubsequence("aaa", "a"));
    System.out.println(longestCommonSubsequence("abcdaf", "acbcf"));
  }
}
