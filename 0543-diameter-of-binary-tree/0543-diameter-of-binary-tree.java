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
    int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxi;
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        int lefth=height(root.left);
        int righth=height(root.right);
        int dia=lefth+righth;
        maxi=Math.max(maxi,dia);
        return 1+Math.max(lefth,righth);
    }
}