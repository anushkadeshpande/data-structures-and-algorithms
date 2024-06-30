public class UnboundedKnapsackMemoized {

  static int[][] dp;

  static int unboundedKnapsack(int[] wt, int[] val, int w, int n) {
    if (w == 0 || n < 0)
      return 0;

    if (dp[n][w] != -1)
      return dp[n][w];

    if (w >= wt[n])
      dp[n][w] = Math.max(val[n] + unboundedKnapsack(wt, val, w - wt[n], n), unboundedKnapsack(wt, val, w, n - 1));
    else
      dp[n][w] = unboundedKnapsack(wt, val, w, n - 1);

    return dp[n][w];
  }

  static int knapSack(int N, int W, int val[], int wt[]) {
    dp = new int[N + 1][W + 1];

    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= W; j++)
        dp[i][j] = -1;
    }
    return unboundedKnapsack(wt, val, W, N - 1);
  }

  public static void main(String[] args) {
    System.out.println(knapSack(2, 3, new int[] { 1, 1 }, new int[] { 2, 1 }));
    System.out.println(knapSack(1, 5, new int[] { 10 }, new int[] { 2 }));
  }

}
