public class SubsetSum {

  static Boolean isSubsetSum(int N, int arr[], int sum){
    // for every element, we either include it or exclude it
    if(sum == 0)
        return true;
        
    if(arr.length == 0 || N <= 0)
        return false;
        
    
    if(arr[N-1] <= sum)
        return (isSubsetSum(N-1, arr, sum-arr[N-1]) || isSubsetSum(N-1, arr, sum));
    else
        return isSubsetSum(N-1, arr, sum);
  }
  
  public static void main(String[] args) {
    System.out.println(isSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 9));
    System.out.println(isSubsetSum(6, new int[]{3, 34, 4, 12, 5, 2}, 30));
  }
}
