/*
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

1 <= s.length <= 20
s consists of digits only.
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        recurse(s, ans, 0, "", 0);
        return ans;
    }
    private void recurse(String curr, List<String> ans, int index, String temp, int count) {
        if (count > 4){
            return;
        }
        if (count == 4 && index == curr.length()){
            ans.add(temp);
        }
        for (int i=1; i<4; i++) {
            if (index+i > curr.length()){
                break;
            }
            String s = curr.substring(index,index+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)){
                continue;
            }
            recurse(curr, ans, index+i, temp+s+(count==3?"" : "."), count+1);
        }
    }
}
