/*

You are given an array of non-overlapping axis-aligned rectangles rects where rects[i] = [ai, bi, xi, yi] indicates that (ai, bi) is the bottom-left corner point of the ith rectangle and (xi, yi) is the top-right corner point of the ith rectangle. Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles. A point on the perimeter of a rectangle is included in the space covered by the rectangle.

Any integer point inside the space covered by one of the given rectangles should be equally likely to be returned.

Note that an integer point is a point that has integer coordinates.

Implement the Solution class:

Solution(int[][] rects) Initializes the object with the given rectangles rects.
int[] pick() Returns a random integer point [u, v] inside the space covered by one of the given rectangles.
 

Example 1:


Input
["Solution", "pick", "pick", "pick", "pick", "pick"]
[[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
Output
[null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]

Explanation
Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
solution.pick(); // return [1, -2]
solution.pick(); // return [1, -1]
solution.pick(); // return [-1, -2]
solution.pick(); // return [-2, -2]
solution.pick(); // return [0, 0]
 

Constraints:

1 <= rects.length <= 100
rects[i].length == 4
-109 <= ai < xi <= 109
-109 <= bi < yi <= 109
xi - ai <= 2000
yi - bi <= 2000
All the rectangles do not overlap.
At most 104 calls will be made to pick.

*/

class Solution {
    private int total;
    private int[][] rects;
    private int[] presum;
    private Random rand;

    public Solution(int[][] rects){
        this.total = 0;
        this.rects = rects;
        this.presum = new int[rects.length];
        this.rand = new Random();
        for (int i = 0; i < rects.length; i++){
            total += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1) ;
            presum[i] = total;
        }
    }

    public int[] pick(){
        int r = rand.nextInt(total) + 1;
        int i = binarySearch(presum, r);
        r = presum[i] - r;
        int w = rects[i][2] - rects[i][0] + 1;
        int x = rects[i][0] + r % w;
        int y = rects[i][1] + r / w;
        return new int[]{x, y};
    }

    private int binarySearch(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int mi = lo + (hi - lo) / 2;
            if (target > nums[mi]) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }
}
