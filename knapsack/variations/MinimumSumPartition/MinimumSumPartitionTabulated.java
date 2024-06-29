public class MinimumSumPartitionTabulated {

  public static int[][] dp;

  public static void subsetSum(int[] arr, int n, int sum) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] <= j)
          dp[i][j] = ((dp[i - 1][j - arr[i - 1]] == 1) || (dp[i - 1][j] == 1)) ? 1 : 0;
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
  }

  public static int minDifference(int arr[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    dp = new int[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        if (j == 0)
          dp[i][j] = 1;
        else if (i == 0)
          dp[i][j] = 0;
        else
          dp[i][j] = -1;
      }
    }

    subsetSum(arr, n, sum);

    // take only the last row
    int minSum = Integer.MAX_VALUE;
    for (int i = 0; i <= sum / 2; i++) {

      if (dp[n][i] == 1) {
        minSum = Math.min(minSum, (sum - 2 * i));
      }
    }

    return minSum;
  }

  public static void main(String[] args) {
    System.out.println(minDifference(new int[] { 1, 6, 11, 5 }, 4));
  }

}
