public class LongestRepeatingSubsequence {
  public static int longestCommonSubsequence(String str1, String str2, int i, int j) {
      if(i == 0 || j == 0)
          return 0;
          
      if(str1.charAt(i-1) == str2.charAt(j-1) && i != j)
          return 1 + longestCommonSubsequence(str1, str2, i-1, j-1);
      else
          return Math.max(longestCommonSubsequence(str1, str2, i-1, j), longestCommonSubsequence(str1, str2, i, j-1));
          
  }
  
  public static int longestRepeatingSubsequence(String str)
  {
      int n = str.length();
      return longestCommonSubsequence(str, str, n, n);
  }

  public static void main(String[] args) {
    System.out.println(longestRepeatingSubsequence("axxzxy"));
  }
}
