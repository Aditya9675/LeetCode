/*

Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int value) Adds the integer value to the stream.
int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.
 

Example 1:

Input
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
Output
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 

Constraints:

0 <= value <= 104
At most 3 * 104 calls will be made to addNum and getIntervals.
 

Follow up: What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?

*/

class SummaryRanges {
  public void addNum(int val) {
    if (map.containsKey(val))
      return;

    final Integer lo = map.lowerKey(val);  
    final Integer hi = map.higherKey(val); 
   
    if (lo != null && hi != null && map.get(lo)[1] + 1 == val && val + 1 == hi) {
      map.get(lo)[1] = map.get(hi)[1];
      map.remove(hi);
    
    } 
    else if (lo != null && map.get(lo)[1] + 1 >= val){
      map.get(lo)[1] = Math.max(map.get(lo)[1], val);
    } 
    else if (hi != null && val + 1 == hi){
      map.put(val, new int[] {val, map.get(hi)[1]});
      map.remove(hi);
    } else {
      map.put(val, new int[] {val, val});
    }
  }

  public int[][] getIntervals() {
    List<int[]> intervals = new ArrayList<>(map.values());
    return intervals.toArray(new int[intervals.size()][]);
  }

  private TreeMap<Integer, int[]> map = new TreeMap<>();
}
