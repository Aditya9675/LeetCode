/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
    t.next = head;
 
    ListNode p = t;
    while(p.next!=null&&p.next.next!=null){
        if(p.next.val == p.next.next.val){
            int dup = p.next.val;
            while(p.next!=null&&p.next.val==dup){
                p.next = p.next.next;
            }
        }else{
            p=p.next;
        }
 
    }
 
    return t.next;
    }
}
