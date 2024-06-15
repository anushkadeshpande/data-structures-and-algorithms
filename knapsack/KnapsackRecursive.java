public class KnapsackRecursive {

  public static int knapsack(int n, int w, int[] values, int[] weights) {
    if (n == 0 || w == 0)
      return 0;

    if (w >= weights[n - 1])
      return Math.max(values[n - 1] + knapsack(n - 1, w - weights[n - 1], values, weights),
          knapsack(n - 1, w, values, weights));
    else
      return knapsack(n - 1, w, values, weights);

  }

  public static void main(String[] args) {
    System.out.println(knapsack(3, 4, new int[] { 1, 2, 3 }, new int[] { 4, 5, 1 }));
  }
}
