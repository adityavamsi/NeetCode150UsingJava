class Question{
    //LC  - 155
    /*
    Design a stack class that supports the push, pop, top, and getMin operations.
    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
    Each function should run in O(1) time.

    Example 1:

    Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
    Output: [null,null,null,null,0,null,2,1]

    Explanation:
    MinStack minStack = new MinStack();
    minStack.push(1);
    minStack.push(2);
    minStack.push(0);
    minStack.getMin(); // return 0
    minStack.pop();
    minStack.top();    // return 2
    minStack.getMin(); // return 1

    Constraints:

    -2^31 <= val <= 2^31 - 1.
    pop, top and getMin will always be called on non-empty stacks.

    */
}

class MinStack {
    private Node node;

    public MinStack() {

    }

    public void push(int val) {
        if(node==null) node = new Node(val,val,null);
        else node = new Node(val,Math.min(val,node.min),node);
    }

    public void pop() {
        node=node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }
    private class Node{
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */