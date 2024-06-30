public class UnboundedKnapsackTabulated {
  static int[][] dp;

  static int unboundedKnapsack(int[] wt, int[] val, int w, int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= w; j++) {
        if (j >= wt[i - 1])
          dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
        else
          dp[i][j] = dp[i - 1][j];

      }
    }

    return dp[n][w];
  }

  static int knapSack(int N, int W, int val[], int wt[]) {
    dp = new int[N + 1][W + 1];

    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= W; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else
          dp[i][j] = -1;
      }
    }
    return unboundedKnapsack(wt, val, W, N);
  }

  public static void main(String[] args) {
    System.out.println(knapSack(2, 3, new int[] { 1, 1 }, new int[] { 2, 1 }));
    System.out.println(knapSack(1, 5, new int[] { 10 }, new int[] { 2 }));
  }
}
