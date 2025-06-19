class Question {
    /* https://leetcode.com/problems/valid-anagram/
    LC-242
    Given two strings s and t , write a function to determine if t is an anagram of s.
    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Constraints:
    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

    Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?
    */
}

class Solution {
    public boolean isAnagram(String s, String t) {

        // Anagrams :- 2 words with same letters but in different order

        if(s.length()!=t.length()) return false;
        Map<Character,Integer> m = new HashMap();
        for(char ch : t.toCharArray()){
            m.put(ch,m.getOrDefault(ch,0)+1);
        }
        for(char ch:s.toCharArray()){
            if(m.containsKey(ch)) m.put(ch,m.get(ch)-1);

        }
        for(Map.Entry<Character,Integer> p:m.entrySet()){
            if(p.getValue()!=0) return false;
        }
        return true;

    }
}