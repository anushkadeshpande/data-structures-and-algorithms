class Node {
  Node[] links = new Node[26];
  boolean flag = false;

  public boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  public void put(char ch) {
    this.links[ch - 'a'] = new Node();
  }

  public Node get(char ch) {
    return this.links[ch - 'a'];
  }

  public void setEnd() {
    this.flag = true;
  }

  public boolean isEnd() {
    return this.flag;
  }
}

public class Trie {
  private Node root;

  Trie() {
    root = new Node();
  }

  // TC: O(word.length())
  public void insert(String word) {
    Node temp = this.root;
    int i = 0;
    while (i < word.length()) {
      // if the current char does not exist in trie, add it and create a new node at
      // that position
      if (!temp.containsKey(word.charAt(i))) {
        // temp.links[word.charAt(i) - 'a'] = new Node();
        temp.put(word.charAt(i));
      }

      // move to the reference trie
      temp = temp.get(word.charAt(i));

      i++;
    }

    temp.setEnd();
  }

 

  public boolean startsWith(String prefix) {
    Node temp = this.root;
    int i = 0;

    while (i < prefix.length()) {
      if (!temp.containsKey(prefix.charAt(i)))
        return false;

      temp = temp.get(prefix.charAt(i));
      i++;
    }

    return true;
  }
}