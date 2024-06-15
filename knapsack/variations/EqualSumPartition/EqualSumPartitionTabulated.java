public class EqualSumPartitionTabulated {
  static int[][] dp;

  public static boolean canPartitionArray(int[] arr, int n, int target) {

    for(int i=1; i<=n; i++) {
      for(int j=1; j<=target; j++) {
        if (j >= arr[i - 1])
          dp[i][j] = (dp[i - 1][j - arr[i - 1]] == 1 || dp[i - 1][j] == 1) ? 1: 0;
        else
          dp[i][j] = dp[i-1][j] == 1 ? 1 : 0;
      }
    }


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
        if(j == 0)
          dp[i][j] = 1;
        else if(i == 0)
          dp[i][j] = 0;
        else
          dp[i][j] = -1;
      }
    }
    return canPartitionArray(arr, n, sum / 2);
  }

  public static void main(String[] args) {
    int n = 4;
    int[] arr = new int[] { 1, 5, 13, 5 };

    System.out.println(canPartition(arr, n));
  }
}
