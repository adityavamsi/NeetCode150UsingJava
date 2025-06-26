class Question{
    //LC - 3
    /*
    Given a string s, find the length of the longest substring without duplicate characters.

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

    */
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap();
        int n = s.length();
        int i=0,j=0,c=0;
        while(j<n){
            char ch = s.charAt(j);
            if(mp.containsKey(ch)){
                if(mp.get(ch)>=i) i=mp.get(ch)+1;
            }
            c = Math.max(c,j-i+1);
            mp.put(ch,j);
            j++;
        }
        return c;

    }
}