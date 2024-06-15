public class CountOfSubsetSumTabulated {
  static int[][] dp;

  static int countSubsetSum(int N, int arr[], int sum){
    // for every element, we either include it or exclude it
    for(int i=1; i<=N; i++) {
      for(int j=0; j<=sum; j++) {
        if(arr[i-1] <= j)
          dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
        else
          dp[i][j] = dp[i-1][j];
      }
    }
 
    return dp[N][sum];
  }
  
  public static void main(String[] args) {
    int n = 6;
    int[] arr = new int[]{3, 34, 4, 12, 5, 2};
    int sum = 9;

    dp = new int[n+1][sum+1];

    for(int i=0; i<=n; i++) {
      for(int j=0; j<=sum; j++)
        if(i == 0) {
          if(j == 0)
            dp[i][j] = 1;
          else
            dp[i][j] = 0;
        }
        else
          dp[i][j] = -1;
    }
    System.out.println(countSubsetSum(n, arr, sum));
    // System.out.println(countSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 30));
  } 
}
