class Question{
        //LC- 49
        /*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

        Example 1:

        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Explanation:
        There is no string in strs that can be rearranged to form "bat".
        The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
        The strings "ate", "eat", and "tea" are anagrams as they can be rearranged
        to form each other.

        Example 2:
        Input: strs = [""]
        Output: [[""]]

        Example 3:
        Input: strs = ["a"]
        Output: [["a"]]

        Constraints:
                1 <= strs.length <= 104
                0 <= strs[i].length <= 100
        strs[i] consists of lowercase English letters.*/
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] c = new int[26];
        Map<String,ArrayList<String>> mp = new HashMap();
        for(String str : strs){
            for(char s: str.toCharArray()){
                c[s-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(c[i]!=0) {
                    sb.append(c[i]).append((char)('a'+i));
                    c[i]=0;
                }
            }
            String st = sb.toString();
            if(!mp.containsKey(st)) mp.put(st,new ArrayList());
            mp.get(st).add(str);
        }
        return new ArrayList(mp.values());
    }
}