/*

Given a string s represents the serialization of a nested list, implement a parser to deserialize it and return the deserialized NestedInteger.

Each element is either an integer or a list whose elements may also be integers or other lists.

 

Example 1:

Input: s = "324"
Output: 324
Explanation: You should return a NestedInteger object which contains a single integer 324.
Example 2:

Input: s = "[123,[456,[789]]]"
Output: [123,[456,[789]]]
Explanation: Return a NestedInteger object containing a nested list with 2 elements:
1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789
 

Constraints:

1 <= s.length <= 5 * 104
s consists of digits, square brackets "[]", negative sign '-', and commas ','.
s is the serialization of valid NestedInteger.
All the values in the input are in the range [-106, 106].

*/

class Solution {
    public NestedInteger deserialize(String s) {
      
    Stack<NestedInteger> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
 
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        switch(c){
            case '[':
                NestedInteger ni = new NestedInteger();
                stack.push(ni);
                break;
 
            case ']':
                if(sb.length()>0){ 
                    stack.peek().add(new NestedInteger(Integer.parseInt(sb.toString())));
                    sb=sb.delete(0, sb.length());
                }
 
                NestedInteger top = stack.pop();
                if(stack.isEmpty()){
                    return top;
                }else{
                    stack.peek().add(top);
                }
 
                break;
            case ',':
                if(sb.length()>0){ 
                    stack.peek().add(new NestedInteger(Integer.parseInt(sb.toString())));
                    sb=sb.delete(0, sb.length());
                }
 
                break;
 
            default: 
                sb.append(c);
        }
    }
 
    
    if(sb.length()>0){
        return new NestedInteger(Integer.parseInt(sb.toString()));
    }
 
    return null;
    }
}
