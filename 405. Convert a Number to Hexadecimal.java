/*

Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.

 

Example 1:

Input: num = 26
Output: "1a"
Example 2:

Input: num = -1
Output: "ffffffff"
 

Constraints:

-231 <= num <= 231 - 1

*/

class Solution {
    public String toHex(int num) {
        if(num==0) return "0";
        String s = "";
        String hex[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        
        
        for(int i=1;i<=8;i++){
            int modified_num = num & 15;
            s = hex[modified_num]+s;
            num = num>>4; 
            if(num==0) break; 
        }
        
        return s; 
    }
}
