public class CountDistinctSubstrings {
	public static class Node {
		Node links[];
		boolean flag;

		public Node() {
			links = new Node[26];
		}
		public boolean containsChar(char c) {
			return !(links[c - 'a'] == null);
		}


	}

	public static class Trie {
		Node node;

		int count = 0;

		public Trie() {
			node = new Node();
		}


		public void insert(String s) {
			Node temp = node;
			for(int i=0; i<s.length(); i++) {
				char currentChar = s.charAt(i);
				if(!temp.containsChar(currentChar)) {
					temp.links[currentChar - 'a'] = new Node();
					count++;
				}

				temp = temp.links[currentChar - 'a'];
			}
		}
	}

	public static int countDistinctSubstrings(String s) 
	{
		Trie trie = new Trie();

		for(int i=0; i<s.length(); i++) {
			trie.insert(s.substring(i));
		}

		return trie.count + 1;
	}

  public static void main(String[] args) {
    System.out.println(countDistinctSubstrings("abab"));
  }
}