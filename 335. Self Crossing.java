/*

You are given an array of integers distance.

You start at point (0,0) on an X-Y plane and you move distance[0] meters to the north, then distance[1] meters to the west, distance[2] meters to the south, distance[3] meters to the east, and so on. In other words, after each move, your direction changes counter-clockwise.

Return true if your path crosses itself, and false if it does not.

 

Example 1:


Input: distance = [2,1,1,2]
Output: true
Example 2:


Input: distance = [1,2,3,4]
Output: false
Example 3:


Input: distance = [1,1,1,1]
Output: true
 

Constraints:

1 <= distance.length <= 105
1 <= distance[i] <= 105

*/

class Solution {
    public boolean isSelfCrossing(int[] x) {
         if(x==null || x.length<=3) 
        return false;
 
    for(int i=3; i<x.length; i++){
        if(x[i-3] >= x[i-1] && x[i-2]<=x[i]){
            return true;
        }
 
        if(i>=4 && x[i-4]+x[i]>=x[i-2] && x[i-3]==x[i-1])   {
            return true;
        }
 
        if(i>=5 && x[i-5]<=x[i-3] && x[i]<=x[i-2]&& x[i-1]<=x[i-3] && x[i-4]<=x[i-2] && x[i-1]>=x[i-3]-x[i-5] && x[i]>=x[i-2]-x[i-4]){
            return true;
        }
    }
 
    return false;
    }
}
