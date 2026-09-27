class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // Get the absolute value of the current element
            int index = Math.abs(nums[i]);
            
            // If the value at the target index is already negative, we've seen this number before
            if (nums[index] < 0) {
                return index; // Duplicate found
            }
            
            // Mark the position as visited by negating the value at the target index
            nums[index] = -nums[index];
        }
        
        return -1; // This should never be reached if input is guaranteed to have a duplicate
    }
}
