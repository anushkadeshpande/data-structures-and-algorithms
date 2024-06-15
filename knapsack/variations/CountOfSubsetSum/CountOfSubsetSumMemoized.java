public class CountOfSubsetSumMemoized {
  static int[][] dp;

  static int countSubsetSum(int N, int arr[], int sum){
    // for every element, we either include it or exclude it
    if(sum == 0)
        return 1;
        
    if(N <= 0)
        return 0;
    
    if(dp[N][sum] != -1)
      return dp[N][sum];

    if(arr[N-1] <= sum)
        dp[N][sum] = (countSubsetSum(N-1, arr, sum-arr[N-1]) + countSubsetSum(N-1, arr, sum));
    else
        dp[N][sum] = countSubsetSum(N-1, arr, sum);

    return dp[N][sum];
  }
  
  public static void main(String[] args) {
    int n = 6;
    int[] arr = new int[]{3, 34, 4, 12, 5, 2};
    int sum = 9;

    dp = new int[n+1][sum+1];

    for(int i=0; i<=n; i++) {
      for(int j=0; j<=sum; j++)
        if(j == 0 && i == 0)
          dp[i][j] = 1;
        // else if(i == 0)
        //   dp[i][j] = 0;
        else
          dp[i][j] = -1;
    }
    System.out.println(countSubsetSum(n, arr, sum));
    // System.out.println(countSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 30));
  } 
}
