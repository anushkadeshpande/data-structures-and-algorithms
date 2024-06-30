public class UnboundedKnapsackRecursive {
  public static int unboundedKnapsack(int wt[], int val[], int w, int n) {
    if (w == 0 || n < 0)
      return 0;

    if (wt[n] <= w)
      return Math.max(val[n] + unboundedKnapsack(wt, val, w - wt[n], n), unboundedKnapsack(wt, val, w, n - 1));

    else
      return unboundedKnapsack(wt, val, w, n - 1);
  }

  static int knapSack(int N, int W, int val[], int wt[]) {
    return unboundedKnapsack(wt, val, W, N - 1);
  }

  public static void main(String[] args) {
    System.out.println(knapSack(2, 3, new int[] { 1, 1 }, new int[] { 2, 1 }));
    System.out.println(knapSack(1, 5, new int[] { 10 }, new int[] { 2 }));
  }
}
