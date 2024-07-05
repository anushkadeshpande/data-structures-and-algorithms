class Node2 {
  Node2[] links = new Node2[26];
  int endsWith = 0;
  int countPrefix = 0;

  public boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  public void put(char ch) {
    this.links[ch - 'a'] = new Node2();
  }

  public Node2 get(char ch) {
    return this.links[ch - 'a'];
  }

}

public class Trie2 {
  private Node2 root;

  Trie2() {
    root = new Node2();
  }

  // TC: O(word.length())
  public void insert(String word) {
    Node2 temp = this.root;
    int i = 0;
    while (i < word.length()) {
      // if the current char does not exist in trie, add it and create a new node at
      // that position
      if (!temp.containsKey(word.charAt(i))) {
        // temp.links[word.charAt(i) - 'a'] = new Node();
        temp.put(word.charAt(i));
      }
      temp.countPrefix++;
      // move to the reference trie
      temp = temp.get(word.charAt(i));

      i++;
    }

    temp.endsWith += 1;
  }

  public boolean search(String word) {
    Node2 temp = this.root;
    int i = 0;

    while (i < word.length()) {
      if (!temp.containsKey(word.charAt(i)))
        return false;

      temp = temp.get(word.charAt(i));
      i++;
    }

    return temp.endsWith > 0;
  }

  public boolean startsWith(String prefix) {
    Node2 temp = this.root;
    int i = 0;

    while (i < prefix.length()) {
      if (!temp.containsKey(prefix.charAt(i)))
        return false;

      temp = temp.get(prefix.charAt(i));
      i++;
    }

    return true;
  }

  public int getOccurrenceCount(String word) {
    Node2 temp = this.root;
    int i = 0;

    while (i < word.length()) {
      if (!temp.containsKey(word.charAt(i)))
        return 0;

      temp = temp.get(word.charAt(i));
      i++;
    }

    return temp.endsWith;
  }

  public int getPrefixCount(String prefix) {
    Node2 temp = this.root;
    int i = 0;

    while (i < prefix.length()) {
      if (!temp.containsKey(prefix.charAt(i)))
        return 0;

      temp = temp.get(prefix.charAt(i));
      i++;
    }

    return temp.countPrefix;
  }

  public static void main(String[] args) {
    Trie2 trie = new Trie2();

    trie.insert("apple");
    trie.insert("apple");
    trie.insert("apps");
    trie.insert("apps");

    System.out.println(trie.getOccurrenceCount("apple"));
    System.out.println(trie.getPrefixCount("app"));
    System.out.println(trie.getOccurrenceCount("ap"));
    System.out.println(trie.getPrefixCount("ball"));
  }
}
