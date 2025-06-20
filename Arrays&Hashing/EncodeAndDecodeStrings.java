class Question{
    /* LC - 271(Premium) Encode and Decode Strings
    Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

    Please implement encode and decode

    Example 1:

    Input: ["neet","code","love","you"]
    Output:["neet","code","love","you"]


    Example 2:

    Input: ["we","say",":","yes"]
    Output: ["we","say",":","yes"]

    Constraints:

            0 <= strs.length < 100
            0 <= strs[i].length < 200
    strs[i] contains only UTF-8 characters.

     */

}

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();


    }

    public List<String> decode(String s) {
        int i=0;
        List<String> list = new ArrayList<>();
        while(i<s.length()){
            int hashPos=i;
            while(hashPos<s.length() && s.charAt(hashPos)!='#'){
                hashPos++;
            }
            String len = s.substring(i,hashPos);
            int length = Integer.parseInt(len);
            int subStrStartPos = hashPos+1;
            int subStrEndPos = subStrStartPos+length;
            String substr = s.substring(subStrStartPos,subStrEndPos);
            i=subStrEndPos;
            list.add(substr);

        }
        return list.toArray(new String[0]);

    }
}
