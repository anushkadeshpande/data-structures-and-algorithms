public class PrintLCS {
  static int[][] dp;

  private static String longestCommonSubsequence(String string1, String string2) {
    int n = string1.length();
    int m = string2.length();

    dp = new int[n + 1][m + 1];


    // STEP 1: Compute the length of lcs....this will prepare the computation matrix
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (string1.charAt(i - 1) == string2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    // STEP 2: Go back from the last cell, which contains the length of longest common subsequence
    String lcs = "";
    int i = n;
    int j = m;
    while(i != 0 && j != 0) {
      if(string1.charAt(i-1) == string2.charAt(j-1)) {
        lcs = string1.charAt(i-1) + lcs;
        i --;
        j --;
      } else if(dp[i-1][j] > dp[i][j-1]) {
        i--;
      } else 
        j--;

    }

    return lcs;
  }

  public static void main(String[] args) {
    // System.out.println(longestCommonSubsequence("abcde", "ace"));
    // System.out.println(longestCommonSubsequence("abaaa", "baabaca"));
    // System.out.println(longestCommonSubsequence("aaa", "a"));
    System.out.println(longestCommonSubsequence("abcdaf", "acbcf"));
  }

}
