public class PartitionsWithGivenDifferenceTabulated {
  public static int[][] dp;

  public static int getArrSum(int[] arr, int n, int target) {

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= target; j++) {
        if (arr[i - 1] <= j)
          dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[n][target] % (1000000007);
  }

  public static int countPartitions(int n, int d, int[] arr) {
    // s1 - s2 = d
    // s1 + s2 = s

    // hence, 2s1 = d - s
    // s1 = (d + s) / 2

    // we need to find s1
    // count of subsets with sum s1

    int sum = 0;

    for (int i = 0; i < n; i++)
      sum += arr[i];

    if ((d + sum) % 2 != 0)
      return 0;

    int target = (d + sum) / 2;

    dp = new int[n + 1][target + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= target; j++) {
        if (j == 0 && i == 0)
          dp[i][j] = 1;
        else if (i == 0)
          dp[i][j] = 0;
        else
          dp[i][j] = -1;
      }
    }

    return getArrSum(arr, n, target);
  }

  public static void main(String[] args) {
    System.out.println(countPartitions(4, 3, new int[] { 5, 2, 6, 4 }));
  }
}
