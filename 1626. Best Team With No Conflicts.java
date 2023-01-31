/*

You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.

However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.

Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams.

 

Example 1:

Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
Output: 34
Explanation: You can choose all the players.
Example 2:

Input: scores = [4,5,6,5], ages = [2,1,2,1]
Output: 16
Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.
Example 3:

Input: scores = [1,2,3,5], ages = [8,9,10,1]
Output: 6
Explanation: It is best to choose the first 3 players. 
 

Constraints:

1 <= scores.length, ages.length <= 1000
scores.length == ages.length
1 <= scores[i] <= 106
1 <= ages[i] <= 1000

*/

class Player{
  public int age;
  public int score;
  public Player(int age, int score){
    this.age = age;
    this.score = score;
  }
};

class Solution {
  public int bestTeamScore(int[] scores, int[] ages) {
    final int n = scores.length;
    Player[] players = new Player[n];
    int[] dp = new int[n];

    for(int i = 0; i < n; ++i)
      players[i] = new Player(ages[i], scores[i]);

    Arrays.sort(players, (a, b) -> a.age == b.age ? b.score - a.score : b.age - a.age);

    for(int i=0;i<n;++i){
      dp[i] = players[i].score;
      for(int j = 0; j < i; ++j)
        if(players[j].score >= players[i].score)
          dp[i] = Math.max(dp[i], dp[j] + players[i].score);
    }

    return Arrays.stream(dp).max().getAsInt();
  }
}
