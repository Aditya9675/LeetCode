/*
Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

 

Example 1:

Input: n = 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Example 2:

Input: n = 1
Output: 2
Example 3:

Input: n = 2
Output: 3
 

Constraints:

1 <= n <= 109

*/

class Solution {
    public int findIntegers(int n) {
    if(n< 2){
            return n + 1;
        } 
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n)).reverse();
        int k = sb.length();
        int[] f = new int[k];
        f[0] = 1;
        f[1] = 2;
        for(int i = 2; i < k; i++){
            f[i] = f[i - 1]+ f[i-2];
        }
        int rst = 0;
        for(int i=k-1; i >= 0;i--){
            if(sb.charAt(i) == '1'){
                rst += f[i];
                if(i<k - 1 && sb.charAt(i + 1) == '1'){ 
                    return rst;
                }
            }
        }
        return rst + 1;    
    }
}

