public class MatrixChainMultiplication {

  public static int findMinWay(int[] arr, int i, int j) {
    if(i >= j)
      return 0;

    int minAns = Integer.MAX_VALUE;

    for(int k=i; k<j; k++) {
      int ans = findMinWay(arr, i, k) + findMinWay(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);

      minAns = Math.min(minAns, ans);
    }

    return minAns;
  }

  public static int matrixMultiplication(int[] arr, int n) {
    return findMinWay(arr, 1, n-1);
  }
  public static void main(String[] args) {
    System.out.println(matrixMultiplication(new int[] {40, 20, 30, 10, 30}, 5));
  }
}
