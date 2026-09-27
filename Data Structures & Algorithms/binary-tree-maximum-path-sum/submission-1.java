class Solution {

    public int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0; // Base case: return 0 for null nodes
        }

        // Maximum sum through left and right subtrees
        int leftMax = findMaxPathSum(root.left);
        int rightMax = findMaxPathSum(root.right);

        // Maximum path sum through the current node
        int maxThroughRoot = root.val + Math.max(0, leftMax) + Math.max(0, rightMax);

        // Update the global maxSum by comparing it with the current node's max sum
        globalMax = Math.max(globalMax, maxThroughRoot);

        // Return the max path sum to the parent that can be extended
        return root.val + Math.max(0, Math.max(leftMax, rightMax));
    }

    private int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return globalMax;
    }
}
