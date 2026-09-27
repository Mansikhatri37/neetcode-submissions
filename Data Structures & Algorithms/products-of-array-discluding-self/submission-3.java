class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        
        int[] prefSum = new int[n];
        int[] suffSum = new int[n];

        prefSum[0] = 1;
        suffSum[n-1] = 1;

        for(int i = 1 ; i < n ; i++){
            prefSum[i] = prefSum[i-1] * nums[i-1];
        }

        for(int i = n-2; i >= 0 ; i--){
            suffSum[i] = suffSum[i+1] * nums[i+1];
        }

        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
            res[i] = prefSum[i] * suffSum[i];
        }

        return res;
    }
}  
