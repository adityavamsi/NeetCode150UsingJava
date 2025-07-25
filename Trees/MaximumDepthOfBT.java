class Question{
    //LC - 104
    /*
    Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
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
    public int maxi(TreeNode root, int c){
        if(root==null) return c;
        // if(root.left==null) maxi(root.right,c);
        // if(root.right==null) maxi(root.left,c);
        return Math.max(maxi(root.left,c+1),maxi(root.right,c+1));
    }
    public int maxDepth(TreeNode root) {

        return maxi(root,0);

    }
}