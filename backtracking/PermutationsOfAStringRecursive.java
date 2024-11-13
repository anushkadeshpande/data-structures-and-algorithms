import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsOfAStringRecursive {

  public static List<String> result = new ArrayList<>();

  public static List<String> findPermutation(String s) {

    getPermutations(s, "");

    Collections.sort(result);
    return result;
  }

  public static void getPermutations(String ip, String op) {
    // for every character in the string, keeping it as the 1st character find all possible permutations recursively
    // also, to avoid duplicate computations, for example if at the same level of the recursive tree, we have duplicate characters, the permutations for both of them would be same, hence no need to compute it again
    // for that a set is maintained, and the characters which are processed are put into that set, and if it is already present, we move on to the next char 

    if (ip.length() == 0) {
      result.add(op);
      return;
    }

    Set<Character> set = new HashSet<>();
    for (int i = 0; i < ip.length(); i++) {
      if (!set.contains(ip.charAt(i))) {
        set.add(ip.charAt(i));
        String newIp = ip.substring(0, i) + ip.substring(i + 1);
        String newOp = op + ip.charAt(i);
        getPermutations(newIp, newOp);
      }
    }
  }

  public static void main(String[] args) {
    findPermutation("ABC").stream().forEach(System.out::println);
  }
}
