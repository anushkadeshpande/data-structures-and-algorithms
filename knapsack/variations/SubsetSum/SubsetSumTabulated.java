public class SubsetSumTabulated {
  
  public static int dp[][];

  public static boolean isSubsetSum(int n, int[] arr, int target) {
    
    // bottom up approach
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=target; j++) {
        if(target - j >= 0 && j >= arr[i-1]) {
          dp[i][j] = (dp[i-1][j - arr[i-1]] == 1) || (dp[i-1][j] == 1) ? 1 : 0;
        } else {
          dp[i][j] = (dp[i-1][j] == 1) ? 1 : 0;
        }
      }
    }

    return dp[n][target] == 1? true : false;
  }

  public static void main(String[] args) {
    int n = 6;
    int[] arr = new int[] { 3, 34, 4, 12, 5, 2 };
    int target = 9;
    // int target = 30;
    dp = new int[n+1][target+1];

    for(int i=0; i<=n; i++) {
      for(int j=0; j<=target; j++) {
        // when sum = 0, we'll always have a subset i.e empty array
        // 0th column will be initialized with true
        if(j == 0)
          dp[i][j] = 1;

        // when n = 0, no target can be achieved except for when sum = 0
        else if(i == 0)
          dp[i][j] = 0;

        // for all other cases, initialize with -1
        else
          dp[i][j] = -1;
      }
    }

    System.out.println(isSubsetSum(n, arr, target));
    // System.out.println(isSubsetSum(6, new int[] { 3, 34, 4, 12, 5, 2 }, 30));
  } 
}
