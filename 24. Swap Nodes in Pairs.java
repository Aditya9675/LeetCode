/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
  */
class Solution {
    public ListNode swapPairs(ListNode head) {
    if(head ==null || head.next ==null)
        return head;
    
    ListNode h= new ListNode(0);
    h.next= head;
    ListNode p= h;
        
    while(p.next != null && p.next.next != null){
        ListNode t1= p;
        p=p.next;
        t1.next= p.next;
        
        ListNode t2 =p.next.next;
        p.next.next= p;
        p.next= t2;
    }
        return h.next;
    }
}
  
