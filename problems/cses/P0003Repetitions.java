import java.util.Scanner;

public class P0003Repetitions {

  public static long findLongestRepetition(String sequence) {
    char charTracked = sequence.charAt(0);
    long length = 0;
    long longestLength = 0;
    for(int i=0; i<sequence.length(); i++) {
      if(sequence.charAt(i) == charTracked) {
        length++;
      } else {
        length = 1;
        charTracked = sequence.charAt(i);
      }
      longestLength = Math.max(longestLength, length);
    }
    return longestLength;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String dnaSequence = sc.nextLine();

    long longestRep = findLongestRepetition(dnaSequence);

    System.out.println(longestRep);
  }
}
