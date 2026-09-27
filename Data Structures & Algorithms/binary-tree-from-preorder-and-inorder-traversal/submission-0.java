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
    public TreeNode helper(int[] preorder, int prelo, int prehi, int[] inorder, int inlo, int inhi, HashMap<Integer,Integer> map){

        if(prelo > prehi || inlo > inhi) return null;

        TreeNode root = new TreeNode(preorder[prelo]);

        int inRootIdx = map.get(preorder[prelo]); // index of root in inorder

        int leftSize = inRootIdx - inlo;

        root.left = helper(preorder, prelo+1, prelo + leftSize,inorder,inlo, inRootIdx-1,map);
        root.right = helper(preorder, prelo + leftSize + 1, prehi, inorder, inRootIdx + 1, inhi, map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i); 
        }

        return helper(preorder, 0, n-1, inorder, 0 , n-1, map);
    }
}
