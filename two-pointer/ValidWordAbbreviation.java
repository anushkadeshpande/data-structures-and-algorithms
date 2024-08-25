/* 
 * 
 * A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.
 * For example, a string such as "substitution" could be abbreviated as (but not limited to):
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (no substrings replaced)
 * 
 * The following are not valid abbreviations:
 * "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
 * "s010n" (has leading zeros)
 * "s0ubstitution" (replaces an empty substring)
 * Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
 * 
 * A substring is a contiguous non-empty sequence of characters within a string.

 */

 public class ValidWordAbbreviation {
  
  public static boolean doesStringMatchAbbreviation(String originalString, String abbreviation) {

    // if current char is an alphabet in the abbreviation, match it
    // if it is a number, extract all numbers, check if it has leading zeroes
    // else, convert it to number, and move the pointer that many times
    
    int i = 0;
    int j = 0;
    int n = originalString.length();

    while(i < n) {
      char currentAbbrChar = abbreviation.charAt(j);
      char currentOriginalChar = originalString.charAt(i);

      // the current char in the abbreviation is a char
      if((currentAbbrChar >= 'a' && currentAbbrChar <= 'z') || (currentAbbrChar >= 'A' && currentAbbrChar <= 'Z')) {
        if(currentAbbrChar != currentOriginalChar)
          return false;

        i++;
        j++;
      }

      // if current char in abbreviation is a number
      else if(currentAbbrChar >= '1' && currentAbbrChar <= '9') {
        // we have a valid number
        // fetch the entire number
        int len = 0;
        while(j < abbreviation.length() && abbreviation.charAt(j) >= '0' && abbreviation.charAt(j) <= '9') {
          currentAbbrChar = abbreviation.charAt(j);
          len = len * 10 + currentAbbrChar - '0';
          j++;
        }

        while(len > 0 && i <n) {
          i++;
          len--;
        }

        if(len != 0)
          return false;
      }

      // the string is invalid
      else
        return false;
    }
    
    return true;
  }

  public static void main(String[] args) {
    System.out.println(doesStringMatchAbbreviation("substitution", "s10n"));

    System.out.println(doesStringMatchAbbreviation("substitution", "sub4u4"));
    
    System.out.println(doesStringMatchAbbreviation("substitution", "12"));

    System.out.println(doesStringMatchAbbreviation("substitution", "su3i1u2on"));

    System.out.println(doesStringMatchAbbreviation("substitution", "substitution"));

    System.out.println(doesStringMatchAbbreviation("substitution", "s55n"));
    
    System.out.println(doesStringMatchAbbreviation("substitution", "s010n"));

    System.out.println(doesStringMatchAbbreviation("substitution", "s0ubstitution"));
    
    System.out.println(doesStringMatchAbbreviation("internationalization", "i12iz4n"));

    System.out.println(doesStringMatchAbbreviation("apple", "a2e"));

  }
}
