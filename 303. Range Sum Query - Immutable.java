/*

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.


*/

class NumArray {

    int[] array;
    public NumArray(int[] nums) {
        if(nums.length > 0) {
            array = new int[nums.length];
            array[0] = nums[0];
            for(int i = 1; i < nums.length; ++i) {
                array[i] = array[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j > array.length) {
            return 0;
        }
        if (i == 0) {
            return array[j];
        }
        return array[j] - array[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int i = 0;
        int j = 5;
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(i,j);
        System.out.println(param_1);
    }
    }
