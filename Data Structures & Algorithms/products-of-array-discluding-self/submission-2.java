

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // Initialize prefix and suffix arrays
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        // Prefix: First element is 1 (no elements to the left)
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }
        
        // Suffix: Last element is 1 (no elements to the right)
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        
        // Calculate the final answer
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }
        
        return ans;
    }
}
