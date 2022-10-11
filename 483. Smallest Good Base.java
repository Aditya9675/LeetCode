/*

Given an integer n represented as a string, return the smallest good base of n.

We call k >= 2 a good base of n, if all digits of n base k are 1's.

Example 1:

Input: n = "13"
Output: "3"
Explanation: 13 base 3 is 111.
Example 2:

Input: n = "4681"
Output: "8"
Explanation: 4681 base 8 is 11111.
Example 3:

Input: n = "1000000000000000000"
Output: "999999999999999999"
Explanation: 1000000000000000000 base 999999999999999999 is 11.
 

Constraints:

n is an integer in the range [3, 1018].
n does not contain any leading zeros.

*/

class Solution{
    public String smallestGoodBase(String n){
      long num = Long.valueOf(n);
      for (int m = (int)(Math.log(num + 1) / Math.log(2)); m > 2; m--){
            long l = (long)(Math.pow(num + 1, 1.0 / m));
            long r = (long)(Math.pow(num, 1.0 / (m - 1)));

            while(l <= r){
                long k = l + ((r - l) >> 1);
                long f = 0L;
                for (int i = 0; i < m; i++, f = f * k + 1);

                if(num == f){
                    return String.valueOf(k);
                }else if (num < f){
                    r = k - 1;
                }else{
                    l = k + 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}

