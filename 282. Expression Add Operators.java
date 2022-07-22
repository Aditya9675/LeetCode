/*

Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.


 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1

*/

class Solution {
     int n;
    String num;
    List<String> list;
    public List<String> addOperators(String num, int target) {
         n = num.length();
        this.num = num;
        list = new ArrayList<>();
        if(n>0){
            f(0,target,1,1,num.charAt(0)-'0',"" + num.charAt(0));
        }
        return list;
    }
    
    void f(int i,long target,int c,long x,long y,String expr){
        if(i==n-1){
            if(target == c*x*y){
                list.add(expr);
            }
            return;
        }
        int p = num.charAt(i+1) - '0';
        long prd = y*x;
        f(i+1,target             ,c,prd,p,expr + "*" + num.charAt(i+1));
        f(i+1,target - prd*c,1,    1,p,expr + "+" + num.charAt(i+1));
        f(i+1,target - prd*c,-1,   1,p,expr + "-" + num.charAt(i+1));
        if(y!=0){
            f(i+1,target, c,x, 10*y + p,expr + num.charAt(i+1));
        }
    }
}
