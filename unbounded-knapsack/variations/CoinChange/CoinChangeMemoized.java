public class CoinChangeMemoized {
  static long[][] dp;

  public static long getMinCoins(int[] coins, int n, int amount) {

    if (amount == 0)
      return 1;

    if (n <= 0)
      return 0;
    if (dp[n][amount] != -1)
      return dp[n][amount];
    if (coins[n - 1] <= amount)
      dp[n][amount] = (getMinCoins(coins, n, amount - coins[n - 1]) + getMinCoins(coins, n - 1, amount));
    else
      dp[n][amount] = getMinCoins(coins, n - 1, amount);

    return dp[n][amount];
  }

  public static long count(int coins[], int N, int sum) {
    dp = new long[N + 1][sum + 1];

    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= sum; j++)
        dp[i][j] = -1;
    }
    return getMinCoins(coins, N, sum);
  }

  public static void main(String[] args) {
    System.out.println(count(new int[] { 1, 2, 3 }, 3, 4));
  }
}
