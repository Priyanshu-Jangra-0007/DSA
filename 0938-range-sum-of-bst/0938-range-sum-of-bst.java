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
    static int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum=0;
        search(root,low,high);
        return sum;
        
    }
    static void search(TreeNode root,int low,int high){
        if(root==null) return ;
        if(low<=root.val && root.val<=high)sum=sum+root.val;
        search(root.left,low,high);
        search(root.right,low,high);
    }
}
