/*

A complex number can be represented as a string on the form "real+imaginaryi" where:

real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

 

Example 1:

Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:

Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 

Constraints:

num1 and num2 are valid complex numbers.

*/

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
    int[] A= getRealAndImag(num1);
    int[] B= getRealAndImag(num2);
    return String.valueOf(A[0] * B[0] -A[1]*B[1])+"+"+
        String.valueOf(A[0]*B[1]+A[1]*B[0])+"i";
  }

  private int[] getRealAndImag(final String s) {
    final String real =s.substring(0,s.indexOf('+'));
    final String imag =s.substring(s.indexOf('+') + 1, s.length() - 1);
    return new int[] {
        Integer.valueOf(real),Integer.valueOf(imag)};
    }
}
