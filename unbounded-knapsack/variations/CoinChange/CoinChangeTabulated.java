public class CoinChangeTabulated {
  static long[][] dp;

  public static long count(int coins[], int N, int sum) {
    dp = new long[N + 1][sum + 1];

    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= sum; j++) {
        if (j == 0)
          dp[i][j] = 1;
        else if (i == 0)
          dp[i][j] = 0;
        else
          dp[i][j] = -1;
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= sum; j++) {
        if (coins[i - 1] <= j)
          dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j];

      }
    }
    return dp[N][sum];
  }

  public static void main(String[] args) {
    System.out.println(count(new int[] { 1, 2, 3 }, 3, 4));
  }
}
