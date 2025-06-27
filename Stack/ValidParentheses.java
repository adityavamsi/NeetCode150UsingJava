class Question{
    //LC  - 20
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.
    n input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

    Example 1:

    Input: s = "()"
    Output: true

    Example 2:

    Input: s = "()[]{}"
    Output: true

    Example 3:

    Input: s = "(]"
    Output: false

    Example 4:

    Input: s = "([])"
    Output: true

    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

    */
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st =  new Stack();
        for(char ch : s.toCharArray()){
            if(ch=='(') st.push('(');
            else if(ch=='[') st.push('[');
            else if(ch=='{') st.push('{');
            else{
                if(st.empty()) return false;
                else if((st.peek()=='(' && ch==')') || (st.peek()=='[' && ch==']') || (st.peek()=='{' && ch=='}')) st.pop();
                else return false;
            }
        }
        return st.size()==0;

    }
}