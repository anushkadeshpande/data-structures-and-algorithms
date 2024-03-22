public class ToggleIthBit {
  public static void main(String[] args) {
    int n = 9;
    int i = 2;

    System.out.println(n ^ (1 << i));
  }  
}
