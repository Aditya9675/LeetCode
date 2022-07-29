/*


Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.


*/


class NumArray {

    int[] btree;
    int[] arr;
 
    public NumArray(int[] nums) {
        btree = new int[nums.length+1];
        arr = nums;
 
        for(int i=0; i<nums.length; i++){
            add(i+1, nums[i]);
        }
    }
 
    void add(int i, int val) {
        for(int j=i; j<btree.length; j=j+(j&(-j)) ){
            btree[j] += val;
        }
    }
 
    void update(int i, int val) {
        add(i+1, val-arr[i]);
        arr[i]=val;
    }
 
    public int sumRange(int i, int j) {
        return sumHelper(j+1)-sumHelper(i);
    }
 
    public int sumHelper(int i){
        int sum=0;
        for(int j=i; j>=1; j=j-(j&(-j))){
            sum += btree[j];
        }
        return sum;
   
    }
}
