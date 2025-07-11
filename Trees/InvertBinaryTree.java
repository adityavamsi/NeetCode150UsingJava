class Question{
    //LC - 226
    /*
    Given the root of a binary tree, invert the tree, and return its root.

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

    */
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // public void rev(TreeNode head){ //using recursion
    //     if(head==null) return;
    //     //if(head.left==null || head.right==null) return;
    //     TreeNode temp = head.left;
    //     head.left  = head.right;
    //     head.right = temp;
    //     rev(head.left);
    //     rev(head.right);


    // }
    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        //    rev(root);
        //    return root;
        if(root==null) return root;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size()>0){
            TreeNode temp  = q.poll();
            swap(temp);
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
        return root;


    }
}