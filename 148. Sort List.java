/*

Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 
*/

class Solution {
    public ListNode sortList(ListNode head) {
        final int length = getLength(head);
    ListNode dummy = new ListNode(0, head);
    for (int k = 1; k < length; k *= 2) {
      ListNode curr = dummy.next;
      ListNode tail = dummy;
      while (curr != null) {
        ListNode l = curr;
        ListNode r = split(l, k);
        curr = split(r, k);
        ListNode[] merged = merge(l, r);
        tail.next = merged[0];
        tail = merged[1];
      }
    }
    return dummy.next;
  }
  private int getLength(ListNode head) {
    int length = 0;
    for (ListNode curr = head; curr != null; curr = curr.next)
      ++length;
    return length;
  }
  private ListNode split(ListNode head, int k) {
    while (--k > 0 && head != null)
      head = head.next;
    ListNode rest = head == null ? null : head.next;
    if (head != null)
      head.next = null;
    return rest;
  }
  private ListNode[] merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        ListNode temp = l1;
        l1 = l2;
        l2 = temp;
      }
      tail.next = l1;
      l1 = l1.next;
      tail = tail.next;
    }
    tail.next = l1 == null ? l2 : l1;
    while (tail.next != null)
      tail = tail.next;
    return new ListNode[] {dummy.next, tail};
    }
}
