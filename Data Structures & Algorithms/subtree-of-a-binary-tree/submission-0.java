class Solution {
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        // Base cases
        if (root == null && subRoot == null) return true; // Both trees are null
        if (root == null || subRoot == null) return false; // One tree is null
        
        // Check current node values and recursively check left and right subtrees
        if (root.val != subRoot.val) return false;
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: If the main tree is null, subRoot cannot be a subtree
        if (root == null) return false;

        // If the trees are identical, subRoot is a subtree
        if (isSameTree(root, subRoot)) return true;

        // Check if subRoot is a subtree of the left or right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
