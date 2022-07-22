/*

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

Constraints:

1 <= n <= 1690

*/

class Solution {
    public int nthUglyNumber(int n) {
          if(n<=0)
        return 0;
 
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(1);
 
    int i=0;
    int j=0;
    int k=0;
 
    while(list.size()<n){
        int m2 = list.get(i)*2;
        int m3 = list.get(j)*3;
        int m5 = list.get(k)*5;
 
        int min = Math.min(m2, Math.min(m3, m5));
        list.add(min);
 
        if(min==m2)
            i++;
 
        if(min==m3)
            j++;
 
        if(min==m5)
            k++;
    }
 
    return list.get(list.size()-1);
    }
}
