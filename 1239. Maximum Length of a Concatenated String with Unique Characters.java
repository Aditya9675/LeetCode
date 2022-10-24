/*

You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters.

*/


class Solution {
    int found;
    private int NoDuplicate(String s){
        for(int i=0;i<s.length();i++){
            int pos = s.charAt(i)-'a';
            if(((1<<pos)&found)>0){
                return 0;
            }
            found += (1<<pos);
        }
        return 1;
    }
    public int maxLength(List<String> arr) {
        int ans = 0,n = arr.size();
        for(int mask=0;mask<(1<<n);mask++){
            found = 0;
            int len = 0,ok = 1;
            for(int i=0;i<n&&(ok>0);i++){
                if(((1<<i)&mask)>0){
                    if(NoDuplicate(arr.get(i))==0){
                        ok = 0;
                        break;
                    }
                    else{
                        len += arr.get(i).length();
                    }
                }
            }
            if(ok==1){
                ans = Math.max(ans,len);
            }
        }
        return ans;
    }
}
