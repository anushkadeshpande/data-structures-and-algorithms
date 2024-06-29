public class MinimumSumPartition {
  public static int findMinDifference(int[] arr, int n, int target, int sum) {

    // return the diff
    if (n < 0)
      return Math.abs(target - sum);

    // calculate 2 scenarios, take or not take
    int take = findMinDifference(arr, n - 1, target - arr[n], sum + arr[n]);

    int not_take = findMinDifference(arr, n - 1, target, sum);

    return Math.min(take, not_take);
  }

  public static int minDifference(int arr[], int n) {
    // sum of the arr
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }
    return findMinDifference(arr, n - 1, sum, 0);
  }

  public static void main(String[] args) {
    System.out.println(minDifference(new int[]{1, 6, 11, 5}, 4));
  }
}
