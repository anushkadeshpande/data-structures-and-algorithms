public class SwapNumbers {
  public static void main(String[] args) {
    int a = 9;
    int b = 8;

    a = a ^ b;      // ----> xor of a and b
    b = a ^ b;      // ----> again, xor of a and b == (a ^ b) ^ b and since b ^ b = 0, b = a (original a)
    a = a ^ b;      // ----> now, a ^ b == (a ^ b) ^ b and now, b = original a and a = modified a, which will give b 

    System.out.println(a);
    System.out.println(b);
  }  
}
