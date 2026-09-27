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
    public boolean dfs(TreeNode root, Long lower, Long upper){

        if(root == null) return true;

        if(root.val <= lower || root.val >= upper) return false;

        return dfs(root.left, lower, (long)root.val) && 
               dfs(root.right,(long)root.val, upper);
    }
    public boolean isValidBST(TreeNode root) {
        
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
