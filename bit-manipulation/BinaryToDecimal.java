public class BinaryToDecimal {
  public static void main(String[] args) {
    // String bin = "1101";
    String bin = "1000";

    int result = 0;
    for(int i = bin.length() - 1 ; i >= 0; i--) {
        result += Character.getNumericValue(bin.charAt(i)) * Math.pow(2, bin.length() - 1 - i);
    }

    System.out.println(result);
  }  
}
