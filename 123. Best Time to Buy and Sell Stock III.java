/*

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105

*/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
		return 0;
	}
 

	int[] left = new int[prices.length];
	int[] right = new int[prices.length];
 
	
	left[0] = 0; 
	int min = prices[0];
	for (int i = 1; i < prices.length; i++) {
		min = Math.min(min, prices[i]);
		left[i] = Math.max(left[i - 1], prices[i] - min);
	}
 
	
	right[prices.length - 1] = 0;
	int max = prices[prices.length - 1];
	for (int i = prices.length - 2; i >= 0; i--) {
		max = Math.max(max, prices[i]);
		right[i] = Math.max(right[i + 1], max - prices[i]);
	}
 
	int profit = 0;
	for (int i = 0; i < prices.length; i++) {
		profit = Math.max(profit, left[i] + right[i]);
	}
 
	return profit;
    }
}
