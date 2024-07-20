public class PalindromeLinkedList {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static boolean isPalindrome(ListNode head) {
    // go to the middle of the linked list
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    ListNode temp = null;

    while (fast != null && fast.next != null) {
      // prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    // reverse the 2nd half of the list
    // i.e the one that starts from slow
    // bring fast to the beginning
    prev = slow;
    slow = slow.next;
    prev.next = null;

    while (slow != null) {
      temp = slow.next;
      slow.next = prev;
      prev = slow;

      slow = temp;
    }

    fast = head;
    slow = prev;

    while (slow != null) {
      if (fast.val != slow.val)
        return false;
      fast = fast.next;
      slow = slow.next;
    }

    return true;
  }

  public static void main(String[] args) {
    ListNode l8 = new ListNode(1, null);
    ListNode l7 = new ListNode(2, l8);
    ListNode l6 = new ListNode(3, l7);
    ListNode l5 = new ListNode(4, l6);
    ListNode l4 = new ListNode(4, l5);
    ListNode l3 = new ListNode(3, l4);
    ListNode l2 = new ListNode(2, l3);
    ListNode l1 = new ListNode(1, l2);

    System.out.println(isPalindrome(l1));
  }
}
