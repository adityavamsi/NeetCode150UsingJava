class Question{
    //Lc - 567
    /*
    You are given two strings s1 and s2.
    Return true if s2 contains a permutation of s1, or false otherwise.
    That means if a permutation of s1 exists as a substring of s2, then return true.

    Both strings only contain lowercase letters.

    Example 1:

    Input: s1 = "abc", s2 = "lecabee"

    Output: true
    Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".

    Example 2:

    Input: s1 = "abc", s2 = "lecaabee"

    Output: false
    Constraints:

    1 <= s1.length, s2.length <= 1000


    */
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        //storing characters freq in both the strings
        int [] c1 = new int[26];
        int [] c2 = new int[26];

        //storing the matched freq of character in both the strings
        int matches=0;

        //storing only the charcters till s1 length;
        for(int i=0;i<s1.length();i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++) matches+=(c1[i]==c2[i])?1:0;

        //left pointer
        int l=0;

        //right pointer from s1 length
        for(int r=s1.length();r<s2.length();r++){
            //returns true if matches variable is total(26-alphabets)
            if(matches==26) return true;
            //First adding the freq of r to array;
            int idx = s2.charAt(r)-'a';
            c2[idx]++;
            //checking after adding freq to array, if freq is equal in s1 and s2 ++
            //else if check if increasing freq is directly affecting c1, if yes then dec --;
            if(c1[idx]==c2[idx]) matches++;
            else if(c1[idx]+1 == c2[idx]) matches--;

            //now shrink the window by moving left pointer, maintaining the size of s1
            idx = s2.charAt(l) - 'a';
            c2[idx]--;

            //checking after dec freq to array, if freq is equal in s1 and s2 ++
            //else if check if decreasing freq is directly affecting c1, if yes then dec --;
            if(c1[idx]==c2[idx]) matches++;
            else if(c1[idx]-1 == c2[idx])  matches--;
            l++;
        }
        return matches==26;

    }
}