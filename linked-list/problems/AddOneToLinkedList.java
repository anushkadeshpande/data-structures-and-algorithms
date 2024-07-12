public class AddOneToLinkedList {
  public static class Node {
    int data;
    Node next;

    Node(int x) {
      data = x;
      next = null;
    }
  }

  public static int helper(Node node, int carry) {
    if (node.next != null)
      carry = helper(node.next, carry);
    node.data += carry;

    if (node.data == 10) {
      node.data = 0;
      return 1;
    } else {
      return 0;
    }

  }

  public static Node addOne(Node head) {
    // reverse the linked list
    // add one to head
    // reverse it again

    // Approach-2: recursion
    int carry = helper(head, 1);
    if (carry == 1) {
      // add a new node
      Node newHead = new Node(1);
      newHead.next = head;

      return newHead;
    }
    return head;
  }

  public static void main(String[] args) {
    Node node = new Node(9);
    Node secondNode = new Node(9);
    node.next = secondNode;
    Node thirdNode = new Node(9);
    secondNode.next = thirdNode;

    Node temp = addOne(node);
    String sol = "";
    while (temp != null) {
      sol += temp.data;
      temp = temp.next;
    }

    System.out.println(sol);
  }
}
