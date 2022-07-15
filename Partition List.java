/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200 .
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
 
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;
 
        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;
 
        while(p != null){
            if(p.val < x){
                p = p.next;
                prev = prev.next;
            }else{
 
                p2.next = p;
                prev.next = p.next;
 
                p = prev.next;
                p2 = p2.next;
            } 
        }

        p2.next = null;
 
        prev.next = fakeHead2.next;
 
        return fakeHead1.next;
    }
}
