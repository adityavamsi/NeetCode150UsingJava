class Question{
    //LC - 424
    /*
    You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.

    After performing at most k replacements, return the length of the longest substring which contains only one distinct character.

    Example 1:

    Input: s = "XYYX", k = 2
    Output: 4
    Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.

    Example 2:

    Input: s = "AAABABB", k = 1
    Output: 5

    Constraints:

    1 <= s.length <= 1000
    0 <= k <= s.length
*/
}

class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length(),maxf=0,maxl=0;
        Map<Character,Integer> mp = new HashMap();
        int i=0;
        for(int j=0;j<n;j++){
            char ch = s.charAt(j);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            maxf  = Math.max(maxf, mp.get(ch));
            while((j-i)+1 - maxf >k){
                mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)-1);
                i++;
            }
            maxl = Math.max(maxl, j-i+1);
        }
        return maxl;

    }
}