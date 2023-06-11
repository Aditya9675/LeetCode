/*

Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 

Example 1:

Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 

Constraints:

1 <= length <= 5 * 104
0 <= index < length
0 <= val <= 109
0 <= snap_id < (the total number of times we call snap())
At most 5 * 104 calls will be made to set, snap, and get.

*/

class SnapshotArray {
  public SnapshotArray(int length) {
    snaps = new List[length];
    for (int i = 0; i < length; ++i) {
      snaps[i] = new ArrayList<>();
      snaps[i].add(new int[] {0, 0});
    }
  }

  public void set(int index, int val) {
    int[] snap = snaps[index].get(snaps[index].size() - 1);
    if (snap[0] == snap_id)
      snap[1] = val;
    else
      snaps[index].add(new int[] {snap_id, val});
  }

  public int snap() {
    return snap_id++;
  }

  public int get(int index, int snap_id) {
    int i = Collections.binarySearch(snaps[index], new int[] {snap_id, 0},
                                     (a, b) -> Integer.compare(a[0], b[0]));
    if (i < 0)
      i = -i - 2;
    return snaps[index].get(i)[1];
  }

  private List<int[]>[] snaps;
  private int snap_id = 0;
}
