/*

Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
        return true;
 
    ListNode p = head;
    ListNode prev = new ListNode(head.val);
 
    while(p.next != null){
        ListNode temp = new ListNode(p.next.val);
        temp.next = prev;
        prev = temp;
        p = p.next;
    }
 
    ListNode p1 = head;
    ListNode p2 = prev;
 
    while(p1!=null){
        if(p1.val != p2.val)
            return false;
 
        p1 = p1.next;
        p2 = p2.next;
    }
 
    return true;
    }
}
