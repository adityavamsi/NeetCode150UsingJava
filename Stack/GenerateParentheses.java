class Question{
    //LC  -  22
    /*
    You are given an integer n. Return all well-formed parentheses
    strings that you can generate with n pairs of parentheses.

    Example 1:

    Input: n = 1
    Output: ["()"]

    Example 2:

    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    You may return the answer in any order.

    Constraints:

    1 <= n <= 7
    */
}

class Solution {
    public void rec(int open, int close, int n, StringBuilder sb, List<String> ans){
        if(open==close && open==n){
            ans.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            rec(open+1, close, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            rec(open, close+1, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        //StringBuilder sb = new StringBuilder();
        rec(0,0,n,new StringBuilder(),ans);
        return ans;
    }
}