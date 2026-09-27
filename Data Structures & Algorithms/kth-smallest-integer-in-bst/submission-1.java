class Solution {
    private int count = 0; // To track the number of visited nodes
    private int result = 0; // To store the k-th smallest element

    public void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k); // Visit left subtree

        count++;
        if (count == k) { // Found the k-th smallest element
            result = root.val;
            return;
        }

        inorder(root.right, k); // Visit right subtree
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
}
