/*

You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters.

 

Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
Example 2:

Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.
Example 3:

Input: properties = [[1,5],[10,4],[4,3]]
Output: 1
Explanation: The third character is weak because the second character has a strictly greater attack and defense.
 

Constraints:

2 <= properties.length <= 105
properties[i].length == 2
1 <= attacki, defensei <= 105

*/

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
                
        Arrays.sort(properties, new Comparator<int[]>() {
        public int compare(int[] property1, int[] property2) {
            if (property1[0] != property2[0])
                return property1[0] - property2[0];
            else
                return property1[1] - property2[1];
            }
        });
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] property : properties) {
            int attack = property[0], defense = property[1];
            if (defense > map.getOrDefault(attack, 0))
                map.put(attack, defense);
        }
        int count = 0;
        int length = properties.length;
        int index = length - 2;
        while (index >= 0 && properties[index][0] == properties[index + 1][0])
            index--;
        if (index < 0)
            return 0;
        int maxDefense = properties[length - 1][1];
        for (int i = index; i >= 0; i--) {
            int attack = properties[i][0], defense = properties[i][1];
            if (defense < maxDefense)
                count++;
            if (i > 0 && attack > properties[i - 1][0]) {
                int curMaxDefense = map.get(attack);
                maxDefense = Math.max(maxDefense, curMaxDefense);
            }
        }
        return count;
    }
}
