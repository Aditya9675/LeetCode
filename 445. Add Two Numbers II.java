/*

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?

*/

class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode next_node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_node;
        }
        
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        
        ListNode curr = dummy;
        
        while(l1 != null || l2 != null){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            
            curr.next = new ListNode((a + b + carry)%10);
            
            carry = (a + b + carry)/10;
            
            curr = curr.next;
            
            if(l1 != null){
                l1 = l1.next;
            }
            
            if(l2 != null){
                l2 = l2.next;
            }
        }
        
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        
        return reverse(dummy.next);
    }
}
