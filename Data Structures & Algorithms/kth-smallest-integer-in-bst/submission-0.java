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
    public void inorder(TreeNode root, int k ,List<Integer> arr){

        if(root == null) return;
        inorder(root.left, k , arr);
        arr.add(root.val);
        inorder(root.right, k , arr);
    }
    public int kthSmallest(TreeNode root, int k) {
        
        //inorder : left root right

        //inorder traversal will give sorted array
        List<Integer> arr = new ArrayList<>();

         inorder(root,k,arr);

        return arr.get(k-1);
    }
}
