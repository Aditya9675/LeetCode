/*

Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.

*/

class Solution {
    public int calculate(String s) {
    int md=-1; 
    int sign=1; 
    int prev=0;
    int result=0;
 
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(Character.isDigit(c)){
            int num = c-'0';
            while(++i<s.length() && Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            i--;
 
            if(md==0){
                prev = prev * num;
                md=-1;
            }else if(md==1){
                prev = prev / num;
                md=-1;
            }else{
                prev = num;
            }
        }else if(c=='/'){
            md=1;
        }else if(c=='*'){
            md=0;
        }else if(c=='+'){
            result = result + sign*prev;
            sign=1;
        }else if(c=='-'){
            result = result + sign*prev;
            sign=-1;
        }
    }
 
    result = result + sign*prev;
    return result;
    }
}
