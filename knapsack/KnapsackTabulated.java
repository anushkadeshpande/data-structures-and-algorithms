public class KnapsackTabulated {

  static int[][] dp;

  public static int knapsack(int n, int w, int[] values, int[] weights) {

    dp = new int[n+1][w+1];

    // initialize the dp matix with the base case
    // if(n == 0 || w == 0)
    // return 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < w; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
      }
    }

    // bottom-up approach
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= w; j++) {
        if (j >= weights[i - 1]) {
          dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][w];
  }

  public static void main(String[] args) {
    System.out.println(knapsack(3, 4, new int[] { 1, 2, 3 }, new int[] { 4, 5, 1 }));
  }
}
