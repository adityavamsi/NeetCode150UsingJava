class Question{
    //LC - 76
    /*
    Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring.
    If such a substring does not exist, return an empty string "".
    You may assume that the correct output is always unique.

    Example 1:

    Input: s = "OUZODYXAZV", t = "XYZ"
    Output: "YXAZ"
    Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.

    Example 2:

    Input: s = "xyz", t = "xyz"
    Output: "xyz"

    Example 3:

    Input: s = "x", t = "xy"
    Output: ""

    Constraints:

    1 <= s.length <= 1000
    1 <= t.length <= 1000
    s and t consist of uppercase and lowercase English letters.

    */
}

class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        Map<Character,Integer>  req =  new HashMap();
        Map<Character,Integer>  window =  new HashMap();
        for(char ch : t.toCharArray()) req.put(ch,req.getOrDefault(ch,0)+1);
        int i=0,j=0;
        int have=0, need=req.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        while(j<s.length()){
            char ch = s.charAt(j);
            window.put(ch, window.getOrDefault(ch,0)+1);

            if(req.containsKey(ch) && window.get(ch).equals(req.get(ch))) have++;

            while(have==need){

                if((j-i+1)< resLen){
                    resLen = j-i+1;
                    res[0] = i;
                    res[1] = j;
                }

                char leftChar = s.charAt(i);
                window.put(leftChar, window.get(leftChar) - 1);
                if (req.containsKey(leftChar) && window.get(leftChar) < req.get(leftChar)) have--;
                i++;

            }
            j++;

        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}