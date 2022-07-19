/*

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/


class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> now = new ArrayList<>();
        helper(0, s, now, ans);
        return ans;
    }
    public void helper(int index, String s, List<String> curr, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i + 1));
                helper(i + 1, s, curr, ans);
                curr.remove(curr.size() - 1); 
            }
        }
    } 
    public boolean isPalindrome(String s, int l, int r){ 
        while(l <= r){
            if(s.charAt(l++) != s.charAt(r--)) 
                return false;
        }
        return true;
    }
}
