class Solution {

    private int maxSum = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0; // Base case: return 0 for null nodes
        }

        // Recursively find the maximum path sum for left and right subtrees
        int leftMax = Math.max(0, dfs(root.left)); // Ignore negative paths
        int rightMax = Math.max(0, dfs(root.right)); // Ignore negative paths

        // Update the global maxSum to include paths through the current node
        maxSum = Math.max(maxSum, root.val + leftMax + rightMax);

        // Return the maximum sum path that can be extended to the parent node
        return root.val + Math.max(leftMax, rightMax);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}
