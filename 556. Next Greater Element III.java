/*

Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1
 

Constraints:

1 <= n <= 231 - 1

*/

class Solution {
    public int nextGreaterElement(int n) {
        String number = Integer.toString(n);
        char[] num = number.toCharArray();
        int len = num.length;
        int i = len-1;
        while(i>0){
            if(num[i] > num[i-1]) 
            break;
            i--;
        }
        if(i==0) 
        return -1;
        int j = i-1;
        i = len-1;
        while(i>j){
            if(num[j] < num[i]){
                char temp = num[j];
                num[j] = num[i];
                num[i] = temp;
                break;
            }
            i--;
        }
        StringBuilder ans_str = new StringBuilder();
        for(i=0;i<=j;i++) ans_str.append(num[i]);
        for(i=len-1;i>j;i--) ans_str.append(num[i]);
        
        long ans = Long.parseLong(ans_str.toString());
        
        if(ans > Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
}
