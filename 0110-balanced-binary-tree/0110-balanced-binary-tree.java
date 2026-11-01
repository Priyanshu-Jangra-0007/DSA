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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int lefth=height(root.left);
        int righth=height(root.right);
        return Math.abs(lefth-righth)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public static int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left) ,height(root.right));
    }
}