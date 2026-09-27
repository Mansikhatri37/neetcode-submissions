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
    public int goodNodes(TreeNode root) {
        
        int res = 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, Integer.MIN_VALUE));

        while(!q.isEmpty()){

            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            int maxVal = pair.getValue();

            if(node.val >= maxVal){
                res++;
            }

            maxVal = Math.max(maxVal, node.val);
            if(node.left != null) q.offer(new Pair<>(node.left,maxVal));
            if(node.right != null) q.offer(new Pair<>(node.right,maxVal));
        }

        return res;
    }
}
