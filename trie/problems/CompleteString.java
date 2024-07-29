public class CompleteString {
  static class Node {
    Node[] links = new Node[26];
    boolean flag = false; 
  }

  static class Trie {
    Node root;

    public Trie() {
      root = new Node();
    }

    public void add(String str) {
      Node temp = this.root;
      for(int i=0; i<str.length(); i++) {
        char currentChar = str.charAt(i);
        if(temp.links[currentChar - 'a'] == null) {
          temp.links[currentChar - 'a'] = new Node();
        }
        temp = temp.links[currentChar - 'a'];
      }

      temp.flag = true;
    }

    public boolean search(String str, int endIdx) {
      Node temp = this.root;
      for(int i=0; i<=endIdx; i++) {
        char currentChar = str.charAt(i);
        if(temp.links[currentChar - 'a'] != null) {
          temp = temp.links[currentChar - 'a'];
        }
      }

      return temp.flag;
    }
  }

  public static String completeString(int n, String[] a) {
    // construct the trie for all strings
    Trie trie = new Trie();

    for(int i=0; i<n; i++) {
      trie.add(a[i]);  
    }
    String completeStr = ""; 
    boolean flag = false;
    // for every word, check at every character if it is a complete string
    for(int i=0; i<n; i++) {
      flag = false;
      for(int j=0; j<a[i].length(); j++) {
        if(!trie.search(a[i], j))
          flag = true;
      }

      if(flag == false && a[i].length() >= completeStr.length()) {
          completeStr = a[i];
      }
        
    }

    return completeStr.length() == 0 ? "None" : completeStr;
  }
  
  public static void main(String[] args) {
    System.out.println(completeString(6, new String[]{"n", "ni", "nin", "ninj", "ninja", "ninga"}));
  }
}
