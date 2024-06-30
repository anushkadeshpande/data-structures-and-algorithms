public class RodCuttingRecursive {
  public static int unboundedKnapsack(int[] price, int l, int n) {
    if (n == 0 || l == 0)
      return 0;

    if (n <= l)
      return Math.max(price[n - 1] + unboundedKnapsack(price, l - n, n), unboundedKnapsack(price, l, n - 1));
    else
      return unboundedKnapsack(price, l, n - 1);
  }

  public static int cutRod(int price[], int n) {
    // using unbounded knapsack

    // price arr == val arr
    // wt = idx + 1

    return unboundedKnapsack(price, n, n);

  }

  public static void main(String[] args) {
    System.out.println(cutRod(new int[] { 1, 5, 8, 9, 10, 17, 17, 20 }, 8));
  }
}
