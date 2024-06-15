public class EqualSumPartitionMemoized {

  static int[][] dp;

  public static boolean canPartitionArray(int[] arr, int n, int target) {
    if (target == 0)
      return true;

    if (n <= 0)
      return false;

    if (dp[n][target] != -1)
      return dp[n][target] == 1;

    if (target >= arr[n - 1])
      dp[n][target] = (canPartitionArray(arr, n - 1, target - arr[n - 1]) || canPartitionArray(arr, n - 1, target)) ? 1
          : 0;
    else
      dp[n][target] = canPartitionArray(arr, n - 1, target) ? 1 : 0;

    return dp[n][target] == 1;
  }

  public static boolean canPartition(int[] arr, int n) {
    // find array sum
    // half of the sum of all elements of the array will be the target
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }
    if (sum % 2 != 0)
      return false;

    dp = new int[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= sum / 2; j++) {
        dp[i][j] = -1;
      }
    }
    return canPartitionArray(arr, n, sum / 2);
  }

  public static void main(String[] args) {
    int n = 4;
    int[] arr = new int[] { 1, 5, 11, 5 };

    System.out.println(canPartition(arr, n));
  }
}
