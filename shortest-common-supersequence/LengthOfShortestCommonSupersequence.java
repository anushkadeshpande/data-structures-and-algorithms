public class LengthOfShortestCommonSupersequence {
  static int dp[][];

  public static int getLengthOfShortestCommonSupersequence(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();

    // 1. Find LCS of the 2 strings
    // 2. length_of_scs = m + n - length_of_lcs
    
    dp = new int[m+1][n+1];
        
    for(int i=0; i<=m; i++) {
        for(int j=0; j<=n; j++) {
            if(i == 0 || j == 0)
                dp[i][j] = 0;
            else if(str1.charAt(i-1) == str2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
    
    return m + n - dp[m][n];
  }
  
  public static void main(String[] args) {
    System.out.println(getLengthOfShortestCommonSupersequence("efgh", "jghi"));
  }
}
