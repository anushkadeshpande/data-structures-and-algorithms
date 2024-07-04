public class LongestCommonSubstringRecursive {

  public static int getLongestCommonSubstring(String s1, String s2, int n, int m, int maxLength) {
    if (n == 0 || m == 0)
      return maxLength;

    if (s1.charAt(n - 1) == s2.charAt(m - 1))
      return getLongestCommonSubstring(s1, s2, n - 1, m - 1, ++maxLength);

    return Math.max(maxLength,
        Math.max(getLongestCommonSubstring(s1, s2, n, m - 1, 0), getLongestCommonSubstring(s1, s2, n - 1, m, 0)));
  }

  public static int longestCommonSubstr(String S1, String S2, int n, int m) {
    return getLongestCommonSubstring(S1, S2, n, m, 0);
  }

  public static void main(String[] args) {
    System.out.println(longestCommonSubstr("ABCDGH", "ACDGHR", 6, 6));
  }
}
