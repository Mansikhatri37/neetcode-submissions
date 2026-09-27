class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int ansSize = n - k + 1;

        int[] ans = new int[ansSize];
        
        for(int i = 0 ; i <= nums.length - k ; i++){

            int max = Integer.MIN_VALUE;

            //sliding window of length k
            for(int j = i ; j < i+k ; j++){

                max = Math.max(max, nums[j]);
            }

            ans[i] = max;
        }

        return ans;
    }
}
