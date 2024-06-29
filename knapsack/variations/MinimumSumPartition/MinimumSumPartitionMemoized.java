public class MinimumSumPartitionMemoized {
  public static int[][] dp;

  public static int findMinDifference(int[] arr, int n, int target, int sum) {

    // return the diff
    if (n < 0)
      return Math.abs(target - sum);

    if (dp[n][target] != -1)
      return dp[n][target];

    // calculate 2 scenarios, take or not take
    int take = findMinDifference(arr, n - 1, target - arr[n], sum + arr[n]);

    int not_take = findMinDifference(arr, n - 1, target, sum);

    dp[n][target] = Math.min(take, not_take);
    return dp[n][target];
  }

  public static int minDifference(int arr[], int n) {
    // sum of the arr
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    dp = new int[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        dp[i][j] = -1;
      }
    }
    
    return findMinDifference(arr, n - 1, sum, 0);
  }

  public static void main(String[] args) {
    System.out.println(minDifference(new int[] { 1, 6, 11, 5 }, 4));
  }
}
