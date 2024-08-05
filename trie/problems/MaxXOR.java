/* 
 * You are given two arrays of non-negative integers say ‘arr1’ and ‘arr2’. 
 * Your task is to find the maximum value of ( ‘A’ xor ‘B’ ) where ‘A’ and ‘B’ 
 * are any elements from ‘arr1’ and ‘arr2’ respectively and ‘xor’ represents the 
 * bitwise xor operation.
 */

import java.util.ArrayList;

public class MaxXOR {
  
  /* 
   * 1. Insert all numbers of arr1 into trie in terms of binary
   * 2. For every number in arr2, find the max number from the arr1 from the trie
   */


   	public static class Node {
		Node links[] = new Node[2];
	}

	public static class Trie {
		Node node;

		public Trie() {
			node = new Node();
		}

		public void insert(int num) {
			Node temp = node;

			for(int i=31; i>=0; i--) {
				int bit = (num >> i) & 1;

				if(temp.links[bit] == null) {
					temp.links[bit] = new Node();
				}

				temp = temp.links[bit];
			}
		}

		public int getMax(int num) {
			Node temp = node;
			int maxNum = 0;

			for(int i=31; i>=0; i--) {
				int bit = (num >> i) & 1;

				if(temp.links[1- bit] != null) {
					temp = temp.links[1 - bit];
					maxNum = maxNum | (1 << i);
				} else
					temp = temp.links[bit];
			}

			return maxNum;
		}
	}

	public static int maxXOR(int n, int m, int[] arr1, int[] arr2) 
	{
		Trie trie = new Trie();

		// insert all numbers from arr1
	    for(int i=0; i<arr1.length; i++) {
			trie.insert(arr1[i]);
		}

		// for each of numbers, find maxXor
		int maxXor = 0;
		for(int i=0; i<arr2.length; i++) {
			maxXor = Math.max(maxXor, trie.getMax(arr2[i]));
		}

		return maxXor;
	}

  public static void main(String[] args) {
    System.out.println(maxXOR(3, 3, new int[]{25, 10, 2}, new int[]{8, 5, 3}));
  }
}
