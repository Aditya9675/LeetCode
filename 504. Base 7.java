/*

Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"
 

Constraints:

-107 <= num <= 107

*/
class Solution {
    public String convertToBase7(int num) {
        if(num == 0){ 
            return "0";
        }
        String res = "";
        boolean isNegative = num < 0;
        long abs = Math.abs(num);
        while(abs > 0){
            long rem = abs % 7;
            res = rem + res;
            abs /= 7;
        }
        if(isNegative){
            res = "-" + res;
        }
        return res;
    }
}

