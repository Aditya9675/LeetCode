/*

Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

*/

class Solution {
    public String addBinary(String a, String b) {
    int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int sum = 0;

        while(i >= 0 || j >= 0){

            sum /= 2;
            if(i >= 0) sum += a.charAt(i) - '0';
            if(j >= 0) sum += b.charAt(j) - '0';

            sb.append(sum % 2);
            i--;
            j--;

        }

        if(sum / 2 != 0) sb.append(1);
        return sb.reverse().toString();    
    }
}
