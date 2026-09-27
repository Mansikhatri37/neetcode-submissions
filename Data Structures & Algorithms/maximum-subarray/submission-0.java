class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // To store the maximum sum
        int currentSum = 0; // To store the current sum
        
        for (int num : nums) {
            currentSum += num; // Add current element to the current sum
            maxSum = Math.max(maxSum, currentSum); // Update maxSum if needed
            if (currentSum < 0) {
                currentSum = 0; // Reset currentSum if it drops below 0
            }
        }
        
        return maxSum;
    }
}
