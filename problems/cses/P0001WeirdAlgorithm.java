import java.util.Scanner;

public class P0001WeirdAlgorithm {

  public static void weirdAlgorithm(long n) {
    System.out.print(n + " ");

    if (n == 1)
      return;

    if (n % 2 == 0)
      n /= 2;
    else
      n = (n * 3) + 1;

    weirdAlgorithm(n);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long n = sc.nextInt();

    sc.close();

    weirdAlgorithm(n);
  }
}
