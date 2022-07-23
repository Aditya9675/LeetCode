/*

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         if(prerequisites == null){
        throw new IllegalArgumentException("illegal prerequisites array");
    }
 
    int len = prerequisites.length;
 
    if(numCourses == 0 || len == 0){
        return true;
    }
 
    
    int[] pCounter = new int[numCourses];
    for(int i=0; i<len; i++){
        pCounter[prerequisites[i][0]]++;
    }
 
   
    LinkedList<Integer> queue = new LinkedList<Integer>();
    for(int i=0; i<numCourses; i++){
        if(pCounter[i]==0){
            queue.add(i);
        }
    }
 
   
    int numNoPre = queue.size();
 
    while(!queue.isEmpty()){
        int top = queue.remove();
        for(int i=0; i<len; i++){
           
            if(prerequisites[i][1]==top){
                pCounter[prerequisites[i][0]]--;
                if(pCounter[prerequisites[i][0]]==0){
                    numNoPre++;
                    queue.add(prerequisites[i][0]);
                }
            }
        }
    }
 
    return numNoPre == numCourses;
    }
}
