/*

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105

*/

class Solution {
   public int[][] insert(int[][] intervals, int[] newInterval) {
 		int len = intervals.length;
 		int[] starts = new int[len + 1];
 		int[] ends = new int[len + 1];
 		for(int i = 0; i < len; i++){
 			starts[i] = intervals[i][0];
 			ends[i] = intervals[i][1];
 		}
 		starts[len] = newInterval[0]; 
 		ends[len] = newInterval[1];
 		Arrays.sort(starts);
 		Arrays.sort(ends);
 		List<int[]> temp = new ArrayList<>();
 		int start = starts[0];
 		for(int i = 1; i <= len; i++){
 			if(starts[i] > ends[i - 1]){
 				temp.add(new int[]{start, ends[i - 1]});
 				start = starts[i];
 			}
 		}
 		temp.add(new int[]{start, ends[len]});
 		int[][] res = new int[temp.size()][2];
 		for(int i = 0; i < temp.size(); i++){
 			res[i] = temp.get(i);
 		}
 		return res;
    }
}
