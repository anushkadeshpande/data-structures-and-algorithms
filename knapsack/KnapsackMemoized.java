public class KnapsackMemoized {

  static int[][] dp = new int[1000][1000];

  static int maxKnapsack(int W, int wt[], int val[], int n) {
      
      if(n == 0 || W == 0)
          return 0;
        
     if(dp[W][n] != -1)
          return dp[W][n];
          
          
      if(W >= wt[n-1]) {
          dp[W][n] = Math.max(val[n-1] + maxKnapsack(W-wt[n-1], wt, val, n-1), maxKnapsack(W, wt, val, n-1));
      } else {
          dp[W][n] = maxKnapsack(W, wt, val, n-1); 
      }
      
      return dp[W][n];

      
  }
  
  //Function to return max value that can be put in knapsack of capacity W.
  static int knapSack(int W, int n, int wt[], int val[]) { 
       // for every element, we either include it or we do not include it
       
      for(int i=0; i<dp.length; i++) {
          for(int j=0; j<dp[0].length; j++) {
              dp[i][j] = -1;
          }
      }
      
      return maxKnapsack(W, wt, val, n);
       
  } 
  public static void main(String[] args) {
    System.out.println(knapSack(4, 3, new int[]{4,5,1}, new int[]{1,2,3}));
  }
  
}
