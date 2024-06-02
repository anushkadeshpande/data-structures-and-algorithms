import java.util.Scanner;

public class P0002_MissingNumber {

  public static long missingNumber(long n, long[] nums) {
    // find sum of numbers from 1 - n
    long targetSum = n * (n + 1) / 2;

    // find sum of nums
    long sum = 0;
    for (long i = 0; i < n - 1; i++)
      sum += nums[(int)i];

    return targetSum - sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long n = sc.nextLong();

    long[] nums = new long[(int)n - 1];
    for (long i = 0; i < n - 1; i++) {
      nums[(int)i] = sc.nextInt();
    }

    sc.close();

    long answer = missingNumber(n, nums);

    System.out.println(answer);
  }
}
