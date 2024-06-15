public class SubsetSumMemoized {

  public static int dp[][];

  public static boolean isSubsetSum(int n, int[] arr, int target) {
    if (target == 0)
      return true;

    if (n <= 0)
      return false;

    if(dp[n-1][target] != -1)
      return dp[n-1][target] == 1? true : false;

    if (arr[n - 1] <= target)
      dp[n-1][target] = (isSubsetSum(n - 1, arr, target - arr[n - 1]) || isSubsetSum(n - 1, arr, target)) ? 1 : 0;
    else
      dp[n-1][target] = isSubsetSum(n - 1, arr, target) ? 1 : 0;

      return dp[n-1][target]  == 1? true : false;
  }

  public static void main(String[] args) {
    int n = 6;
    int[] arr = new int[] { 3, 34, 4, 12, 5, 2 };
    // int target = 9;
    int target = 30;
    dp = new int[n+1][target+1];

    for(int i=0; i<=n; i++) {
      for(int j=0; j<=target; j++) {
        dp[i][j] = -1;
      }
    }

    System.out.println(isSubsetSum(n, arr, target));
    // System.out.println(isSubsetSum(6, new int[] { 3, 34, 4, 12, 5, 2 }, 30));
  }

}
