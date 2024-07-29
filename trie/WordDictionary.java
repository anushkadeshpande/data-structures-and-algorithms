class WordDictionary {
  class Node {
      Node[] links = new Node[26];
      boolean flag = false;
  }
  
  Node node;
  
  public WordDictionary() {
      node = new Node();
  }
  
  public void addWord(String word) {
      Node temp = node;
      for(int i=0; i<word.length(); i++) {
          char currentChar = word.charAt(i);
          if(temp.links[currentChar - 'a'] == null) {
              temp.links[currentChar - 'a'] = new Node();
          }
          
          temp = temp.links[currentChar - 'a'];
      }
      
      temp.flag = true;
      
  }
  
  public boolean search(String word) {
      Node temp = node;
      return dfs(temp, word, 0);
  }
  
  public boolean dfs(Node node, String word, int index) {
      
      if(index >= word.length())
          return node.flag;
      char currentChar = word.charAt(index);
      
      // System.out.println("Current char: " + currentChar);
      
      if(currentChar == '.') {
          // any char can be matched
          // we need to check all chars then
          for(int j=0; j<26; j++) {
              if(node.links[j] != null)
                  if(dfs(node.links[j], word, index + 1))
                      return true;
          }
          return false;
      }
      else {
          if(node.links[currentChar - 'a'] == null)
              return false;
          // node = node.links[currentChar - 'a'];
          return dfs(node.links[currentChar - 'a'], word, index+1);
          // return node.flag;
      }
         
  }

  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
    wd.addWord("at");
    wd.addWord("and");
    wd.addWord("an");
    wd.addWord("add");
    wd.search("a");
    wd.search(".at");
    wd.addWord("bat");
    wd.search(".at");
    wd.search("an.");
    wd.search("a.d.");
    wd.search("b.");
    wd.search("a.d");
    wd.search(".");
  }
}

/**
* Your WordDictionary object will be instantiated and called as such:
* WordDictionary obj = new WordDictionary();
* obj.addWord(word);
* boolean param_2 = obj.search(word);
*/