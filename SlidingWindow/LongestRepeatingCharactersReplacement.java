class Question{
    //LC - 424
    /*
    * Given a string s, find the length of the longest substring without duplicate characters.
    A substring is a contiguous sequence of characters within a string.

    Example 1:

    Input: s = "zxyzxyz"
    Output: 3
    Explanation: The string "xyz" is the longest without duplicate characters.

    Example 2:

    Input: s = "xxxx"
    Output: 1

    Constraints:

    0 <= s.length <= 1000
    s may consist of printable ASCII characters.
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