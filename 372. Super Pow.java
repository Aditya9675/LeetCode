/*

Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 

Example 1:

Input: a = 2, b = [3]
Output: 8
Example 2:

Input: a = 2, b = [1,0]
Output: 1024
Example 3:

Input: a = 1, b = [4,3,3,8,5,2]
Output: 1
 

Constraints:

1 <= a <= 231 - 1
1 <= b.length <= 2000
0 <= b[i] <= 9
b does not contain leading zeros.

*/

class Solution {
    public int superPow(int a, int[] b) {
        if(b==null || b.length==0) return 0;
        
        int len = b.length;

        int[] remainders = new int[len];
        int first = a % 1337;
        for(int i=len-1; i>=0; i--) {
            int[] nums = new int[11];
            nums[0] = 1;
            for(int j=1; j<11; j++) {
                nums[j] = (nums[j-1]*first) % 1337;
            }
            
            remainders[i] = nums[b[i]];
            first = nums[10];
        }
        int remainder = 1;
        for(int i=0; i<len; i++) {
            remainder = (remainder*remainders[i]) % 1337;
        }
        
        return remainder;
    }
}
