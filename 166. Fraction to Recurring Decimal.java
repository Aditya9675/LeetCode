/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
 

Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0

*/


class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator, d = denominator;
        if (n % d == 0) {
            return n / d + "";
        }
        boolean neg = false;
        if ((n < 0 && d > 0) || (n > 0 && d < 0)) {
            neg = true;
        }
        if (n < 0) {
            n = -n;
        }
        if (d < 0) {
            d = -d;
        }
        HashMap<Long, Integer> index = new HashMap<Long, Integer>();
        String result = "";
        result += n / d + ".";
        n = n % d;
        while (n != 0) {
            if (index.containsKey(n)) {
                //recurring
                result = result.substring(0, index.get(n)) + "(" + result.substring(index.get(n)) + ")";
                break;
            }
            index.put(n, result.length());
            result += n*10/d;
            n = n*10 % d;
        }
        if (neg == true) {
            result = '-' + result;
        }
        return result;
    }
}
