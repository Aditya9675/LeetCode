/*

You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.

Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.

Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.

 

Example 1:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
Output: 60
Explanation: 
We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
Example 2:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
Output: 68
Explanation:
This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
Example 3:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
Output: 72
 

Constraints:

1 <= k <= n <= 105
speed.length == n
efficiency.length == n
1 <= speed[i] <= 105
1 <= efficiency[i] <= 108

*/


class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MODULO = 1000000007;
        int[][] speedEfficiencyArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            speedEfficiencyArray[i][0] = speed[i];
            speedEfficiencyArray[i][1] = efficiency[i];
        }
        Arrays.sort(speedEfficiencyArray, new Comparator<int[]>() {
            public int compare(int[] speedEfficiency1, int[] speedEfficiency2) {
                if (speedEfficiency1[1] != speedEfficiency2[1])
                    return speedEfficiency2[1] - speedEfficiency1[1];
                else
                    return speedEfficiency2[0] - speedEfficiency1[0];
            }
        });
        long maxPerformance = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        long speedSum = 0;
        int minEfficiency = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            int[] speedEfficiency = speedEfficiencyArray[i];
            int curSpeed = speedEfficiency[0];
            int curEfficiency = speedEfficiency[1];
            priorityQueue.offer(curSpeed);
            speedSum += curSpeed;
            minEfficiency = Math.min(minEfficiency, curEfficiency);
            long curPerformance = speedSum * (long) minEfficiency;
            maxPerformance = Math.max(maxPerformance, curPerformance);
        }
        for (int i = k; i < n; i++) {
            int prevSpeed = priorityQueue.poll();
            speedSum -= prevSpeed;
            int[] speedEfficiency = speedEfficiencyArray[i];
            int curSpeed = speedEfficiency[0];
            int curEfficiency = speedEfficiency[1];
            priorityQueue.offer(curSpeed);
            speedSum += curSpeed;
            minEfficiency = Math.min(minEfficiency, curEfficiency);
            long curPerformance = speedSum * (long) minEfficiency;
            maxPerformance = Math.max(maxPerformance, curPerformance);
        }
        return (int) (maxPerformance % MODULO);
    }
}
