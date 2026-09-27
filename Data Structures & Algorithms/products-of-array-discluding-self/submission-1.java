class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        
        // Initialize the result array with 1s
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }

        // Compute the product of all elements except the current one
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) { // Exclude the current index
                    arr[i] *= nums[j];
                }
            }
        }

        return arr;
    }
}
