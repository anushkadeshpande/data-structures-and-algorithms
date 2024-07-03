public class CoinChangeRecursive {

  public static long count(int coins[], int N, int sum) {
      if (sum == 0)
        return 1;

      if (N <= 0)
        return 0;

      if (coins[N - 1] <= sum)
        return (count(coins, N, sum - coins[N - 1]) + count(coins, N - 1, sum));
      else
        return count(coins, N - 1, sum);
  }

  public static void main(String[] args) {
    System.out.println(count(new int[] { 1, 2, 3 }, 3, 4));
  }
}
