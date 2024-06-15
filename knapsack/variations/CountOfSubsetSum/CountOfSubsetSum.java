public class CountOfSubsetSum {
  static int countSubsetSum(int N, int arr[], int sum){
    // for every element, we either include it or exclude it
    if(sum == 0)
        return 1;
        
    if(N <= 0)
        return 0;
        
    if(arr[N-1] <= sum)
        return (countSubsetSum(N-1, arr, sum-arr[N-1]) + countSubsetSum(N-1, arr, sum));
    else
        return countSubsetSum(N-1, arr, sum);
  }
  
  public static void main(String[] args) {
    System.out.println(countSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 9));
    // System.out.println(countSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 30));
  }  
}
