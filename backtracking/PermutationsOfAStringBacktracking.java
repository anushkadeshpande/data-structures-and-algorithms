import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsOfAStringBacktracking {
  public static List<String> result = new ArrayList<>();
  public static Set<String> resultSet = new HashSet<>();

  public static List<String> findPermutation(String s) {

    getPermutations(s.toCharArray(), 0);

    Collections.sort(result);
    return result;
  }

  public static void getPermutations(char[] s, int start) {
    if (start == s.length - 1) {
      String combination = new String(s);
      if (!resultSet.contains(combination)) {
        result.add(combination);
        resultSet.add(combination);
      }
      return;
    }

    Set<Character> set = new HashSet<>();
    for (int i = start; i < s.length; i++) {
      if (!set.contains(s[i])) {
        // swap the start character with ith character
        swap(s, start, i);

        // get permutations for the next char
        getPermutations(s, start + 1);

        // swap start character and ith character back
        swap(s, start, i);
      }
    }
  }

  public static void swap(char[] s, int i, int j) {
    char ch = s[i];
    s[i] = s[j];
    s[j] = ch;
  }

  public static void main(String[] args) {
    findPermutation("ABC").stream().forEach(System.out::println);
    // findPermutation("ABB").stream().forEach(System.out::println);
  }
}
